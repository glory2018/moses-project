package com.moses.stripe.service.impl;

import com.moses.stripe.param.SubscriptionParams;
import com.moses.stripe.service.SubscriptionsService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import com.stripe.param.CustomerUpdateParams;
import com.stripe.param.SubscriptionCreateParams;
import org.springframework.stereotype.Service;

/**
 * @author Moses
 */
@Service
public class SubscriptionsServiceImpl extends BaseService implements SubscriptionsService {
    @Override
    public String createSubscription(SubscriptionParams obj) throws StripeException {
        init();
        Customer customer = Customer.retrieve(obj.getCustomer());
//        update the customer’s default payment method
        CustomerUpdateParams params = CustomerUpdateParams.builder().setInvoiceSettings(
                CustomerUpdateParams.InvoiceSettings.builder().setDefaultPaymentMethod(obj.getPaymentMethod()).build())
                .build();
        customer.update(params);
        SubscriptionCreateParams subscriptionCreateParams = SubscriptionCreateParams.builder()
                .setCustomer(obj.getCustomer())
                .addItem(SubscriptionCreateParams.Item.builder().setPlan(obj.getPlan()).build())
                .build();
        Subscription subscription = Subscription.create(subscriptionCreateParams);
        return subscription.getId();
    }
}


