/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service;

import com.moses.framework.common.base.BaseService;
import com.moses.web.model.Instrument;
import com.moses.web.vo.InstrumentVo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface InstrumentService extends BaseService<Instrument> {
    void importInstrument(MultipartFile file);
    void add(MultipartFile[] files, Instrument instrument);
    void edit(MultipartFile[] files, Instrument instrument);

    Page<Instrument> getPageList();

    Page<Instrument> getPageList(InstrumentVo vo);
}
