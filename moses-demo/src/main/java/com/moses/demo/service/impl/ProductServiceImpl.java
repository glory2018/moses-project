/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service.impl;

import com.moses.demo.model.Product;
import com.moses.demo.repository.ProductRepository;
import com.moses.demo.service.ProductService;
import com.moses.demo.vo.ProductVo;
import com.moses.framework.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getPageList() {
        return getPageList(new ProductVo());
    }

    @Override
    public Page<Product> getPageList(ProductVo vo) {
        return productRepository.findAll(buildPageRequest(vo.getPageNum(), vo.getPageSize()));
    }

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void save(Product product) {
        init(product);
        product.setCreateDate(new Date());
        productRepository.save(product);
    }

    private void init(Product product) {
        //负债(万元)=信贷余额(万元)+信用卡已使用额度(万元)
        double creditBalance = product.getCreditBalance();
        double creditUsedAmount = product.getCreditUsedAmount();
        double debts = creditBalance + creditUsedAmount;
        product.setDebts(debts);
        //信用卡使用率=信用卡总额度(万元)-信用卡已使用额度(万元)/信用卡总额度(万元)
        double creditTotal = product.getCreditTotal();
        if (creditTotal > 0) {
            double creditCardUsage = (creditTotal - creditUsedAmount) / creditTotal;
            product.setCreditCardUsage(creditCardUsage);
        }
    }

    @Override
    public void edit(Product product) {
        init(product);
        product.setModifyDate(new Date());
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}


