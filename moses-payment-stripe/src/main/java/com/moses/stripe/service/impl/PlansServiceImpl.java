package com.moses.stripe.service.impl;

import com.moses.framework.util.ObjectUtil;
import com.moses.stripe.param.PlanParams;
import com.moses.stripe.service.PlansService;
import com.stripe.exception.StripeException;
import com.stripe.model.Plan;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Moses
 */
@Service
public class PlansServiceImpl extends BaseService implements PlansService {
    @Override
    public String createPlan(PlanParams obj) throws StripeException {
        init();
        Map<String, Object> params = ObjectUtil.beanToMap(obj);
        Plan plan = Plan.create(params);
        return plan.getId();
    }

    @Override
    public void deletePlan(String planId) throws StripeException {
        init();
        Plan plan = Plan.retrieve(planId);
        Plan deletedPlan = plan.delete();
    }
}


