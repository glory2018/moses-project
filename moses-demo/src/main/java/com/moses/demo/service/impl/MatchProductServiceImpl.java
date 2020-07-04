/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service.impl;

import com.moses.demo.model.Customer;
import com.moses.demo.model.Product;
import com.moses.demo.repository.CustomerRepository;
import com.moses.demo.repository.ProductRepository;
import com.moses.demo.service.MatchProductService;
import com.moses.framework.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Service
public class MatchProductServiceImpl extends BaseServiceImpl implements MatchProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Product> getMatchList(long id) {
        Customer customer = customerRepository.getOne(id);
        return productRepository.getMatchList(customer);
    }
}


