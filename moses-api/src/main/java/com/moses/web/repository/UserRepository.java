/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.repository;

import com.moses.framework.common.base.BaseRepository;
import com.moses.web.model.User;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface UserRepository extends BaseRepository<User> {
    @Query(value = "from User t WHERE t.userName = :#{#u.getUserName()} and t.password=:#{#u.getPassword()}")
    User findUser(User u);
}
