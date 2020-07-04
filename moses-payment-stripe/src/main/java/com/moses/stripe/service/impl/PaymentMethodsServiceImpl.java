package com.moses.stripe.service.impl;

import com.moses.framework.util.ObjectUtil;
import com.moses.stripe.param.PaymentMethodParams;
import com.moses.stripe.service.PaymentMethodsService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;
import com.stripe.model.PaymentMethodCollection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 */
@Service
public class PaymentMethodsServiceImpl extends BaseService implements PaymentMethodsService {
    @Override
    public void attachPaymentMethod(PaymentMethodParams obj) throws StripeException {
        init();
        Map<String, Object> params = ObjectUtil.beanToMap(obj);
        Map<String, Object> paymentMethodParam = new HashMap<>();
        paymentMethodParam.put("type", params.get("type"));
        paymentMethodParam.put("card", params.get("card"));
        PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodParam);
        Map<String, Object> customerParam = new HashMap<>();
        customerParam.put("customer", params.get("customer"));
        paymentMethod = paymentMethod.attach(customerParam);
    }

    @Override
    public void detachPaymentMethod(String paymentMethodId) throws StripeException {
        init();
        PaymentMethod paymentMethod = PaymentMethod.retrieve(paymentMethodId);
        paymentMethod.detach();
    }

    @Override
    public List<Map<String, Object>> queryPaymentMethod(String customerId) throws StripeException {
        init();
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerId);
        params.put("type", "card");
        List<Map<String, Object>> cardList = new ArrayList<>();
        PaymentMethodCollection paymentMethods = PaymentMethod.list(params);
        List<PaymentMethod> list = paymentMethods.getData();
        PaymentMethod.Card card;
        for (PaymentMethod pm : list) {
            card = pm.getCard();
            Map<String, Object> map = new HashMap<>();
            map.put("id", pm.getId());
            map.put("country", card.getCountry());
            map.put("funding", card.getFunding());
            map.put("expYear", card.getExpYear());
            map.put("expMonth", card.getExpMonth());
            map.put("last4", card.getLast4());
            cardList.add(map);
        }
        return cardList;
    }
}


