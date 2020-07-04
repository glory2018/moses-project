package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.entity.CustomerEntity;
import com.moses.stripe.param.CustomerParams;
import com.moses.stripe.service.CustomerService;
import com.stripe.exception.StripeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Moses
 */
@RestController
@Api("customer api")
@RequestMapping(value = "/customers")
public class CustomersController extends BaseController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/createCustomer")
    @ApiOperation(value = "create Customer", notes = "create Customer")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "successfully"),
//            @ApiResponse(code = 400, message = "failed")
//    })
    public BaseResponse createCustomer(@RequestBody CustomerParams customerParams) {
        BaseResponse response;
        try {
            Map<String, Object> map = customerService.createCustomer(customerParams);
            response = BaseResponse.success(map);
        } catch (StripeException e) {
            response = BaseResponse.fail(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/queryCustomer")
    @ApiOperation(value = "query Customer", notes = "query Customer by userId")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "user's id", required = true, dataType = "string", paramType = "query", example = "cus_HJLKjValYWhoFA")})
    public BaseResponse queryCustomer(@RequestParam String userId) {
        CustomerEntity customer = customerService.queryCustomer(userId);
        return BaseResponse.success(customer);
    }
}
