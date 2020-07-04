package com.moses.stripe.service.impl;

import com.moses.stripe.common.Constant;
import com.moses.stripe.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@Service
public class IndexServiceImpl extends BaseService implements IndexService {
    @Override
    public Map<String, Object> config() {
        Map<String, Object> responseData = new HashMap<>(3);
        responseData.put("publicKey", Constant.STRIPE_PUBLISHABLE_KEY);
        responseData.put("basePrice", Constant.BASE_PRICE);
        responseData.put("currency", Constant.CURRENCY);
        return responseData;
    }
}


