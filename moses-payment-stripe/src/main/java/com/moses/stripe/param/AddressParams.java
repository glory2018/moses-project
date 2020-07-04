package com.moses.stripe.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/4/27
 */
@Data
@ApiModel(value = "address Parameters", description = "address Parameters")
public class AddressParams {
    @ApiModelProperty(example = "香港中环", value = "City, district, suburb, town, or village.")
    String city;
    @ApiModelProperty(example = "HK", value = "Two-letter country code (ISO 3166-1 alpha-2).")
    String country;
    @ApiModelProperty(example = "皇后大道中2号", value = "Address line 1 (e.g., street, PO Box, or company name).")
    String line1;
    @ApiModelProperty(example = "", value = "Address line 2 (e.g., apartment, suite, unit, or building).")
    String line2;
    @ApiModelProperty(example = "", value = "Address line 2 (e.g., apartment, suite, unit, or building).")
    String postal_code;
    @ApiModelProperty(example = "Hong Kong", value = "State, county, province, or region.")
    String state;
}
