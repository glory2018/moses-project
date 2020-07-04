/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.web;

import com.moses.demo.model.Customer;
import com.moses.demo.service.CustomerService;
import com.moses.demo.vo.CustomerVo;
import com.moses.framework.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Api("Customer API")
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {
    static String PREFIX = "customer/";
    static String HEADER = "客户管理";
    static String REDIRECT = "redirect:/customer/list";
    @Resource
    CustomerService customerService;

    @RequestMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list Customer", notes = "list Customer")
    public String list(Model model) {
        Page<Customer> customers = customerService.getPageList();
        model.addAttribute("page", customers);
        model.addAttribute("header", HEADER);
        return PREFIX + "customerList";
    }

    @PostMapping("/list")
    @ApiOperation(value = "list Customer", notes = "list Customer")
    public String list(Model model, CustomerVo vo) {
        Page<Customer> customers = customerService.getPageList(vo);
        model.addAttribute("page", customers);
        return PREFIX + "customerList::table_list";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "Customer add", notes = "Customer add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "customerAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add Customer", notes = "add Customer")
    public String add(Customer customer) {
        customerService.save(customer);
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "Customer edit", notes = "Customer edit")
    public String toEdit(Model model, long id) {
        Customer customer = customerService.getOne(id);
        model.addAttribute("customer", customer);
        model.addAttribute("header", HEADER);
        return PREFIX + "customerEdit";
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "Customer Detail", notes = "Customer Detail")
    public String toDetail(Model model, long id) {
        Customer customer = customerService.getOne(id);
        model.addAttribute("customer", customer);
        model.addAttribute("header", HEADER);
        return PREFIX + "customerDetail";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit Customer", notes = "edit Customer")
    public String edit(Customer customer, BindingResult result) {
        customerService.edit(customer);
        return REDIRECT;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete Customer", notes = "delete Customer")
    public String delete(long id) {
        customerService.delete(id);
        return REDIRECT;
    }

    @GetMapping("/toImport")
    @ApiOperation(value = "Customer import", notes = "Customer import")
    public String toImport(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "customeImport";
    }

    @PostMapping("/importCustomer")
    @ApiOperation(value = "add Customer", notes = "add Customer")
    public String importCustomer(MultipartFile file) {
        customerService.importCustomer(file);
        return REDIRECT;
    }
}
