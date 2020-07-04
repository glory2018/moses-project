package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.param.PlanParams;
import com.moses.stripe.service.PlansService;
import com.stripe.exception.StripeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Moses
 */
@RestController
@Api("Plans api")
@RequestMapping(value = "/plans")
public class PlansController extends BaseController {
    @Autowired
    PlansService plansService;

    @PostMapping("/createPlan")
    @ApiOperation(value = "create Plan", notes = "You can create plans using the API, or in the Stripe Dashboard.")
    public BaseResponse createPlan(@RequestBody PlanParams obj) {
        BaseResponse response;
        try {
            String id = plansService.createPlan(obj);
            response = BaseResponse.success(id);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/deletePlan")
    @ApiOperation(value = "delete Plan", notes = "Deleting plans means new subscribers can’t be added. Existing subscribers aren’t affected.")
    @ApiImplicitParams({@ApiImplicitParam(name = "planId", value = "customer's id", required = true, dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA")})
    public BaseResponse deletePlan(@RequestParam String planId) {
        BaseResponse response;
        try {
            plansService.deletePlan(planId);
            response = BaseResponse.success("Deleting successfully");
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
