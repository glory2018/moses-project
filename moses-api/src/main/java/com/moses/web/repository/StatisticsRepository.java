/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.repository;

import com.moses.framework.common.base.BaseRepository;
import com.moses.web.model.Instrument;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface StatisticsRepository extends BaseRepository<Instrument> {
    @Query(value = "SELECT l.laboratory_name, Count(*) AS num FROM instrument AS t,laboratory l where t.laboratory_code=l.laboratory_code GROUP BY l.laboratory_name ORDER BY l.laboratory_name", nativeQuery = true)
    List laboratoryNum();

    @Query(value = "SELECT LEFT (purchase_date, 4) AS purchaseDate,Count(*) AS num FROM Instrument t GROUP BY LEFT (purchase_date, 4) ORDER BY LEFT (purchase_date, 4)", nativeQuery = true)
    List yearNum();
}
