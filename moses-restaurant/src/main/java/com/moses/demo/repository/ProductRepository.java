/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.repository;

import com.moses.demo.model.Customer;
import com.moses.demo.model.Product;
import com.moses.framework.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface ProductRepository extends BaseRepository<Product> {
    /**
     * 查询用户匹配产品
     *
     * @param customer
     * @return
     */
    @Query(value = "from Product t WHERE t.minAge <= :#{#customer.getAge()} and t.maxAge >= :#{#customer.getAge()}" +
            " and (t.city is null or t.city = '' or t.city=:#{#customer.getCity()})" +
            " and (t.overdue is null or t.overdue = '' or t.overdue=:#{#customer.getOverdue()})" +
            " and (t.isCredit is null or t.isCredit = '' or t.isCredit=:#{#customer.getIsCredit()})" +
            " and (t.businessLicense is null or t.businessLicense = '' or t.businessLicense=:#{#customer.getBusinessLicense()})" +
            " and (t.businessLicensePeriod = 0 or t.businessLicensePeriod<=:#{#customer.getBusinessLicensePeriod()})" +
            " and (t.creditBalance = 0 or t.creditBalance<=:#{#customer.getCreditBalance()})" +
            " and (t.creditUsedAmount = 0 or t.creditUsedAmount<=:#{#customer.getCreditUsedAmount()})" +
            " and (t.creditTotal = 0 or t.creditTotal<=:#{#customer.getCreditTotal()})" +
            " and (t.debts = 0 or t.debts<=:#{#customer.getDebts()})" +
            " and (t.smallLoansNum = 0 or t.smallLoansNum<=:#{#customer.getSmallLoansNum()})" +
            " and (t.smallLoanBalance = 0 or t.smallLoanBalance<=:#{#customer.getSmallLoanBalance()})" +
            " and (t.houseLocation is null or t.houseLocation = '' or t.houseLocation=:#{#customer.getHouseLocation()})" +
            " and (t.houseType is null or t.houseType = '' or t.houseType=:#{#customer.getHouseType()})" +
            " and (t.houseValue = 0 or t.houseValue<=:#{#customer.getHouseValue()})" +
            " and (t.vehicleType is null or t.vehicleType = '' or t.vehicleType=:#{#customer.getVehicleType()})" +
            " and (t.vehicleValue = 0 or t.vehicleValue<=:#{#customer.getVehicleValue()})" +
            " and (t.lengthOfService = 0 or t.lengthOfService<=:#{#customer.getLengthOfService()})" +
            " and (t.salary = 0 or t.salary<=:#{#customer.getSalary()})" +
            " and (t.socialSecurityTime = 0 or t.socialSecurityTime<=:#{#customer.getSocialSecurityTime()})" +
            " and (t.socialSecurityAmount = 0 or t.socialSecurityAmount<=:#{#customer.getSocialSecurityAmount()})" +
            " and (t.accumulationFundTime = 0 or t.accumulationFundTime<=:#{#customer.getAccumulationFundTime()})" +
            " and (t.accumulationFundAmount = 0 or t.accumulationFundAmount<=:#{#customer.getAccumulationFundAmount()})" +
            " and (t.accumulationFundIndividual = 0 or t.accumulationFundIndividual<=:#{#customer.getAccumulationFundIndividual()})" +
            " and (t.lowProfitLoan = 0 or t.lowProfitLoan<=:#{#customer.getLowProfitLoan()})" +
            " and (t.personalDetailed = 0 or t.personalDetailed<=:#{#customer.getPersonalDetailed()})" +
            " and (t.companyDetailed = 0 or t.companyDetailed<=:#{#customer.getCompanyDetailed()})")
    List<Product> getMatchList(Customer customer);
}
