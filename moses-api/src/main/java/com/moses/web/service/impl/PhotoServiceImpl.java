/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service.impl;

import com.moses.framework.common.base.BaseServiceImpl;
import com.moses.web.model.Photo;
import com.moses.web.repository.PhotoRepository;
import com.moses.web.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Service
public class PhotoServiceImpl extends BaseServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> getList() {
        return photoRepository.findAll();
    }

    @Override
    public Photo getOne(long id) {
        return photoRepository.getOne(id);
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void edit(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void delete(long id) {
        photoRepository.deleteById(id);
    }
}


