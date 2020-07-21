/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.repository;

import com.moses.demo.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Moses
 * @date 2020/5/20
 */
public interface ExampleRepository extends JpaRepository<Example, Long> {
}
