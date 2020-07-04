package com.moses.stripe.service;

import com.moses.stripe.param.SubscriptionParams;
import com.stripe.exception.StripeException;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface SubscriptionsService {
    String createSubscription(SubscriptionParams obj) throws StripeException;
}
