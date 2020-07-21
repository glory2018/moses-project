/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.web;

import com.moses.demo.model.Product;
import com.moses.demo.service.ProductService;
import com.moses.demo.vo.ProductVo;
import com.moses.framework.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Api("Product API")
@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {
    static String PREFIX = "product/";
    static String HEADER = "产品管理";
    static String REDIRECT = "redirect:/product/list";
    @Resource
    ProductService productService;

    @RequestMapping("/")
    public String index() {
        return REDIRECT;
    }

    @GetMapping("/list")
    @ApiOperation(value = "list Product", notes = "list Product")
    public String list(Model model) {
        Page<Product> products = productService.getPageList();
        model.addAttribute("page", products);
        model.addAttribute("header", HEADER);
        return PREFIX + "productList";
    }

    @PostMapping("/list")
    @ApiOperation(value = "list Product", notes = "list Product")
    public String list(Model model, ProductVo vo) {
        Page<Product> Products = productService.getPageList(vo);
        model.addAttribute("page", Products);
        return PREFIX + "productList::table_list";
    }

    @GetMapping("/toAdd")
    @ApiOperation(value = "Product add", notes = "Product add")
    public String add(Model model) {
        model.addAttribute("header", HEADER);
        return PREFIX + "productAdd";
    }

    @PostMapping("/add")
    @ApiOperation(value = "add Product", notes = "add Product")
    public String add(Product product) {
        productService.save(product);
        return REDIRECT;
    }

    @GetMapping("/toEdit")
    @ApiOperation(value = "Product edit", notes = "Product edit")
    public String toEdit(Model model, long id) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        model.addAttribute("header", HEADER);
        return PREFIX + "productEdit";
    }

    @GetMapping("/toDetail")
    @ApiOperation(value = "Product Detail", notes = "Product Detail")
    public String toDetail(Model model, long id) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        model.addAttribute("header", HEADER);
        return PREFIX + "productDetail";
    }

    @PostMapping("/edit")
    @ApiOperation(value = "edit Product", notes = "edit Product")
    public String edit(Product product) {
        productService.edit(product);
        return REDIRECT;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "delete Product", notes = "delete Product")
    public String delete(long id) {
        productService.delete(id);
        return REDIRECT;
    }
}
