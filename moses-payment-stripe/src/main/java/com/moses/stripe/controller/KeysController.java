package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.framework.common.base.BaseResponse;
import com.moses.stripe.service.KeysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author Moses
 */
@RestController
@ApiIgnore
@Api("Keys api")
@RequestMapping(value = "/keys")
public class KeysController extends BaseController {
    @Autowired
    KeysService keysService;

    @GetMapping("/publicKey")
    @ApiOperation(value = "public Key", notes = "public key")
    public BaseResponse publicKey() {
        BaseResponse response;
        Map<String, Object> map = keysService.publicKey();
        response = BaseResponse.success(map);
        return response;
    }
}
