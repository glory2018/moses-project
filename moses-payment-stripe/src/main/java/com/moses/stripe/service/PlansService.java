package com.moses.stripe.service;

import com.moses.stripe.param.PlanParams;
import com.stripe.exception.StripeException;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface PlansService {
    String createPlan(PlanParams obj) throws StripeException;

    void deletePlan(String planId) throws StripeException;
}
