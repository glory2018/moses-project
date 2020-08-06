/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service;

import com.moses.framework.common.base.BaseService;
import com.moses.web.model.User;
import com.moses.web.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface UserService extends BaseService<User> {
    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    User findUser(User user);

    void importUser(MultipartFile file);

    Page<User> getPageList();

    Page<User> getPageList(UserVo vo);
}
