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
import javax.validation.constraints.NotNull;

/**
 * @author Moses
 * @date 2020/5/20
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User Parameters", description = "User Parameters")
public class User extends BaseEntity {
    @Column
    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", example = "admin")
    private String userName;
    @Column
    @ApiModelProperty(value = "昵称", example = "王者归来")
    private String nickName;
    @Column
    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
}
