package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.common.Constant;
import com.moses.stripe.param.PaymentParams;
import com.moses.stripe.service.PaymentsService;
import com.stripe.exception.StripeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 */
@RestController
@Api("payments api")
@RequestMapping(value = "/payments")
public class PaymentsController extends BaseController {
    @Autowired
    PaymentsService paymentsService;

    @PostMapping("/createPaymentIntent")
    @ApiOperation(value = "create Payment Intent", notes = "Securely accept card payments online.")
    public BaseResponse createPaymentIntent(@RequestBody PaymentParams postBody) {
        BaseResponse response;
        try {
            Map<String, Object> map = paymentsService.createPaymentIntent(postBody);
            response = BaseResponse.success(map);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/cancelPaymentIntent")
    @ApiOperation(value = "Cancel Payment Intent", notes = "Cancel a PaymentIntent.")
    @ApiImplicitParams({@ApiImplicitParam(name = "paymentIntentId", value = "PaymentIntent's id", required = true, dataType = "string", paramType = "query", example = "pi_1GgLo2Chx93PucYpfhLHPSgl")})
    public BaseResponse cancelPaymentIntent(@RequestParam String paymentIntentId) {
        BaseResponse response;
        try {
            paymentsService.cancelPaymentIntent(paymentIntentId);
            response = BaseResponse.success("Cancel successfully!");
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/queryPaymentIntent")
    @ApiOperation(value = "query Payment Intent", notes = "Returns a list of PaymentIntents.")
    @ApiImplicitParams({@ApiImplicitParam(name = "customerId", value = "customer's id", required = true, dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA")})
    public BaseResponse queryPaymentIntent(@RequestParam String customerId) {
        BaseResponse response;
        try {
            List list = paymentsService.queryPaymentIntent(customerId);
            response = BaseResponse.success(list);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/createSetupIntent")
    @ApiOperation(value = "Set up later payments", notes = "save card details and charge your customers later.")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "customer's id", required = true, dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA")})
    public BaseResponse createSetupIntent(@RequestParam String id) {
        BaseResponse response;
        try {
            Map<String, Object> map = paymentsService.createSetupIntent(id);
            response = BaseResponse.success(map);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/webhook")
    @ApiOperation(value = "webhook", notes = "Triggering actions with webhooks")
    public BaseResponse webhook(HttpServletRequest request, @RequestBody String payload) {
        BaseResponse response;
        try {
            String sigHeader = request.getHeader("Stripe-Signature");
            String endpointSecret = Constant.STRIPE_WEBHOOK_SECRET;
            String message = paymentsService.webhook(payload, sigHeader, endpointSecret);
            response = BaseResponse.success(message);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
//    @PostMapping("/chargeCard")
//    @ApiOperation(value = "Charge the saved card later", notes = "When you are ready to charge your customer off-session, use the Customer and PaymentMethod IDs to create a PaymentIntent.")
//    public PaymentResponse chargeCard(@RequestBody PaymentRequest postBody) {
//        return paymentsService.chargeCard(postBody);
//    }
}
