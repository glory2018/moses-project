package com.moses.stripe.service.impl;

import com.moses.stripe.common.Constant;
import com.stripe.Stripe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Moses
 */
public class BaseService {
    protected Logger logger = LoggerFactory.getLogger(BaseService.class);

    public void init() {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
    }
}


