/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.repository;

import com.moses.framework.common.base.BaseRepository;
import com.moses.web.model.Instrument;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface InstrumentRepository extends BaseRepository<Instrument> {
    @Query(value = "delete from instrument_photos where instrument_id= ?1", nativeQuery = true)
    @Modifying
    void deleteAssociationPhoto(long id);
}
