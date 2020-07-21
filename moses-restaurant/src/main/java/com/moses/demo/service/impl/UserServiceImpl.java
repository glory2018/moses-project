/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service.impl;

import com.moses.demo.model.User;
import com.moses.demo.repository.UserRepository;
import com.moses.demo.service.UserService;
import com.moses.framework.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findUser(User user) {
        return userRepository.findUser(user);
    }

    @Override
    public void save(User user) {
        user.setCreateDate(new Date());
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        user.setModifyDate(new Date());
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}


