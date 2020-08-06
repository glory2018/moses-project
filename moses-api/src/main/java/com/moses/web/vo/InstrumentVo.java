/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.web.vo.InstrumentVo
 * @version V1.0
 */
package com.moses.web.vo;

import com.moses.framework.common.base.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Data
public class InstrumentVo extends BaseVo {
    @ApiModelProperty(value = "仪器编号", example = "A19000061")
    private String instrumentCode;
    @ApiModelProperty(value = "仪器名称", example = "高速视觉采集系统")
    private String instrumentName;
}
