package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "Plan Params", description = "Plan Parameters")
public class PlanParams {
    @ApiModelProperty(required = true, example = "5000", value = "A positive integer in cents (or 0 for a free plan) representing how much to charge on a recurring basis.")
    String amount;
    @ApiModelProperty(required = true, example = "hkd", value = "Three-letter ISO currency code, in lowercase. Must be a supported currency.")
    String currency;
    @ApiModelProperty(required = true, example = "day", value = "Specifies billing frequency. Either day, week, month or year.")
    String interval;
    @ApiModelProperty(example = "1", value = "set more customized intervals, such as billing a customer every 30 days or every 5 months.")
    Integer interval_count;
    @ApiModelProperty(required = true, example = "prod_HJLgpiZq3dTbPV", value = "The product whose pricing the created plan will represent.")
    String product;
    @ApiModelProperty(example = "Plan 1", value = "A brief description of the plan, hidden from customers.")
    String nickname;
}
