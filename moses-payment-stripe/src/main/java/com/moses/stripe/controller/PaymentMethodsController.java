package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.param.PaymentMethodParams;
import com.moses.stripe.service.PaymentMethodsService;
import com.stripe.exception.StripeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Moses
 */
@RestController
@Api("PaymentMethods api")
@RequestMapping(value = "/paymentmethods")
public class PaymentMethodsController extends BaseController {
    @Autowired
    PaymentMethodsService paymentmethodsService;

    @PostMapping("/attachPaymentMethod")
    @ApiOperation(value = "attach Payment Method", notes = "Attach a PaymentMethod to a Customer")
    public BaseResponse attachPaymentMethod(@RequestBody PaymentMethodParams obj) {
        BaseResponse response;
        try {
            paymentmethodsService.attachPaymentMethod(obj);
            response = BaseResponse.success("Attach successfully!");
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/detachPaymentMethod")
    @ApiOperation(value = "detach Payment Method", notes = "Detach a PaymentMethod from a Customer")
    @ApiImplicitParams({@ApiImplicitParam(name = "paymentMethodId", value = "PaymentMethod's id", required = true, dataType = "string", paramType = "query", example = "pm_1GgNQgChx93PucYpozGn7qpc")})
    public BaseResponse detachPaymentMethod(@RequestParam String paymentMethodId) {
        BaseResponse response;
        try {
            paymentmethodsService.detachPaymentMethod(paymentMethodId);
            response = BaseResponse.success("Detach successfully!");
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/queryPaymentMethod")
    @ApiOperation(value = "query Payment Method", notes = "query PaymentMethod object.")
    @ApiImplicitParams({@ApiImplicitParam(name = "customerId", value = "customer's id", required = true, dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA")})
    public BaseResponse queryPaymentMethod(@RequestParam String customerId) {
        BaseResponse response;
        try {
            List<Map<String, Object>> list = paymentmethodsService.queryPaymentMethod(customerId);
            response = BaseResponse.success(list);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
