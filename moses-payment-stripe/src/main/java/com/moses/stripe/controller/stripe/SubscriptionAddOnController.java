package com.moses.stripe.controller.stripe;

import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.common.Constant;
import com.moses.framework.common.base.BaseController;
import com.moses.stripe.param.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.Plan;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/subscription-add-on")
public class SubscriptionAddOnController extends BaseController {
    @RequestMapping("/index")
    public String index() {
        return "card/subscription-add-on";
    }

    @ResponseBody
    @GetMapping("/create-plan")
    public Plan createPlan() {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        Map<String, Object> product = new HashMap<>();
        product.put("name", "Gold special");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", 5000);
        params.put("currency", "hkd");
        params.put("interval", "month");
        params.put("product", product);
        Plan plan = null;
        try {
            plan = Plan.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return plan;
    }

    @ResponseBody
    @PostMapping("/create-checkout-session")
    public Map<String, Object> create(@RequestBody PaymentRequest postBody) {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        String domainUrl = Constant.DOMAIN;
        String planId = Constant.SUBSCRIPTION_PLAN_ID;
        // Create subscription
        SessionCreateParams.Builder builder = new SessionCreateParams.Builder();
        SessionCreateParams.SubscriptionData.Item plan = new SessionCreateParams.SubscriptionData.Item.Builder().setPlan(planId).build();
        SessionCreateParams.SubscriptionData subscriptionData = new SessionCreateParams.SubscriptionData.Builder().addItem(plan).build();
        builder.setSuccessUrl(domainUrl + "/success.html?session_id={CHECKOUT_SESSION_ID}").setCancelUrl(domainUrl + "/cancel.html")
                .setSubscriptionData(subscriptionData).addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD);
//        if (postBody.getIsBuyingSticker()) {
//            // Add a line item for the sticker the Customer is purchasing
//            SessionCreateParams.LineItem item = new SessionCreateParams.LineItem.Builder().setName("Pasha e-book").setAmount(new Long(300))
//                    .setQuantity(new Long(1)).setCurrency("usd").build();
//            builder.addLineItem(item);
//        }
        SessionCreateParams createParams = builder.build();
        Map<String, Object> responseData = new HashMap<>();
        try {
            Session session = Session.create(createParams);
            responseData.put("checkoutSessionId", session.getId());
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
                EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
                System.out.println(deserializer.getRawJson());
//                Session session = GSON.fromJson(deserializer.getRawJson(), Session.class);
//                Customer customer = null;
//                try {
//                    customer = Customer.retrieve(session.getCustomer());
//                } catch (StripeException e) {
//                    e.printStackTrace();
//                }
//                if (session.getDisplayItems().size() > 0
//                        && session.getDisplayItems().get(0).getAmount().equals(new Long(300))) {
//                    System.out.println("🔔  Customer is subscribed and bought an e-book! Send the e-book to "
//                            + customer.getEmail());
//                } else {
//                    System.out.println("🔔  Customer is subscribed but did not buy an e-book.");
//                }
                break;
            default:
                // Other event type
                System.out.println("Received event " + event.getType());
                break;
        }
        return BaseResponse.success("Customer is subscribed!");
    }
}
