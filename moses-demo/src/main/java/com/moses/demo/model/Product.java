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
@ApiModel(value = "Product Parameters", description = "Product Parameters")
public class Product extends BaseEntity {
    @Column
    @ApiModelProperty(value = "产品名称", example = "王者归来")
    private String productName;
    @Column
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
    @Column
    @ApiModelProperty(value = "最小年龄", example = "1")
    private long minAge;
    @Column
    @ApiModelProperty(value = "最大年龄", example = "100")
    private long maxAge;
    @Column
    @ApiModelProperty(value = "联系电话", example = "15110220399")
    private String tel;
    @Column
    @ApiModelProperty(value = "所在地", example = "北京")
    private String city;
    @Column
    @ApiModelProperty(value = "民族", example = "汉")
    private String nation;
    @Column
    @ApiModelProperty(value = "信用卡、贷款是否逾期", example = "否")
    private String overdue;
    @Column
    @ApiModelProperty(value = "是否征信白户", example = "否")
    private String isCredit;
    @Column
    @ApiModelProperty(value = "营业执照", example = "有")
    private String businessLicense;
    @Column
    @ApiModelProperty(value = "营业执照年限", example = "")
    private long businessLicensePeriod = 0;
    @Column
    @ApiModelProperty(value = "信贷余额(万元)", example = "")
    private double creditBalance = 0;
    @Column
    @ApiModelProperty(value = "信用卡已使用额度(万元)", example = "")
    private double creditUsedAmount = 0;
    @Column
    @ApiModelProperty(value = "信用卡总额度(万元)", example = "")
    private double creditTotal = 0;
    @Column
    @ApiModelProperty(value = "信用卡使用率(万元)", example = "")
    private double creditCardUsage = 0;
    @Column
    @ApiModelProperty(value = "负债(万元)", example = "")
    private double debts = 0;
    @Column
    @ApiModelProperty(value = "小贷笔数", example = "")
    private long smallLoansNum = 0;
    @Column
    @ApiModelProperty(value = "小贷余额(万元)", example = "")
    private double smallLoanBalance = 0;
    @Column
    @ApiModelProperty(value = "房产所在地", example = "")
    private String houseLocation;
    @Column
    @ApiModelProperty(value = "房屋类型", example = "")
    private String houseType;
    @Column
    @ApiModelProperty(value = "房值", example = "")
    private double houseValue = 0;
    @Column
    @ApiModelProperty(value = "车类型", example = "")
    private String vehicleType;
    @Column
    @ApiModelProperty(value = "车值", example = "")
    private double vehicleValue = 0;
    @Column
    @ApiModelProperty(value = "新单位工龄(月)", example = "")
    private long lengthOfService;
    @Column
    @ApiModelProperty(value = "薪资(元)", example = "")
    private double salary;
    @Column
    @ApiModelProperty(value = "社保缴费时长(月)", example = "")
    private long socialSecurityTime;
    @Column
    @ApiModelProperty(value = "社保缴费基数(元)", example = "")
    private double socialSecurityAmount;
    @Column
    @ApiModelProperty(value = "公积金缴费时长(月)", example = "")
    private long accumulationFundTime;
    @Column
    @ApiModelProperty(value = "公积金缴费基数(元)", example = "")
    private double accumulationFundAmount;
    @Column
    @ApiModelProperty(value = "公积金个缴(元)", example = "")
    private double accumulationFundIndividual;
    @Column
    @ApiModelProperty(value = "微利贷(万元)", example = "")
    private double lowProfitLoan;
    @Column
    @ApiModelProperty(value = "个人流水(万元)", example = "")
    private double personalDetailed;
    @Column
    @ApiModelProperty(value = "个人流水(万元)", example = "")
    private double companyDetailed;
    @Column
    @ApiModelProperty(value = "内容", example = "This is some sample content.")
    private String content;
}
