/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service;

import com.moses.demo.model.Product;

import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface MatchProductService {
    /**
     * 查询用户匹配产品
     *
     * @param id
     * @return
     */
    List<Product> getMatchList(long id);
}
