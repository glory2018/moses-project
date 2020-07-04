package com.moses.stripe.service;

import com.moses.stripe.entity.CustomerEntity;
import com.moses.stripe.param.CustomerParams;
import com.stripe.exception.StripeException;

import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface CustomerService {
    public Map<String, Object> createCustomer(CustomerParams customerParams) throws StripeException;

    CustomerEntity queryCustomer(String userId);
}
