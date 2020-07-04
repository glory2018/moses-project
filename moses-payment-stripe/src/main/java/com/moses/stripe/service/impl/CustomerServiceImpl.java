package com.moses.stripe.service.impl;

import com.moses.framework.util.ObjectUtil;
import com.moses.stripe.common.Constant;
import com.moses.stripe.entity.CustomerEntity;
import com.moses.stripe.param.CustomerParams;
import com.moses.stripe.repository.CustomerRepository;
import com.moses.stripe.service.CustomerService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void init() {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
    }

    @Override
    public Map<String, Object> createCustomer(CustomerParams customerParams) throws StripeException {
        init();
        Map<String, Object> params = ObjectUtil.beanToMap(customerParams);
        params.remove("userId");
        params.put("address", ObjectUtil.beanToMap(customerParams.getAddress()));
        Map<String, Object> result = new HashMap<>();
        Customer customer = Customer.create(params);
        result.put("customerId", customer.getId());
        CustomerEntity entity = new CustomerEntity();
        entity.setUserId(customerParams.getUserId());
        entity.setCustomerId(customer.getId());
        entity.setEmail(customerParams.getEmail());
        repository.save(entity);
        return result;
    }

    @Override
    public CustomerEntity queryCustomer(String userId) {
        return repository.findByUserId(userId);
    }
}


