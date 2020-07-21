package com.moses.stripe.controller.stripe;

import com.moses.framework.common.base.BaseController;
import com.moses.stripe.common.Constant;
import com.moses.stripe.param.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/declining")
public class DecliningController extends BaseController {
    @RequestMapping("/index")
    public String index() {
        return "card/declining-authentication";
    }

    @ResponseBody
    @PostMapping("/pay")
    public Map<String, Object> create(@RequestBody PaymentRequest confirmRequest) {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        PaymentIntent intent = null;
        Map<String, Object> map = new HashMap<>();
        try {
            int orderAmount = calculateOrderAmount(confirmRequest.getItems());
            // Create new PaymentIntent with a PaymentMethod ID from the client.
            PaymentIntentCreateParams.Builder createParamsBuilder = new PaymentIntentCreateParams.Builder()
                    .setCurrency(confirmRequest.getCurrency()).setAmount(new Long(orderAmount))
                    .setPaymentMethod(confirmRequest.getPaymentMethodId())
                    .setErrorOnRequiresAction(true).setConfirm(true);
            PaymentIntentCreateParams createParams = createParamsBuilder.build();
            intent = PaymentIntent.create(createParams);
            System.out.println("💰 Payment received!");
            // The payment is complete and the money has been moved
            // You can add any post-payment code here (e.g. shipping, fulfillment, etc)
            // Send the client secret to the client to use in the demo
            map.put("clientSecret", intent.getClientSecret());
        } catch (StripeException err) {
            // Handle "hard declines" e.g. insufficient funds, expired card, etc
            // See https://stripe.com/docs/declines/codes for more
            if ("authentication_required".equals(err.getCode())) {
                map.put("error", "This card requires authentication in order to proceeded. Please use a different card");
            } else {
                map.put("error", err.getMessage());
            }
        }
        return map;
    }

    private int calculateOrderAmount(Object[] items) {
        return 1400;
    }
}
