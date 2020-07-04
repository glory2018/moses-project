package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "付款请求", description = "请求传递参数")
public class PaymentParams {
    @ApiModelProperty(required = true, value = "币种", example = "usd")
    String currency;
    @ApiModelProperty(required = true, value = "金额", example = "1000")
    Long amount;
    @ApiModelProperty(value = "描述", example = "this is a test")
    String description;
    @ApiModelProperty(value = "接收邮件", example = "shaorong.fan@linksfield.net")
    String receiptEmail;
    @ApiModelProperty(value = "客户id", example = "cus_HJLKjValYWhoFA")
    String customerId;
}
