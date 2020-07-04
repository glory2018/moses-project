package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "Product Params", description = "Product Parameters")
public class ProductParams {
    @ApiModelProperty(required = true, example = "T-shirt", value = "The product’s name")
    String name;
    @ApiModelProperty(example = "Comfortable cotton t-shirt", value = "The product’s description.")
    String description;
}
