/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service.impl;

import com.moses.framework.common.base.BaseServiceImpl;
import com.moses.framework.util.ExcelUtil;
import com.moses.framework.util.ObjectUtil;
import com.moses.web.model.Laboratory;
import com.moses.web.repository.LaboratoryRepository;
import com.moses.web.service.LaboratoryService;
import com.moses.web.vo.LaboratoryVo;
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
public class LaboratoryServiceImpl extends BaseServiceImpl implements LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Override
    public Page<Laboratory> getPageList() {
        return getPageList(new LaboratoryVo());
    }

    @Override
    public Page<Laboratory> getPageList(LaboratoryVo vo) {
        Specification specification = (Specification<Laboratory>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return laboratoryRepository.findAll(specification, buildPageRequest(vo.getPageNum(), vo.getPageSize()));
    }

    @Override
    public List<Laboratory> getList() {
        return laboratoryRepository.findAll();
    }

    @Override
    public Laboratory getOne(long id) {
        return laboratoryRepository.getOne(id);
    }

    @Override
    public void save(Laboratory laboratory) {
        laboratory.setCreateDate(new Date());
        laboratoryRepository.save(laboratory);
    }

    @Override
    public void edit(Laboratory laboratory) {
        laboratory.setModifyDate(new Date());
        laboratoryRepository.save(laboratory);
    }

    @Override
    public void delete(long id) {
        laboratoryRepository.deleteById(id);
    }

    @Override
    public void importLaboratory(MultipartFile file) {
        String[] keys = {"laboratoryCode", "laboratoryName"};
        List<Map<String, Object>> list = ExcelUtil.getList(file, 0, keys);
        try {
            List<Laboratory> laboratorys = ObjectUtil.mapsToObjects(list, Laboratory.class);
            laboratoryRepository.saveAll(laboratorys);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


