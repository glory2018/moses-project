/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service.impl;

import com.moses.framework.common.base.BaseServiceImpl;
import com.moses.framework.util.ExcelUtil;
import com.moses.framework.util.ObjectUtil;
import com.moses.web.model.User;
import com.moses.web.repository.UserRepository;
import com.moses.web.service.UserService;
import com.moses.web.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getPageList() {
        return getPageList(new UserVo());
    }

    @Override
    public Page<User> getPageList(UserVo vo) {
        Specification specification = (Specification<User>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return userRepository.findAll(specification, buildPageRequest(vo.getPageNum(), vo.getPageSize()));
    }

    @Override
    public User findUser(User user) {
        return userRepository.findUser(user);
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(long id) {
        return userRepository.getOne(id);
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

    @Override
    public void importUser(MultipartFile file) {
        String[] keys = {"userCode", "userName"};
        List<Map<String, Object>> list = ExcelUtil.getList(file, 1, keys);
        try {
            List<User> users = ObjectUtil.mapsToObjects(list, User.class);
            userRepository.saveAll(users);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
//    private void assembling(User user, int j, String value) {
//        switch (j) {
//            case 0:
//                user.setUserCode(value);
//                break;
//            case 1:
//                user.setUserName(value);
//                break;
//        }
//    }
}


