package com.moses.stripe.controller.stripe;

import com.moses.stripe.common.Constant;
import com.moses.stripe.config.BaseController;
import com.moses.stripe.config.BaseResponse;
import com.moses.stripe.service.PaymentsService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.net.Webhook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/savingCards")
public class SavingCardsController extends BaseController {
    Logger logger = LoggerFactory.getLogger(SavingCardsController.class);
    @Autowired
    PaymentsService paymentsService;

    @RequestMapping("/index")
    public String index() {
        return "card/saving-cards";
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
            return BaseResponse.fail("🔔 A SetupIntent has failed the attempt to set up a PaymentMethod.");
        }
        EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
        switch (event.getType()) {
            case "setup_intent.created":
                System.out.println("🔔 A new SetupIntent was created.");
                break;
            case "setup_intent.succeeded":
                System.out.println("🔔 A SetupIntent has successfully set up a PaymentMethod.");
                break;
            case "setup_intent.setup_failed":
                System.out.println("🔔 A SetupIntent has failed the attempt to set up a PaymentMethod.");
                break;
            case "payment_method.attached":
//                PaymentMethod paymentMethod = ApiResource.GSON.fromJson(deserializer.getRawJson(), PaymentMethod.class);
//                // At this point, associate the ID of the Customer object with your
//                // own internal representation of a customer, if you have one.
//                Customer customer = Customer.retrieve(paymentMethod.getCustomer());
//                System.out.println("🔔 A PaymentMethod has successfully been saved to a Customer.");
//                // Optional: update the Customer billing information with billing details from the PaymentMethod
//                CustomerUpdateParams params = new CustomerUpdateParams.Builder()
//                        .setEmail(paymentMethod.getBillingDetails().getEmail())
//                        .build();
//                customer.update(params);
                System.out.println("🔔 Customer successfully updated.");
                break;
            default:
                return BaseResponse.fail("🔔 A SetupIntent has failed the attempt to set up a PaymentMethod.");
        }
        return BaseResponse.success("🔔 A SetupIntent has successfully set up a PaymentMethod.");
    }
}
