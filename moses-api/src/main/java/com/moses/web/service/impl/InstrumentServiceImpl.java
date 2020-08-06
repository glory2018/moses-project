/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service.impl;

import com.moses.framework.common.base.BaseServiceImpl;
import com.moses.framework.util.ExcelUtil;
import com.moses.framework.util.FileUtil;
import com.moses.framework.util.ObjectUtil;
import com.moses.web.model.Instrument;
import com.moses.web.model.Photo;
import com.moses.web.repository.InstrumentRepository;
import com.moses.web.service.InstrumentService;
import com.moses.web.service.PhotoService;
import com.moses.web.vo.InstrumentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Service
public class InstrumentServiceImpl extends BaseServiceImpl implements InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;
    @Resource
    PhotoService photoService;

    @Override
    public Page<Instrument> getPageList() {
        return getPageList(new InstrumentVo());
    }

    @Override
    public Page<Instrument> getPageList(InstrumentVo vo) {
        Specification specification = (Specification<Instrument>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (vo.getInstrumentCode() != null && StringUtils.isNotEmpty(vo.getInstrumentCode())) {
                predicates.add(cb.like(root.get("instrumentCode"), "%" + vo.getInstrumentCode() + "%"));
            }
            if (vo.getInstrumentName() != null && StringUtils.isNotEmpty(vo.getInstrumentName())) {
                predicates.add(cb.like(root.get("instrumentName"), "%" + vo.getInstrumentName() + "%"));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return instrumentRepository.findAll(specification, buildPageRequest(vo.getPageNum(), vo.getPageSize()));
    }

    @Override
    public List<Instrument> getList() {
        return instrumentRepository.findAll();
    }

    @Override
    public Instrument getOne(long id) {
        return instrumentRepository.getOne(id);
    }

    @Override
    public void save(Instrument instrument) {
        instrument.setCreateDate(new Date());
        instrumentRepository.save(instrument);
    }

    @Override
    public void add(MultipartFile[] files, Instrument instrument) {
        Photo photo;
        String fileName;
        for (MultipartFile file : files) {
            fileName = file.getOriginalFilename();
            if (!"".equals(fileName)) {
                long time = System.currentTimeMillis();
                FileUtil.upload(file, uploadFolder + time);
                photo = new Photo();
                photo.setPhotoCode(String.valueOf(time));
                photo.setPhotoName(fileName);
                photo.setPhotoPath("/file/show?fileName=" + time);
                instrument.getPhotos().add(photo);
                photoService.save(photo);
            }
        }
        save(instrument);
    }

    @Override
    public void edit(Instrument instrument) {
        instrument.setModifyDate(new Date());
        instrumentRepository.save(instrument);
    }

    @Transactional
    @Override
    public void edit(MultipartFile[] files, Instrument instrument) {
        instrumentRepository.deleteAssociationPhoto(instrument.getId());
        Photo photo;
        String fileName;
        for (MultipartFile file : files) {
            fileName = file.getOriginalFilename();
            if (!"".equals(fileName)) {
                long time = System.currentTimeMillis();
                FileUtil.upload(file, uploadFolder + time);
                photo = new Photo();
                photo.setPhotoCode(String.valueOf(time));
                photo.setPhotoName(fileName);
                photo.setPhotoPath("/file/show?fileName=" + time);
                instrument.getPhotos().add(photo);
                photoService.save(photo);
            }
        }
        edit(instrument);
    }

    @Transactional
    @Override
    public void delete(long id) {
        instrumentRepository.deleteAssociationPhoto(id);
        instrumentRepository.deleteById(id);
    }

    @Override
    public void importInstrument(MultipartFile file) {
        String[] keys = {"laboratoryCode", "instrumentCode", "instrumentName", "purchaseDate"};
        List<Map<String, Object>> list = ExcelUtil.getList(file, 2, keys);
        try {
            List<Instrument> instruments = ObjectUtil.mapsToObjects(list, Instrument.class);
            instrumentRepository.saveAll(instruments);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


