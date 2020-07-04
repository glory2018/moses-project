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
@ApiModel(value = "Customer Parameters", description = "Customer Parameters")
public class Customer extends BaseEntity {
    /**
     * 姓名
     */
    @Column
    @ApiModelProperty(value = "姓名", example = "王者归来")
    private String userName;
    @Column
    @ApiModelProperty(value = "用户ID", example = "40488")
    private String userId;
    @Column
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
    @Column
    @ApiModelProperty(value = "身份证", example = "")
    private String identityCard;
    @Column
    @ApiModelProperty(value = "年龄", example = "30")
    private long age;
    @Column
    @ApiModelProperty(value = "电话", example = "15110220399")
    private String tel;
    @Column
    @ApiModelProperty(value = "贷款金额(万)", example = "20")
    private double loanAmount;
    @Column
    @ApiModelProperty(value = "意向产品", example = "昊源-房主信用贷")
    private String intendedProducts;
    @Column
    @ApiModelProperty(value = "贷款期限(月)", example = "12")
    private long loanTerm;
    @Column
    @ApiModelProperty(value = "所在城市", example = "北京")
    private String city;
    @Column
    @ApiModelProperty(value = "客户归属", example = "唐印")
    private String customerOwnership;
    @Column
    @ApiModelProperty(value = "客户等级", example = "")
    private String customerLevel;
    @Column
    @ApiModelProperty(value = "当前状态", example = "待跟进")
    private String currentState;
    @Column
    @ApiModelProperty(value = "客户来源", example = "付费推广")
    private String source;
    @Column
    @ApiModelProperty(value = "添加时间", example = "2020-05-29 17:02:50")
    private String addTime;
    @Column
    @ApiModelProperty(value = "最近跟进人", example = "")
    private String followers;
    @Column
    @ApiModelProperty(value = "最近跟进时间", example = "")
    private String followUpTime;
    @Column
    @ApiModelProperty(value = "民族", example = "汉")
    private String nation;
    @Column
    @ApiModelProperty(value = "信用卡、贷款是否逾期", example = "false")
    private String overdue;
    @Column
    @ApiModelProperty(value = "是否征信白户", example = "false")
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
    @ApiModelProperty(value = "公司流水(万元)", example = "")
    private double companyDetailed;
}
