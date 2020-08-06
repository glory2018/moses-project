/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.model.Laboratory
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

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Laboratory Entity", description = "Laboratory Entity")
public class Laboratory extends BaseEntity {
    @Column(unique = true)
    @ApiModelProperty(value = "实验室编号", example = "031005")
    private String laboratoryCode;
    @Column
    @ApiModelProperty(value = "实验室名称", example = "跨介质实验中心")
    private String laboratoryName;
}
