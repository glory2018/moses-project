package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.param.SubscriptionParams;
import com.moses.stripe.service.SubscriptionsService;
import com.stripe.exception.StripeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Moses
 */
@RestController
@Api("Subscriptions api")
@RequestMapping(value = "/subscriptions")
public class SubscriptionsController extends BaseController {
    @Autowired
    SubscriptionsService subscriptionsService;

    @PostMapping("/createSubscription")
    @ApiOperation(value = "create Subscription", notes = "Creates a new subscription on an existing customer.")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "customer", required = true, value = "The identifier of the customer to subscribe.", dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA"),
//            @ApiImplicitParam(name = "items", required = true, value = "A list of up to 20 subscription items, each with an attached plan.", dataType = "application/json", paramType = "query", example = "{\"plan\": \"plan_HEYDPM19d4x4U1\"}")
//    })
    public BaseResponse createSubscription(@RequestBody SubscriptionParams obj) {
        BaseResponse response;
        try {
            String id = subscriptionsService.createSubscription(obj);
            response = BaseResponse.success(id);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
