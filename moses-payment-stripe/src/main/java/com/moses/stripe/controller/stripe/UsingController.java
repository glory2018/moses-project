package com.moses.stripe.controller.stripe;

import com.moses.framework.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/using")
public class UsingController extends BaseController {
//    @Autowired
//    UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "card/using-webhooks";
    }
}
