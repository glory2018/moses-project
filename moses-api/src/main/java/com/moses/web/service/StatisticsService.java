/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/6/20
 */
public interface StatisticsService {
    List laboratoryNum();

    List yearNum();

    Map continued(MultipartFile file, String group, String data);

    String pair(String data);
}
