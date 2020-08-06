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
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User Entity", description = "User Entity")
public class User extends BaseEntity {
    @Column
    @NotEmpty(message = "用户工号不能为空")
    @ApiModelProperty(value = "工号", example = "680059")
    private String userCode;
    @Column
    @NotNull(message = "用户姓名不能为空")
    @Size(min = 6, max = 12, message = "用户姓名必须是6-12个字符")
    @ApiModelProperty(value = "姓名", example = "马颖华")
    private String userName;
    @Column
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
}
