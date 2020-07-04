package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "PaymentMethod Params", description = "PaymentMethod Parameters")
public class PaymentMethodParams {
    @ApiModelProperty(required = true, example = "cus_HJLKjValYWhoFA", value = "The customer.")
    String customer;
    @ApiModelProperty(required = true, example = "card", value = "The type of the PaymentMethod.")
    String type;
    @ApiModelProperty(required = true, example = "{\"number\": \"4242424242424242\",\"exp_month\": 5,\"exp_year\":2021,\"cvc\": \"314\"}", dataType = "application/json", value = "If this is a card PaymentMethod, this hash contains the user’s card details.")
    Map<String, Object> card;
}
