/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service.impl;

import com.moses.demo.model.Customer;
import com.moses.demo.repository.CustomerRepository;
import com.moses.demo.service.CustomerService;
import com.moses.demo.vo.CustomerVo;
import com.moses.framework.common.base.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getPageList() {
        return getPageList(new CustomerVo());
    }

    @Override
    public Page<Customer> getPageList(CustomerVo vo) {
        Specification specification = (Specification<Customer>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (vo.getCurrentState() != null && StringUtils.isNotEmpty(vo.getCurrentState())) {
                predicates.add(cb.equal(root.get("currentState"), vo.getCurrentState()));
            }
            if (vo.getCustomerLevel() != null && StringUtils.isNotEmpty(vo.getCustomerLevel())) {
                predicates.add(cb.equal(root.get("customerLevel"), vo.getCustomerLevel()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return customerRepository.findAll(specification, buildPageRequest(vo.getPageNum(), vo.getPageSize()));
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        init(customer);
        customer.setCreateDate(new Date());
        customerRepository.save(customer);
    }

    private void init(Customer customer) {
        String identityCard = customer.getIdentityCard();
        if (identityCard.length() == 15 || identityCard.length() == 18) {
            customer.setAge(getAge(identityCard));
        }
        //负债(万元)=信贷余额(万元)+信用卡已使用额度(万元)
        double creditBalance = customer.getCreditBalance();
        double creditUsedAmount = customer.getCreditUsedAmount();
        double debts = creditBalance + creditUsedAmount;
        customer.setDebts(debts);
        //信用卡使用率=信用卡总额度(万元)-信用卡已使用额度(万元)/信用卡总额度(万元)
        double creditTotal = customer.getCreditTotal();
        if (creditTotal > 0) {
            double creditCardUsage = (creditTotal - creditUsedAmount) / creditTotal;
            customer.setCreditCardUsage(creditCardUsage);
        }
    }

    private long getAge(String identityCard) {
        long age = 0;
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DATE);
        int year = Integer.valueOf(identityCard.substring(6, 10));
        int month = Integer.valueOf(identityCard.substring(10, 12));
        int day = Integer.valueOf(identityCard.substring(12, 14));
        if (month < monthNow || (month == monthNow && day <= dayNow)) {
            age = yearNow - year;
        } else {
            age = yearNow - year - 1;
        }
        return age;
    }

    @Override
    public void edit(Customer customer) {
        init(customer);
        customer.setModifyDate(new Date());
        customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void importCustomer(MultipartFile file) {
        List<Customer> customers = new ArrayList<>();
        if (file.isEmpty()) {
            throw new RuntimeException("文件错误");
        }
        try {
            //获得上传的excel文件
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            //获取第一个sheet
            HSSFSheet sheet = workbook.getSheetAt(0);
            //获取行数
            int rowNums = sheet.getPhysicalNumberOfRows();
            Customer customer;
            //遍历行数
            for (int i = 1; i < rowNums; i++) {
                customer = new Customer();
                //得到该行的数据
                HSSFRow row = sheet.getRow(i);
                //获得该行的单元格数量，并遍历出单元格
                int cellNums = row.getPhysicalNumberOfCells();
                for (int j = 0; j < cellNums; j++) {
                    HSSFCell cell = row.getCell(j);
                    if (cell != null) {
                        //开始填装Emp实体属性
                        String value = cell.getStringCellValue();
                        if (value != null) {
                            assembling(customer, j, value);
                        }
                    }
                }
                //一个完整emp
                // 将添加好的emp添加到list
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        customerRepository.saveAll(customers);
    }

    private void assembling(Customer customer, int j, String value) {
        switch (j) {
            case 1:
                customer.setUserId(value);
                break;
            case 2:
                customer.setUserName(value);
                break;
            case 3:
                customer.setTel(value);
                break;
            case 4:
                if (value == null) {
                    customer.setLoanAmount(0);
                } else {
                    customer.setLoanAmount(Double.valueOf(value));
                }
                break;
            case 5:
                if (value == null) {
                    customer.setLoanTerm(0);
                } else {
                    customer.setLoanTerm(Integer.valueOf(value));
                }
                break;
            case 6:
                customer.setCity(value);
                break;
            case 7:
                customer.setIntendedProducts(value);
                break;
            case 8:
                customer.setAddTime(value);
                break;
            case 9:
                customer.setCustomerOwnership(value);
                break;
            case 10:
                customer.setCustomerLevel(value);
                break;
            case 11:
                customer.setCurrentState(value);
                break;
            case 12:
                customer.setSource(value);
                break;
            case 13:
                customer.setFollowers(value);
                break;
            case 14:
                customer.setFollowUpTime(value);
                break;
        }
    }
}


