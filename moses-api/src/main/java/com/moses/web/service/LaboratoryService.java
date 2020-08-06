/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service;

import com.moses.framework.common.base.BaseService;
import com.moses.web.model.Laboratory;
import com.moses.web.vo.LaboratoryVo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface LaboratoryService extends BaseService<Laboratory> {
    void importLaboratory(MultipartFile file);

    Page<Laboratory> getPageList();

    Page<Laboratory> getPageList(LaboratoryVo vo);
}
