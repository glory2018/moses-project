/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.repository;

import com.moses.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "from User t WHERE t.userName = :#{#u.getUserName()} and t.password=:#{#u.getPassword()}")
    User findUser(User u);
}
