package com.moses.stripe.service;

import com.moses.stripe.param.PaymentParams;
import com.moses.stripe.param.PaymentRequest;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;

import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface PaymentsService {
    Map<String, Object> createPaymentIntent(PaymentParams postBody) throws StripeException;

    Map<String, Object> createSetupIntent(String id) throws StripeException;

    String webhook(String payload, String sigHeader, String endpointSecret) throws SignatureVerificationException;

    Map<String, Object> chargeCard(PaymentRequest postBody) throws StripeException;

    void cancelPaymentIntent(String paymentIntentId) throws StripeException;

    List queryPaymentIntent(String customerId) throws StripeException;
}
