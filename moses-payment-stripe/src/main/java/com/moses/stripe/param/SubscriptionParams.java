package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "Subscription Params", description = "Subscription Parameters")
public class SubscriptionParams {
    @ApiModelProperty(required = true, example = "cus_HJLKjValYWhoFA", value = "The identifier of the customer to subscribe.")
    String customer;
    @ApiModelProperty(required = true, example = "pm_1GkiunFqifXy7ljxwbewhU3b", value = "initial payment method information.")
    String paymentMethod;
    @ApiModelProperty(required = true, example = "plan_HJLhq2cVJuw2nx", dataType = "application/json", value = "A list of up to 20 subscription items, each with an attached plan.")
    String plan;
}
