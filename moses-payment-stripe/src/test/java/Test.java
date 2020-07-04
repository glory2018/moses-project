import com.moses.stripe.common.Constant;
import com.stripe.Stripe;
import com.stripe.exception.CardException;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodListParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/28
 */
public class Test {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = Constant.STRIPE_SECRET_KEY;
//        getCustomer();
//        getSetupIntent("cus_HJLKjValYWhoFA");
        getPaymentMethods("cus_HJLKjValYWhoFA");
//        paymentIntent("cus_H8tJDj5SPW9cCb", "pm_1Gc8NtChx93PucYpLR1sQ9QM");
//        getSession();
//        getSubscription();
    }

    /**
     * 创建一个Customer对象
     *
     * @return
     * @throws StripeException
     */
    public static String getCustomer() throws StripeException {
        CustomerCreateParams params = CustomerCreateParams.builder().build();
        Customer customer = Customer.create(params);
        System.out.println(customer.getId());
        return "";
    }

    /**
     * 设立了客户的卡未来支付的对象
     *
     * @param customerId
     * @return
     * @throws StripeException
     */
    public static String getSetupIntent(String customerId) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerId);
        SetupIntent intent = SetupIntent.create(params);
        Map<String, String> map = new HashMap();
        map.put("client_secret", intent.getClientSecret());
        return "";
    }

    public static String getPaymentMethods(String customerId) throws StripeException {
        PaymentMethodListParams params = PaymentMethodListParams.builder()
                .setCustomer(customerId)
                .setType(PaymentMethodListParams.Type.CARD)
                .build();
        PaymentMethodCollection paymentMethods = PaymentMethod.list(params);
        return "";
    }

    public static String paymentIntent(String customerId, String paymentMethodId) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setCurrency("hkd")
                .setAmount(1099L)
                .setPaymentMethod(paymentMethodId)
                .setCustomer(customerId)
                .setConfirm(true)
                .setOffSession(true)
                .build();
        try {
            PaymentIntent.create(params);
        } catch (CardException e) {
            // Error code will be authentication_required if authentication is needed
            System.out.println("Error code is : " + e.getCode());
            String paymentIntentId = e.getStripeError().getPaymentIntent().getId();
            PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
            System.out.println(paymentIntent.getId());
        }
        return "";
    }

    public static String getSession() throws StripeException {
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
        params.put("line_items", lineItems);
        params.put("client_reference_id", "cus_HJLKjValYWhoFA");
        Session session = Session.create(params);
        return "";
    }

    public static String getSubscription() throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        SubscriptionCollection subscriptions = Subscription.list(params);
        return "";
    }
}
