package com.moses.stripe.controller.stripe;

import com.moses.stripe.common.Constant;
import com.moses.framework.common.base.BaseController;
import com.moses.stripe.param.PaymentRequest;
import com.stripe.Stripe;
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
@RequestMapping(value = "/without")
public class WithoutController extends BaseController {
    @RequestMapping("/index")
    public String index() {
        return "card/without-webhooks";
    }

    @ResponseBody
    @PostMapping("/pay")
    public Map<String, Object> create(@RequestBody PaymentRequest confirmRequest) {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        PaymentIntent intent = null;
        Map<String, Object> map = new HashMap<>();
        try {
            if (confirmRequest.getPaymentMethodId() != null) {
                int orderAmount = calculateOrderAmount(confirmRequest.getItems());
                // Create new PaymentIntent with a PaymentMethod ID from the client.
                PaymentIntentCreateParams.Builder createParamsBuilder = new PaymentIntentCreateParams.Builder()
                        .setCurrency(confirmRequest.getCurrency()).setAmount(new Long(orderAmount))
                        .setPaymentMethod(confirmRequest.getPaymentMethodId())
                        .setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.MANUAL).setConfirm(true);
//                if (confirmRequest.getUseStripeSdk()) {
//                    // If a mobile client passes `useStripeSdk`, set `use_stripe_sdk=true`
//                    // to take advantage of new authentication features in mobile SDKs
//                    createParamsBuilder.setUseStripeSdk(confirmRequest.getUseStripeSdk());
//                }
                PaymentIntentCreateParams createParams = createParamsBuilder.build();
                intent = PaymentIntent.create(createParams);
                // After create, if the PaymentIntent's status is succeeded, fulfill the order.
            } else if (confirmRequest.getPaymentIntentId() != null) {
                // Confirm the PaymentIntent to finalize payment after handling a required
                // action on the client.
                intent = PaymentIntent.retrieve(confirmRequest.getPaymentIntentId());
                intent = intent.confirm();
                // After confirm, if the PaymentIntent's status is succeeded, fulfill the order.
            }
            generateResponse(intent, map);
        } catch (Exception e) {
            // Handle "hard declines" e.g. insufficient funds, expired card, etc
            // See https://stripe.com/docs/declines/codes for more
            map.put("error", e.getMessage());
        }
        return map;
    }

    private int calculateOrderAmount(Object[] items) {
        return 1400;
    }

    private void generateResponse(PaymentIntent intent, Map<String, Object> map) {
        switch (intent.getStatus()) {
            case "requires_action":
            case "requires_source_action":
                // Card requires authentication
                map.put("clientSecret", intent.getClientSecret());
                map.put("requiresAction", true);
                break;
            case "requires_payment_method":
            case "requires_source":
                // Card was not properly authenticated, suggest a new payment method
                map.put("error", "Your card was denied, please provide a new payment method");
                break;
            case "succeeded":
                System.out.println("💰 Payment received!");
                // Payment is complete, authentication not required
                // To cancel the payment you will need to issue a Refund
                // (https://stripe.com/docs/api/refunds)
                map.put("clientSecret", intent.getClientSecret());
                break;
            default:
                map.put("error", "Unrecognized status");
        }
    }
}
