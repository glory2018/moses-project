package com.moses.stripe.controller.stripe;

import com.moses.stripe.config.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {
    @RequestMapping("/index")
    public String index() {
        return "product/index";
    }
}
