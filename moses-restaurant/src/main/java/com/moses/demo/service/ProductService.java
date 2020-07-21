/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service;

import com.moses.demo.model.Product;
import com.moses.demo.vo.ProductVo;
import com.moses.framework.common.base.BaseService;
import org.springframework.data.domain.Page;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface ProductService extends BaseService<Product> {
    Page<Product> getPageList();

    Page<Product> getPageList(ProductVo vo);
}
