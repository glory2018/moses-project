package com.moses.stripe.controller;

import com.moses.framework.common.base.BaseController;
import com.moses.stripe.service.IndexService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author Moses
 */
@ApiIgnore
@Controller
public class IndexController extends BaseController {
    @Autowired
    IndexService indexService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/success")
    public String success(@RequestParam(required = false) String sessionId) {
        return "success";
    }

    @RequestMapping("/canceled")
    public String canceled() {
        return "canceled";
    }

    @RequestMapping("/payments")
    public String payments() {
        return "payments/index";
    }

    @RequestMapping("/card")
    public String card() {
        return "card/card";
    }

    @ResponseBody
    @GetMapping("/config")
    public Map<String, Object> config() {
        return indexService.config();
    }

    @ResponseBody
    @GetMapping("/checkout-session")
    public Session session(@RequestParam String sessionId) {
        Session session = null;
        try {
            session = Session.retrieve(sessionId);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return session;
    }
}
