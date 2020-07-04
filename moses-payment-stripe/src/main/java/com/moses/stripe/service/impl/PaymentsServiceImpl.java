package com.moses.stripe.service.impl;

import com.moses.framework.util.DateUtilEnum;
import com.moses.framework.util.DateUtils;
import com.moses.stripe.common.Constant;
import com.moses.stripe.param.PaymentParams;
import com.moses.stripe.param.PaymentRequest;
import com.moses.stripe.service.PaymentsService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import com.stripe.model.SetupIntent;
import com.stripe.net.Webhook;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.SetupIntentCreateParams;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Moses
 */
@Service
public class PaymentsServiceImpl extends BaseService implements PaymentsService {
    private Long calculateOrderAmount(Object[] items) {
        return 1400L;
    }

    @Override
    public Map<String, Object> createPaymentIntent(PaymentParams postBody) throws StripeException {
        init();
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setCurrency(postBody.getCurrency())
                .setAmount(postBody.getAmount() * 100)
                .setDescription(postBody.getDescription())
                .setReceiptEmail(postBody.getReceiptEmail())
                .build();
        // Create a PaymentIntent with the order amount and currency
        PaymentIntent intent = PaymentIntent.create(createParams);
        Map<String, Object> map = new HashMap<>();
        map.put("publishableKey", Constant.STRIPE_PUBLISHABLE_KEY);
        map.put("clientSecret", intent.getClientSecret());
        return map;
    }

    @Override
    public void cancelPaymentIntent(String paymentIntentId) throws StripeException {
        init();
        PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
        paymentIntent.cancel();
    }

    @Override
    public List<Map<String, Object>> queryPaymentIntent(String customerId) throws StripeException {
        init();
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerId);
        PaymentIntentCollection paymentIntents = PaymentIntent.list(params);
        List<Map<String, Object>> list = new ArrayList<>();
        for (PaymentIntent paymentIntent : paymentIntents.getData()) {
            Map<String, Object> map = new HashMap<>();
            map.put("paymentIntentId", paymentIntent.getId());
            map.put("currency", paymentIntent.getCurrency());
            map.put("amount", paymentIntent.getAmount());
            map.put("description", paymentIntent.getDescription());
            map.put("paymentMethod", paymentIntent.getPaymentMethod());
            map.put("receiptEmail", paymentIntent.getReceiptEmail());
            map.put("created", DateUtils.format(new Date(paymentIntent.getCreated() * 1000), DateUtilEnum.DATE_FMT_Y_M_D_HMS));
            map.put("status", paymentIntent.getStatus());
            list.add(map);
        }
        return list;
    }

    @Override
    public Map<String, Object> chargeCard(PaymentRequest postBody) throws StripeException {
        init();
//        设置off_session以true指示该付款尝试期间客户不在您的结帐流程中。如果需要验证，这将导致PaymentIntent引发错误。
//        将PaymentIntent的确认属性的值设置为true，这将在创建PaymentIntent时立即进行确认。
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setCurrency(postBody.getCurrency())
                .setAmount(postBody.getAmount() * 100)
                .setPaymentMethod(postBody.getPaymentMethodId())
                .setCustomer(postBody.getCustomerId())
                .setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.MANUAL)
                .setConfirm(true)
                .setOffSession(true)
                .build();
        // Create a PaymentIntent with the order amount and currency
        PaymentIntent intent = PaymentIntent.create(createParams);
        Map<String, Object> map = new HashMap<>();
        map.put("publishableKey", Constant.STRIPE_PUBLISHABLE_KEY);
        map.put("clientSecret", intent.getClientSecret());
        return map;
//            String paymentIntentId = e.getStripeError().getPaymentIntent().getId();
//            PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
//            System.out.println(paymentIntent.getId());
    }

    @Override
    public Map<String, Object> createSetupIntent(String id) throws StripeException {
        init();
        // Create or use an existing Customer to associate with the SetupIntent.
        // The PaymentMethod will be stored to this Customer for later use.
        SetupIntentCreateParams params = new SetupIntentCreateParams.Builder().setCustomer(id).build();
        SetupIntent intent = SetupIntent.create(params);
        Map<String, Object> map = new HashMap<>();
        map.put("publishableKey", Constant.STRIPE_PUBLISHABLE_KEY);
        map.put("clientSecret", intent.getClientSecret());
        return map;
    }

    @Override
    public String webhook(String payload, String sigHeader, String endpointSecret) throws SignatureVerificationException {
        String response;
//        Event event = JSONUtil.toBean(payload, Event.class);
//        logger.info("event.getType()==============" + event.getType());
        Event event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        switch (event.getType()) {
            case "payment_intent.succeeded":
                // Fulfill any orders, e-mail receipts, etc
                // To cancel the payment you will need to issue a Refund
                // (https://stripe.com/docs/api/refunds)
                response = "💰Payment received!";
                break;
            case "payment_intent.payment_failed":
                response = "❌ Payment failed.";
                break;
            default:
                // Unexpected event type
                response = "❌ Payment failed.";
        }
        logger.info("response==============" + response);
        return response;
    }
}


