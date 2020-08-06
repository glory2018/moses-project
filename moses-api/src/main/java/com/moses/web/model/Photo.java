/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.model.User
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Data
@Entity
@ApiModel(value = "Photo Entity", description = "Photo Entity")
public class Photo extends BaseEntity {
    @Column
    @ApiModelProperty(value = "编号", example = "")
    private String photoCode;
    @Column
    @ApiModelProperty(value = "名称", example = "")
    private String photoName;
    @Column
    @ApiModelProperty(value = "路径", example = "")
    private String photoPath;
    @ManyToOne(targetEntity = Instrument.class)
    @JoinColumn(name = "instrument_id", referencedColumnName = "id")
    private Instrument instrument;
}
