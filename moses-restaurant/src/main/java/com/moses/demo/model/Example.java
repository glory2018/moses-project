/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.model.Product
 * @version V1.0
 */
/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.demo.model;

import com.moses.framework.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Example Parameters", description = "Example Parameters")
public class Example extends BaseEntity {
    @Column
    @ApiModelProperty(value = "姓名", example = "王者归来")
    private String userName;
    @Column
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
    @Column
    @ApiModelProperty(value = "年龄", example = "30")
    private long age;
}
