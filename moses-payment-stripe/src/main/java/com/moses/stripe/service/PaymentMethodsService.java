package com.moses.stripe.service;

import com.moses.stripe.param.PaymentMethodParams;
import com.stripe.exception.StripeException;

import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface PaymentMethodsService {
    void attachPaymentMethod(PaymentMethodParams obj) throws StripeException;

    void detachPaymentMethod(String paymentMethodId) throws StripeException;

    List<Map<String, Object>> queryPaymentMethod(String customerId) throws StripeException;
}
