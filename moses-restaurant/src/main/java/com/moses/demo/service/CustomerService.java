/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service;

import com.moses.demo.model.Customer;
import com.moses.demo.vo.CustomerVo;
import com.moses.framework.common.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface CustomerService extends BaseService<Customer> {
    void importCustomer(MultipartFile file);

    Page<Customer> getPageList();

    Page<Customer> getPageList(CustomerVo vo);
}
