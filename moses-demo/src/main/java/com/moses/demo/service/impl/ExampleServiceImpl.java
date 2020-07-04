/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.service.impl;

import com.moses.demo.model.Example;
import com.moses.demo.repository.ExampleRepository;
import com.moses.demo.service.ExampleService;
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
public class ExampleServiceImpl extends BaseServiceImpl implements ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<Example> getList() {
        return exampleRepository.findAll();
    }

    @Override
    public Example getOne(long id) {
        return exampleRepository.getOne(id);
    }

    @Override
    public void save(Example example) {
        example.setCreateDate(new Date());
        exampleRepository.save(example);
    }

    @Override
    public void edit(Example example) {
        example.setModifyDate(new Date());
        exampleRepository.save(example);
    }

    @Override
    public void delete(long id) {
        exampleRepository.deleteById(id);
    }
}


