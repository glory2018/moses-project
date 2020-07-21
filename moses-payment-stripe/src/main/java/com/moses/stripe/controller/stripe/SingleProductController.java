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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/product")
public class SingleProductController extends BaseController {
    @RequestMapping("/single")
    public String single() {
        return "product/single";
    }

    @ResponseBody
    @PostMapping("/create-checkout-session")
    public Map<String, Object> create(@RequestBody PaymentRequest postBody) {
//        String domainUrl = Constant.DOMAIN;
//        Long basePrice = new Long(Constant.BASE_PRICE);
//        Long quantity = postBody.getQuantity();
//        String currency = Constant.CURRENCY;
        // Create new Checkout Session for the order
        // Other optional params include:
        // [billing_address_collection] - to display billing address details on the page
        // [customer] - if you have an existing Stripe Customer ID
        // [payment_intent_data] - lets capture the payment later
        // [customer_email] - lets you prefill the email input in the form
        // For full details see https://stripe.com/docs/api/checkout/sessions/create
        // ?session_id={CHECKOUT_SESSION_ID} means the redirect will have the session ID
        // set as a query param
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        List<Object> lineItems = new ArrayList<>();
        Map<String, Object> lineItem1 = new HashMap<>();
        lineItem1.put("name", "T-shirt");
        lineItem1.put("description", "Comfortable cotton t-shirt");
        lineItem1.put("amount", 1500);
        lineItem1.put("currency", "hkd");
        lineItem1.put("quantity", 2);
        lineItems.add(lineItem1);
        Map<String, Object> params = new HashMap<>();
        params.put("success_url", "https://example.com/success");
        params.put("cancel_url", "https://example.com/cancel");
        params.put("payment_method_types", paymentMethodTypes);
//        params.put("customer", "cus_H8tJDj5SPW9cCb");
        params.put("customer_email", "287664409@qq.com");
        params.put("line_items", lineItems);
//        SessionCreateParams.Builder builder = new SessionCreateParams.Builder().setSuccessUrl(domainUrl + "/success.html?session_id={CHECKOUT_SESSION_ID}").setCancelUrl(domainUrl + "/canceled.html").addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD);
//        // Add a line item for the sticker the Customer is purchasing
//        SessionCreateParams.LineItem item = new SessionCreateParams.LineItem.Builder().setName("Pasha photo").setAmount(basePrice).setQuantity(quantity).setCurrency(currency).build();
//        builder.addLineItem(item);
//        SessionCreateParams createParams = builder.build();
        Map<String, Object> responseData = new HashMap<>();
        try {
            Session session = Session.create(params);
            responseData.put("sessionId", session.getId());
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    private long calculateOrderAmount(Object[] items) {
        return 1400;
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
