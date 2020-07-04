/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service;

import com.moses.demo.model.User;
import com.moses.framework.common.base.BaseService;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface UserService extends BaseService<User> {
    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    User findUser(User user);
}
