/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.model.Instrument
 * @version V1.0
 */
/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.model;

import com.moses.framework.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Instrument Entity", description = "Instrument Entity")
public class Instrument extends BaseEntity {
    @Column(unique = true, length = 9)
    @ApiModelProperty(value = "仪器编号", example = "A19000061")
    private String instrumentCode;
    @Column(nullable = false)
    @ApiModelProperty(value = "仪器名称", example = "高速视觉采集系统")
    private String instrumentName;
    @Column
    @ApiModelProperty(value = "实验室编号", example = "031005")
    private String laboratoryCode;
    @Column(nullable = false)
    @ApiModelProperty(value = "购买日期", example = "20191115")
    private String purchaseDate;
    @OneToMany(targetEntity = Photo.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(value = "仪器照片")
    private Set<Photo> photos = new HashSet<Photo>();
    @Column
    @ApiModelProperty(value = "仪器管理员")
    private String instrumentAdmin;
}
