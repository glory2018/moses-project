package com.moses.stripe.controller.stripe;

import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.common.Constant;
import com.moses.framework.common.base.BaseController;
import com.moses.stripe.param.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/subscription")
public class SubscriptionSingleController extends BaseController {
    @RequestMapping("/index")
    public String index() {
        return "card/subscription";
    }

    @ResponseBody
    @PostMapping("/create-checkout-session")
    public Map<String, Object> create(@RequestBody PaymentRequest postBody) {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        String domainUrl = Constant.DOMAIN;
        SessionCreateParams.Builder builder = new SessionCreateParams.Builder();
        // Create new Checkout Session for the order
        // Other optional params include:
        // [billing_address_collection] - to display billing address details on the page
        // [customer] - if you have an existing Stripe Customer ID
        // [payment_intent_data] - lets capture the payment later
        // [customer_email] - lets you prefill the email input in the form
        // For full details see https://stripe.com/docs/api/checkout/sessions/create
        // ?session_id={CHECKOUT_SESSION_ID} means the redirect will have the session ID
        // set as a query param
        builder.setSuccessUrl(domainUrl + "/success?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(domainUrl + "/canceled").addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD);
        // Add a line item for the sticker the Customer is purchasing
        SessionCreateParams.SubscriptionData.Item plan = new SessionCreateParams.SubscriptionData.Item.Builder().setPlan("planid").build();
        SessionCreateParams.SubscriptionData subscriptionData = new SessionCreateParams.SubscriptionData.Builder().addItem(plan).build();
        builder.setSubscriptionData(subscriptionData);
        SessionCreateParams createParams = builder.build();
        Map<String, Object> responseData = new HashMap<>();
        try {
            Session session = Session.create(createParams);
            responseData.put("sessionId", session.getId());
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    @ResponseBody
    @PostMapping("/webhook")
    public BaseResponse webhook(HttpServletRequest request, @RequestBody String payload) {
        String sigHeader = request.getHeader("Stripe-Signature");
        String endpointSecret = Constant.STRIPE_WEBHOOK_SECRET;
        Event event = null;
        try {
            event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        } catch (SignatureVerificationException e) {
            // Invalid signature
            return BaseResponse.fail("Payment failed!");
        }
        switch (event.getType()) {
            case "checkout.session.completed":
                return BaseResponse.success("Payment succeeded!");
            default:
                // Unexpected event type
                return BaseResponse.fail("Payment failed!");
        }
    }
}
