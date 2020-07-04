package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "Customer Parameters", description = "Customer Parameters")
public class CustomerParams {
    @ApiModelProperty(required = true, value = "user id", example = "cus_HJLKjValYWhoFA")
    String userId;
    @ApiModelProperty(example = "Jane Doe", value = "The customer’s full name or business name.")
    String name;
    @ApiModelProperty(example = "Jane@example.com", value = "The customer’s email address.")
    String email;
    @ApiModelProperty(example = "My First Test Customer (created for API docs)", value = "An arbitrary string attached to the object. Often useful for displaying to users.")
    String description;
    @ApiModelProperty(example = "+85225266911", value = "The customer’s phone number.")
    String phone;
    AddressParams address;
//    @ApiModelProperty(value = "currency", example = "hkd", notes = "Three-letter ISO code for the currency the customer can be charged in for recurring billing purposes.")
//    String currency;
//    @ApiModelProperty(value = "preferred_locales", example = "en", notes = "The customer’s preferred locales (languages), ordered by preference.")
//    String preferred_locales;
}
