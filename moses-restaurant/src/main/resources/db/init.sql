/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-06-12 08:52:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `accumulation_fund_amount` double DEFAULT NULL,
  `accumulation_fund_individual` double DEFAULT NULL,
  `accumulation_fund_time` bigint(20) DEFAULT NULL,
  `add_time` varchar(255) DEFAULT NULL,
  `age` bigint(20) DEFAULT NULL,
  `business_license` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_detailed` double DEFAULT NULL,
  `current_state` varchar(255) DEFAULT NULL,
  `customer_level` varchar(255) DEFAULT NULL,
  `customer_ownership` varchar(255) DEFAULT NULL,
  `debts` double DEFAULT NULL,
  `follow_up_time` varchar(255) DEFAULT NULL,
  `followers` varchar(255) DEFAULT NULL,
  `house_property` double DEFAULT NULL,
  `identity_card` varchar(255) DEFAULT NULL,
  `intended_products` varchar(255) DEFAULT NULL,
  `is_credit` varchar(255) DEFAULT NULL,
  `length_of_service` bigint(20) DEFAULT NULL,
  `loan_amount` double DEFAULT NULL,
  `loan_term` bigint(20) DEFAULT NULL,
  `low_profit_loan` double DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `overdue` varchar(255) DEFAULT NULL,
  `own_vehicle` double DEFAULT NULL,
  `personal_detailed` double DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `social_security_amount` double DEFAULT NULL,
  `social_security_time` bigint(20) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `business_license_period` varchar(255) DEFAULT NULL,
  `credit_balance` double DEFAULT NULL,
  `credit_card_usage` double DEFAULT NULL,
  `credit_total` double DEFAULT NULL,
  `credit_used_amount` double DEFAULT NULL,
  `house_location` varchar(255) DEFAULT NULL,
  `house_type` varchar(255) DEFAULT NULL,
  `house_value` varchar(255) DEFAULT NULL,
  `small_loan_balance` double DEFAULT NULL,
  `small_loans_num` double DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  `vehicle_value` varchar(255) DEFAULT NULL,
  `page` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('54', null, null, '2020-06-11 14:00:57.144000', null, '0', '0', '0', '2020-05-29 17:02:50', '29', '有', '北京', '0', '请选择', '一星', '唐印', '0', '2020-05-29 17:02:50', '张三', '0', '', '昊源-房主信用贷', '是', '0', '20', '12', '0', '', '是', '0', '0', '0', '男', '0', '0', '付费推广', '13261676678', null, '崔战斗', '0', '0', '0', '0', '0', '', '全款房', '0.0', '0', '0', '全款', '0.0', '0', '0');
INSERT INTO `customer` VALUES ('55', null, null, '2020-06-11 13:54:01.107000', null, '0', '0', '0', '2020-05-29 13:30:48', '29', '有', '北京', '0', '待跟进', '三星', '唐印', '0', '2020-05-29 13:30:48', '张三', '0', '151515199011112222', '昊源-公积金贷', '否', '0', '15', '36', '0', '', '是', '0', '0', '0', '男', '0', '0', '付费推广', '13520983068', null, '刘缤灿', '0', '0', '0', '0', '0', '', '请选择', '0.0', '0', '0', '请选择', '0.0', '0', '0');
INSERT INTO `customer` VALUES ('58', '2020-06-11 14:04:01.775000', null, '2020-06-12 00:33:35.908000', null, '0', '0', '0', '', '30', '有', '上海', '0', '请选择', '请选择', '', '0', '', '', null, '', '', '否', '0', '0', '0', '0', '', '否', null, '0', '0', '请选择', '0', '0', '请选择', '', null, 'admin', '2', '0', '0', '0', '0', '', '请选择', '0.0', '0', '0', '请选择', '0.0', '0', '0');

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `age` bigint(20) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `page` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of example
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');
INSERT INTO `hibernate_sequence` VALUES ('59');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `is_credit` varchar(255) DEFAULT NULL,
  `max_age` bigint(20) DEFAULT NULL,
  `min_age` bigint(20) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `overdue` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `workplace` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `accumulation_fund_amount` varchar(255) DEFAULT NULL,
  `accumulation_fund_individual` varchar(255) DEFAULT NULL,
  `accumulation_fund_time` varchar(255) DEFAULT NULL,
  `business_license` varchar(255) DEFAULT NULL,
  `company_detailed` varchar(255) DEFAULT NULL,
  `debts` varchar(255) DEFAULT NULL,
  `house_property` varchar(255) DEFAULT NULL,
  `length_of_service` varchar(255) DEFAULT NULL,
  `low_profit_loan` varchar(255) DEFAULT NULL,
  `own_vehicle` varchar(255) DEFAULT NULL,
  `personal_detailed` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `social_security_amount` varchar(255) DEFAULT NULL,
  `social_security_time` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `page` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `business_license_period` bigint(20) DEFAULT NULL,
  `credit_balance` double DEFAULT NULL,
  `credit_card_usage` double DEFAULT NULL,
  `credit_total` double DEFAULT NULL,
  `credit_used_amount` double DEFAULT NULL,
  `house_location` varchar(255) DEFAULT NULL,
  `house_type` varchar(255) DEFAULT NULL,
  `house_value` double DEFAULT NULL,
  `small_loan_balance` double DEFAULT NULL,
  `small_loans_num` bigint(20) DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  `vehicle_value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', '2020-05-28 14:55:33.631000', null, '2020-06-07 06:16:52.240000', null, '否', '55', '22', '', null, null, null, '北京', '融意贷', '/file/show?fileName=aa.docx', '<p><strong>额度</strong>：1-30万、放款时间：3--5个工作日&nbsp;信用卡形式发放</p><p>期限：1—3年&nbsp; &nbsp;&nbsp;<strong>年龄</strong>：男23-59周岁&nbsp;女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '北京', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('3', '2020-05-29 01:02:43.921000', null, '2020-06-11 14:58:21.234000', null, '否', '56', '23', '', '否', null, null, '北京', '平安新一贷', '/file/show?fileName=aa.docx', '<h2>华夏银行</h2><p><strong>额度</strong>：1-30万、放款时间：3--5个工作日 信用卡形式发放</p><p>期限：1—3年&nbsp;&nbsp;&nbsp; <strong>年龄</strong>：男23-59周岁 女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p><p><strong>利息：月0.75%-0.95%，现优惠活动利息0.6%，前6个月免息</strong></p><p><strong>进件要求</strong>：工资扣税打卡，税前不低于5000，税后不低于4700，半年可进，工资在10000以上的三个月可以进件</p><p>公积金：个人缴费基数不低于600</p><p>社保：按月收入5000以上来缴存（即550以上）</p><p>税单：月缴费不低于45元</p><p><strong>额度：优质单位：月收入12--25倍普通单位：月收入8---15倍</strong></p><p>征信：两年内无连3累4，参考近五年征信逾期，当前不能有逾期，优质客户可沟通</p><p>负债：信用卡近半年和当月使用额度不能超过总额70%</p><p>查询次数：2个月&lt;4次</p><p>负债比：收入—信用贷月供—信用卡已使用额度10%</p><p><strong>资料：</strong>身份证、储蓄卡、近六个月工资流水，社保基数，住房公积金（任选其一）、工作收入证明（单位开具，加盖公章：人事、公章、财务任选其一）</p><p>注意：单位需有114登记（如没有，可114注册，600一年，几天搞定）或公司有官网</p><p><strong>流程：资料齐全—客户经理上门办理—初审电核—提交华夏系统—复审电核—放款（可控制）</strong></p><p><strong>优势：</strong>1、代发一万以上，三个月打流水可申请&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>2 、公检法一线员工、部队军官以上可申请，部队要有电话，城管协警办不了</p><p>3、有小额贷款的客户可申请，正常按负债计算。</p><p>4、不用提供消费凭证，不用夫妻双方签字。不打老婆亲属电话</p><p>5、有房贷，研究生学历可以加分。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>6 、贷款征信只体现信用卡，不算负债，不影响客户买房贷做贷款。</p><p>7、还进去的钱可以再刷出来，满三年后提交放款表拍照循环使用不需重新提交申请资料&nbsp;</p><p>8、保险业务员可做8倍，保险后勤人员好批，链家代发3万以上经理可以做</p><p>限制行业；KTV酒吧员工，无业，自由职业，保安，一线销售，保险代理不行（正规员工可以，房地产中介区域经理以上）</p><p><br>&nbsp;</p>', '0.0', '0.0', '0', '有', '0.0', '0.0', '0', '0', '0.0', '0', '0.0', '0.0', '0.0', '0', '', '0', '0', '2', '0', '0', '0', '0', '', '请选择', '0', '0', '0', '请选择', '0');
INSERT INTO `product` VALUES ('4', '2020-05-29 01:04:40.056000', null, null, null, '否', '60', '20', '', null, null, '0', '', '苏宁公积金贷', '/file/show?fileName=aa.docx', '<p><strong>额度</strong>：1-30万、放款时间：3--5个工作日&nbsp;信用卡形式发放</p><p>期限：1—3年&nbsp; &nbsp;&nbsp;<strong>年龄</strong>：男23-59周岁&nbsp;女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p>', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('5', '2020-05-29 01:05:50.318000', null, null, null, '否', '55', '25', '', null, null, '0', '', '平安银行车主贷', null, '<p><strong>额度</strong>：1-30万、放款时间：3--5个工作日&nbsp;信用卡形式发放</p><p>期限：1—3年&nbsp; &nbsp;&nbsp;<strong>年龄</strong>：男23-59周岁&nbsp;女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p>', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('6', '2020-05-29 01:08:32.620000', null, '2020-06-11 14:36:54.398000', null, '否', '60', '18', '', '否', null, null, '', '南京银行诚易贷', null, '<p><strong>额度</strong>：1-30万、放款时间：3--5个工作日&nbsp;信用卡形式发放</p><p>期限：1—3年&nbsp; &nbsp;&nbsp;<strong>年龄</strong>：男23-59周岁&nbsp;女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p>', '0.0', '0.0', '0', '有', '0.0', '0.0', '0', '0', '0.0', '0', '0.0', '0.0', '0.0', '0', '上海', '0', '0', '0', '0', '0', '0', '0', '', '请选择', '0', '0', '0', '请选择', '0');
INSERT INTO `product` VALUES ('11', '2020-05-30 04:08:21.073000', null, null, null, null, '59', '23', '', null, null, '0', '', '华夏银行', null, '<h2>华夏银行</h2><p><strong>额度</strong>：1-30万、放款时间：3--5个工作日&nbsp;信用卡形式发放</p><p>期限：1—3年&nbsp; &nbsp;&nbsp;<strong>年龄</strong>：男23-59周岁&nbsp;女23-54周岁</p><p><strong>提前还款</strong>：满1个月后剩余本金3%</p><p><strong>利息：月0.75%-0.95%，现优惠活动利息0.6%，前6个月免息</strong></p><p><strong>进件要求</strong>：工资扣税打卡，税前不低于5000，税后不低于4700，半年可进，工资在10000以上的三个月可以进件</p><p>公积金：个人缴费基数不低于600</p><p>社保：按月收入5000以上来缴存（即550以上）</p><p>税单：月缴费不低于45元</p><p><strong>额度：优质单位：月收入12--25倍普通单位：月收入8---15倍</strong></p><p>征信：两年内无连3累4，参考近五年征信逾期，当前不能有逾期，优质客户可沟通</p><p>负债：信用卡近半年和当月使用额度不能超过总额70%&nbsp;</p><p>查询次数：2个月&lt;4次</p><p>负债比：收入—信用贷月供—信用卡已使用额度10%</p><p><strong>资料：</strong>身份证、储蓄卡、近六个月工资流水，社保基数，住房公积金（任选其一）、工作收入证明（单位开具，加盖公章：人事、公章、财务任选其一）</p><p>注意：单位需有114登记（如没有，可114注册，600一年，几天搞定）或公司有官网</p><p><strong>流程：资料齐全—客户经理上门办理—初审电核—提交华夏系统—复审电核—放款（可控制）</strong></p><p><strong>优势：</strong>1、代发一万以上，三个月打流水可申请&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p><p>2&nbsp;、公检法一线员工、部队军官以上可申请，部队要有电话，城管协警办不了</p><p>3、有小额贷款的客户可申请，正常按负债计算。</p><p>4、不用提供消费凭证，不用夫妻双方签字。不打老婆亲属电话</p><p>5、有房贷，研究生学历可以加分。&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p><p>6&nbsp;、贷款征信只体现信用卡，不算负债，不影响客户买房贷做贷款。</p><p>7、还进去的钱可以再刷出来，满三年后提交放款表拍照循环使用不需重新提交申请资料&nbsp;</p><p>8、保险业务员可做8倍，保险后勤人员好批，链家代发3万以上经理可以做</p><p>限制行业；KTV酒吧员工，无业，自由职业，保安，一线销售，保险代理不行（正规员工可以，房地产中介区域经理以上）</p>', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('12', '2020-05-30 05:56:32.046000', null, null, null, null, '55', '18', '', null, null, '0', '', '世联房值贷', null, '<p>产品大纲</p><p>产品特点凭房屋按揭月供流水申请凭公积金缴存流水申请凭全日制本科学历申请</p><p>受理年龄大陆公民，18-55 周岁</p><p>受理区域</p><p>申请人在北京居住或工作</p><p>（福建：身份证号前两位为35, 陕西榆林：身份证号前四位为6108、6127 禁入）</p><p>贷款期限12/24/36 期</p><p>综合成本6 厘4/月一1 分14/月</p><p>贷款金额最高20 万</p><p>放款时间当日放款放款日=还款日</p><p>支持银行. 中、工、建、平安（推荐）</p><p>提前还款无违约金</p><p>还款方式等额本息</p><p>申请资料</p><p>身份证、房本/购房合同/按揭合同</p><p>/房管局产调</p><p>公积金管官网/APP/支付宝可查缴</p><p>存记录</p><p>学信网可查学籍记录（优先）、毕</p><p>业证原件</p><p>申请流程本人实名手机号APP 申请—出额/审核—面签（额外提供贷款用途合同）—放款</p><p>工作要求受薪类：≥6 个月，含试用期，不含实习期自雇类：企业经营年限≥12 个月（需营业执照满1 年）</p><p>基本要求</p><p>①有全国按揭房（贷款类型为“个</p><p>人住房贷款”“个人商用房（包括</p><p>商住两用）贷款”</p><p>②距离按揭房还款结束≥4 年</p><p>③按揭已还款≥6 个月</p><p>④本人征信报告中必须有按揭房</p><p>记录，且房产按揭贷款的主贷人必</p><p>须是产权所有人（房贷占比50%）</p><p>⑤房产为商品房住宅、商住两用</p><p>房（不含厂房、商铺）</p><p>①当前缴存状态为正常</p><p>②近一年连续缴纳≥6 个月，近6</p><p>个月不能有断、停缴，无基数限制。</p><p>在现在单位需要缴满6 个月</p><p>③只接受月缴、季缴、半年缴，不</p><p>接受年缴</p><p>①全日制本科及以上学历；（只认</p><p>正常专升本或包统招专升本。自</p><p>考、函授不认）</p><p>征信要求</p><p>账户状态：当前逾期（逾期500 元内补还款记录可以）、冻结、止付、呆账、资产处置、保证人代偿、</p><p>次级、可疑、损失、展期、担保人代还、以资抵债、欠税记录、欠费记录（500 元以上）、法院民事</p><p>判决和强制执行记录、行政处罚记录</p><p>查询：2 个月内查询次数&lt;7 次（含贷款审批、信用卡审批、个人查询）</p><p>逾期：半年内无2; 一年内无3; 两年内无3 个2</p><p>信用卡： 持有4 家（含）以上银行贷记卡，且已用额度使用率达90%（含）以上不予接受； 持有6</p><p>家以上银行贷记卡，且额度使用率80%（含）以上不予接受。</p><p>授信政策</p><p>收入认定：综合判断</p><p>负债认定：信用卡使用额度的10%; 其他信用贷当月实际还款额</p><p>（个人担保贷款计算负债，代他人担保不计负债，抵押类贷款不计负债）</p><p>禁入人群</p><p>1.已列入人民法院失信被执行名单且尚未履行的人员；</p><p>2.有犯罪记录的人员；</p><p>3.有吸毒、聚众赌博等有不良嗜好的人群；</p><p>4.从事非法职业的人员：色情、毒品、地下钱庄、非法赌博、非法传销、私家侦探、保缥；</p><p>5.从事娱乐服务行业工作人员：酒吧、夜总会、歌舞厅、KTV、游戏厅、棋牌室、网吧、足浴按摩、美容院、发廊；</p><p>6.高失联人群：海员、远洋捕捞船员、建筑工人、包工头、外派人员；</p><p>7.高危工作人群：煤矿下井矿工、潜水、跳伞、爆破、特技人群；</p><p>8.非正规的民间金融行业、非正规的典当行业、非正规的债务催收公司从业人员、小额贷款公司工作人员、贷款中介公</p><p>司工作人员；非正规演艺行业（包括非正规的歌舞团、戏剧团、舞台表演、魔术团、杂技团、小型乐团、演出公司、</p><p>剧场等）从业人员；</p><p>9.无业或非正式工作者：离退休人员、学生、目由职业者；</p><p>10.无稳定工作行业：保安、交通协管员、停车收费员、门卫、货车司机、出租司机；</p><p>11.若申请人作为法定代表人或出资股东、职员的企业已列入经营异常名单、有逾期或其他不良征信记录情况的人员；</p><p>12.高危、两高一剩行业的一般从业人员：煤炭、钢铁、水泥制造、甲醇燃料、直销、传销；</p><p>13.涉及国家安全受到保护的特殊行业：现役军人、武警、公安，其中军医和军事院校教师类军官除外；</p><p>14.检察院、法院和公安局系统工作人员。</p>', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('14', '2020-05-30 06:20:49.926000', null, '2020-06-01 09:56:06.469000', null, null, '55', '22', '', null, null, null, '', '渣打银行', null, '<figure class=\"table\"><table><tbody><tr><td>&nbsp;</td><td colspan=\"10\">渣打银行个人无抵押信用贷款</td></tr><tr><td>&nbsp;</td><td>利息：</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td colspan=\"4\" rowspan=\"4\">&nbsp;</td></tr><tr><td>&nbsp;</td><td>批款资金</td><td colspan=\"5\">8000-50万&nbsp;</td></tr><tr><td>&nbsp;</td><td>普通客户</td><td colspan=\"5\">月利率 0.7%-0.9%</td></tr><tr><td>&nbsp;</td><td>优质客户</td><td colspan=\"5\">月利率&nbsp; 0.55%-0.8%</td></tr><tr><td>&nbsp;</td><td colspan=\"10\">　</td></tr><tr><td>&nbsp;</td><td colspan=\"4\">月供贷</td><td rowspan=\"12\">&nbsp;</td><td colspan=\"4\">工薪贷</td><td rowspan=\"14\">　</td></tr><tr><td>&nbsp;</td><td rowspan=\"4\">产品优势</td><td colspan=\"3\">无需工资流水</td><td rowspan=\"3\">产品优势</td><td colspan=\"3\">最短3个月代发工资</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">月供一月</td><td colspan=\"3\">最长 5 年&nbsp;</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">全国房产（多套累加）</td><td colspan=\"3\">无需配偶知晓</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">无需配偶知晓</td><td rowspan=\"3\">必备条件</td><td colspan=\"3\">代发税前5千以上</td></tr><tr><td>&nbsp;</td><td rowspan=\"4\">必备条件</td><td colspan=\"3\">仅限住房贷款（抵押无效）</td><td colspan=\"3\">年龄22-55周岁</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">社保3个月且同一家单位</td><td colspan=\"3\">负债不超65%</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">不能是社保单位法人或股东</td><td rowspan=\"3\">申请资料</td><td colspan=\"3\">身份证</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">月供2500以上且房贷金额大约10万</td><td colspan=\"3\">流水（最近3-12个月）</td></tr><tr><td>&nbsp;</td><td rowspan=\"3\">申请资料</td><td colspan=\"3\">身份证（必须带磁）</td><td colspan=\"3\">社保和公积金截图<br>（辅助资料，现场截图）</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">社保公积金截图（现场）</td><td>批款倍数</td><td colspan=\"3\">认定工资15倍</td></tr><tr><td>&nbsp;</td><td colspan=\"3\">房贷网银截图（现场）</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>收入认定</td><td colspan=\"3\">月供2500-6000元，按3倍认定<br>月供6000-13000元，按2.5倍认定<br>月供13000元以上，按2倍认定</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>批贷倍数</td><td colspan=\"3\">房贷月供30倍左右</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>　</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td rowspan=\"7\">征信要求</td><td colspan=\"2\">半年以上的征信记录</td><td rowspan=\"2\">负债计算</td><td colspan=\"2\" rowspan=\"2\">信用卡按已用额度10%，<br>贷款按月供金额</td><td rowspan=\"4\">限制行业</td><td>房地产中介</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">当前不能有两个1</td><td>房地产销售</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">当前不能有一个2</td><td rowspan=\"5\">负债比率</td><td colspan=\"2\" rowspan=\"5\">例如：&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;信用卡用了2万，贷款月供<br>3千。 负债比为（2万*10%+<br>3千）+（渣打可贷额度的月供）《税前月收入*65%</td><td>美容美发</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">两年内不能有4</td><td>娱乐行业</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">五年内不能有7</td><td colspan=\"2\" rowspan=\"3\">&nbsp;</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">最近3月查询6次</td><td>&nbsp;</td><td>　</td></tr><tr><td>&nbsp;</td><td colspan=\"2\">最近半年查询9次</td><td>　</td><td>　</td></tr></tbody></table></figure>', '0.0', '0.0', '0', null, '1000.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('18', '2020-06-01 04:06:43.088000', null, '2020-06-01 09:48:42.093000', null, null, '59', '18', '', null, null, null, '', '恒生银行', null, '<p><strong>工薪贷申请条件</strong></p><p>*年龄：<strong>18--59</strong>周岁</p><p>*群体：税后代发<strong>5000</strong>以上的上班族</p><p>&nbsp;</p><p><strong>进件条件（普通和优质2选1）</strong></p><p><strong>一：普通客户（</strong>近半年有稳定缴税工资）</p><p><strong>二：优质客户</strong>(以下4选一）</p><p>1.房产客户（在北上广深佛山杭州天津有房客户）</p><p>2.房贷客户（征信显示有未结清的房贷且正常还款1年以上，不限城市）</p><p><strong>3.公积金客户（近24个月累计缴纳18个月且近6个月连续）</strong></p><p>4.优质单位客户（事业单位，500强，上市公司，公务员等）</p><p>&nbsp;</p><p><strong>利息&nbsp;期限与还款方式</strong></p><p><strong>等额本息&nbsp; &nbsp;月：0.59-0.75&nbsp; &nbsp; &nbsp; &nbsp;</strong></p><p><strong>先息后本&nbsp; &nbsp;月：1.08</strong></p><p>*年限：1--5年任选</p><p>*申请到放款：2-3工作日</p><p>金额：1-50万（30万以上需要第三方受托支付）</p><p>备注：普通客户不能申请先息后本且贷款金额上限为20万</p><p>&nbsp;</p><p><strong>先息后本举例&nbsp; （</strong>月付息，年归本，每年年底需归还<strong>1/n</strong>本金（<strong>n</strong>贷款年限），次年按剩余本金计息，利息逐年降低）</p><p><strong>10万1年利息13000；2年利息19500；3年利息26000；4年利息32500；5年利息39000。</strong></p><p><strong>以贷款10万3年为例，先息后本还款，1-12月，月还1083元，第12月还1/3本金33333.33元；13-24月，月还722元，第24月还本金33333.33元；25-36月，月还361元，第36月还本金3333.33元；36个月，总利息26000元</strong>。</p><p>&nbsp;</p><p><strong>征信与负债把控</strong></p><p>*客户综合负债情况不得大于月收入的65%，收入1.5万负债比不超70%</p><p>*信用卡按10%看负债（<strong>若客户行用卡使用都是全额还款且未有明显套现，未做分期和最低还款，提供近2个月对账单，可以不看本张信用卡负债</strong>）</p><p>*征信当前不能有2，单张卡两年内不能连三累六，可接受当前有1（必须结清）500以下逾期可忽略</p><p>*近3个月查询不得超过6次 近1个月查询不超过3次（可第四次） 贷后查询和本人查询不算</p><p>&nbsp;</p><p><strong>收入认定：</strong></p><p>工资流水1比1认定收入，公积金月缴纳全额可以认定为收入</p><p>工资流水如包含年终奖，可认定70%的月收入</p><p>&nbsp;</p><p><strong>准备资料：</strong></p><p>1.身份证</p><p>2.近6个月工资流水（优质客户3个月流水即可)</p><p>3.公积金卡（普通客群以税单代替公积金）</p><p>4.住址证明(<strong>北京房本、居住卡、工作居住证、银行对账单总览明细、网购订单或者外卖平台近三个月任3笔，显示客户姓名邮寄到住宅地址显示已完成的订单（以上住址证明任选其一即可）。</strong></p><p>&nbsp;</p><p><strong>违约金：</strong></p><p>&nbsp;</p><p>提前还款须收取剩余贷款金额5%违约金</p><p>备注：客户换工作，刚到本单位，如若流水，公积金未中断，可以进件</p><p>禁入：军人，一线工人，出租公交司机，p2p从业等 （房地产经纪人可做）</p>', '0.0', '0.0', '0', '', '20000.0', '10000.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', null, '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('39', '2020-06-07 06:11:41.199000', null, null, null, null, '55', '25', '', null, null, null, null, '车主贷', null, '', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('40', '2020-06-07 06:13:36.094000', null, null, null, '否', '55', '22', '', '否', null, null, null, '小数云贷', null, '', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('41', '2020-06-07 06:18:48.168000', null, null, null, null, '55', '25', '', null, null, null, null, '友金快贷', null, '', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('42', '2020-06-07 06:20:26.665000', null, null, null, null, '57', '20', '', null, null, null, null, '盛逸金', null, '', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('43', '2020-06-07 06:21:58.766000', null, null, null, null, '59', '22', '', null, null, null, null, '家庭消费贷', null, '', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('44', '2020-06-07 06:23:13.103000', null, '2020-06-07 06:23:50.869000', null, null, '54', '20', '', null, null, null, null, '房信贷', null, '<p>产品优势</p><p>①全部先息后本，随借随还，按日计息，提前还款无违约金</p><p>②不电核，不下户，不联系配偶，不提供发票</p><p>③最高额度30 万（具体额度计算详询客户经理）</p><p>客群及利率</p><p> ①有北京地区商业银行发放的住房按揭</p><p>贷款（公积金贷款不可以），贷款金额</p><p>50 万以上，且还款满24 个月，执行利</p><p>率8.6%-14.6%，该产品不看职业行业及</p><p>收入，满足按揭及征信要求，有房本就</p><p>可以申请</p><p> ②中信本行住房按揭贷款客户及抵押贷</p><p>客户（抵押经营，抵押消费），年化利率</p><p>8.6%-14.6%。</p><p>客群及利率</p><p> 向客户经理咨询您的公积金缴存单位是</p><p>否在我行准入白名单内（国管、市管公</p><p>积金均可），</p><p> 近两年公积金连续缴存，申请当月上个</p><p>月的公积金需完成汇缴，事业单位、公</p><p>务员个人缴存门槛需大于925 元，其他</p><p>单位不低于750 元，具体详询客户经理。</p><p>专享年化利率6.49%</p><p> 非白名单客户额度为个交公积金80 倍</p><p>左右，年化利率8.6%-14.6%，只需个交</p><p>公积金756 元即可申请，三方代缴亦可</p><p>税金贷与公积金贷基本要素一致，只是提交</p><p>材料为客户个人所得税税单</p><p>面签材料及流程</p><p> 身份证</p><p> 按揭房房产证（复印件）</p><p> 人行征信（近期原件）</p><p>流程：①本行房抵（经营、按揭，消费、信</p><p>托）客户可以直接来我支行办理放款卡并申</p><p>请，无需额外材料，征信通过当天放款。</p><p>②北京地区他行按揭可当天来行办卡预审批</p><p>额度，备齐材料后约3 个工作日放款。</p><p>面签材料及流程</p><p> 身份证</p><p> 名片或者工牌等辅助工作证明</p><p> 需可以自行登录公积金官网网站（知道</p><p>密码）</p><p> 税单（仅税金贷需要）</p><p>流程：公积金贷（税金贷）当天采集一般当</p><p>天或第二工作日放款</p><p>征信要求</p><p>①六个月之前发放的小贷结清后征信更新才可申请，不能有近六个月发放的小贷（金额2000</p><p>以下可以）。其中：小贷指征信上含有小额贷款公司字样贷款及信托发放的信用贷</p><p>②已提款的信用贷不超过五家（其中经营贷不超过3 家，组合担保房贷计入家数）</p><p>③当前银行信用贷余额不超过100 万。</p><p>④逾期：当前无逾期；两年内连2 累3,；5 年内连3 累9</p><p>⑤不看信用卡分期负债</p><p>⑥近半年征信查询次数不超过9 次</p><p>⑦年龄20-54（含）周岁</p>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('45', '2020-06-07 06:25:39.952000', null, null, null, null, '56', '25', '', null, null, null, null, '大数时贷', null, '<p><strong>一、基本情况</strong>：</p><p><strong>1.年龄</strong>： 25-56周岁之前；<strong>额度</strong>：10-70万； <strong>还款期限</strong>:1年2年3年期；等额本息。</p><p><strong>2.查询次数</strong>：6个月内≤<strong>11</strong>次（<strong>现行政策取消对查询次数的要求，但是查询次数也会影响客户评分</strong>）</p><p><strong>3.负债要求：信用卡全额+信用贷款余额&lt;100万 （优质客户可达120万）</strong></p><p><strong>4.</strong> “<strong>三非”</strong>：如非本地户籍，北京征信（居住信息或工作信息）必须满半年。非京籍白户算三非。</p><p><strong>5.机构与费率：（费率根据系统跑批，平均1-1.46之间）</strong></p><p>目前可准入机构：太保、东营、承德、宁波通商、大地。</p><p>※ <strong>放款机构可以叠加一起申请，最高70万</strong> （月均成本：包括了银行月供，大数金融的评审费和大数金融每个月的担保费。半年之后接受提前还款，收取剩余本金5%的违约金）</p><ol><li><strong>评分政策：低分、中分、高分、超高分。</strong></li><li><strong>女客户：</strong>高分女性都可做。中分女性符合以下2点任意一点①本人名下有未结清按揭房贷②有可核查到的北京房产。否则，需要查询配偶征信查配偶征信。</li><li><strong>限准人群</strong>：军人，律师，记者，房地产中介门店人员，美容美发美甲，娱乐行业等。福建3522和3509开头的不准入，但优良职业人士除外。公检法属于优良职业（暂时禁入）。</li><li><strong>面签资料</strong>：<strong>身份证+工商银行（和本人使用手机绑定、备选浦发/光大）</strong>+房本/复印件+保单账号密码+工作证明+结婚证+社保公积金账号密码</li></ol><p><strong>二、贷款类型</strong></p><p><strong>1.房供贷：（还款0个月以上-结清一年内，全国房贷或者抵押（经营、消费）的等额本息还款方式）</strong></p><p>还款期数≧0个月，或<strong>结清≦1年</strong>，但贷款期限必须&gt;24期。</p><p><strong>注：最高可贷：70万，平均可贷倍数：88倍</strong></p><ol><li><strong>超分贷：客户具有良好征信，且通过我司评分系统为超高分，将直接给予5-50万的批款。无需流水、无需保单、无需房/车供、无需代发工资，无社保公积金，超高分优质客户，符合原产品可选金额高者进件，原产品不过仍可获批款最高50万。</strong></li></ol><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p><strong>3.房产贷（京籍白户可做）*大数易贷</strong></p><p>房产条件：<strong>&nbsp;</strong></p><p>（1）房产为北京地区所有区县可查产权清晰的 商品房，包括住房、商住两用房、写字楼、经济适用房、房改房、限价房（公司房产、商铺、自建房、小产权房、军产房不可）</p><p>（2）<strong>如房产当前状态为“抵押”，抵押权人不得为非银行机构（中信信托除外），且借款人/直系亲属名下须有未结清房贷；</strong></p><p>（3）产权为共有的，需查询共有产权人征信（不满18岁，超过65岁除外）。</p><p><strong>注：最高可贷：70万 平均可贷倍数：房值所占份额的30%</strong></p><p>备注：房屋价值以登录北京链家或房天下网站，核实房产所在小区本月成交均价，根据建筑面积确定房屋总值。</p><p><strong>4.车供贷：（京籍全国车客户，非京籍高分及以上可做）</strong></p><p>还款期数≧1年，结清≦6个月，原车贷发放金额≧6万，车型不限。月供类型，可以是信用卡分期（提供信用卡）</p><p><strong>最高可贷：70万，平均可贷倍数：78倍</strong></p><ol><li><strong>保单贷：（京籍白户可做，纯保单可做）</strong></li></ol><p><strong>一共可认定43家保险公司</strong>：平安、人寿、泰康、新华、人保、友邦、阳光、太平洋、太平、生命、中宏、中意、招商信诺、中英、工银安盛，中美大都会，信泰人寿，中德安联，建信人寿，利安人寿，陆家嘴人寿，民生，农银，华泰，合众，国华，长城，华夏，同方全球，光大永明，英大,&nbsp;恒安，恒大，东吴，幸福、吉祥、中银三星，百年，君龙，北大方正，长生，交银康联，汇丰。最多3份保单可叠加。</p><p>保单<strong>满2年3次缴费</strong>，2年内不超过<strong>70天</strong>未交费，结清60天以内也可以。不能趸交。</p><p><strong>注：平均45倍，已缴费时间长、缴费金额大共同参考。</strong></p><p><strong>无忧贷：产品政策与大数时贷相同</strong></p><p>额度10-20万、利息1.4左右，加大审批尺度，让更多的客户可以获得借款。</p>', '0.0', '0.0', '0', null, '0.0', '120.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('47', '2020-06-07 06:29:01.292000', null, null, null, null, '60', '23', '', null, null, null, null, '优信贷', null, '<p>借款人要求：</p><p>优信贷</p><p>1、大陆人士，借款人23—60 周岁，共借人18—65 周岁。配偶为外籍的，在有财产分割公正的前提下，产权</p><p>人可与本市有房的朋友共借，配偶不用出面。</p><p>2、房产借款合同上的借款人、抵押人、保证人均作为借款人。</p><p>3、产权人需为主借人，共同借款人最好为产权人的配偶/直系亲属（父母、兄弟姐妹及子女）/本市有房的朋友。</p><p>离异、单身、丧偶的，申请50万（含50万）以下可以单签；申请50万以上需提供共借人。</p><p>客群分类：</p><p>A 类：本市户籍</p><p>B 类：非本市户籍（本地有二套及以上可查档房产，单套不低于50平米。第二套可为商办物业）</p><p>C 类：本地营业执照，且实际持股或经营满5年及以上</p><p>D 类：本市社保或公积金累计满5年（近6个月需连续正常，且累计不间断超6个月）</p><p>E 类：全国/本市高新企业（近一年纳税申报额不低于1500 万）占股5%（含）以上股东或实际控制人</p><p>关于准入客群5年要求的，如果产权人不满足，以家庭为单位，配偶或直系亲属单方满足也可以。本市有房的朋</p><p>友不计入。</p><p>禁件人群：</p><p>现役军人和武警官员；公检法等执法机关人员及司法机关相关人员；贷款中介及小贷公司等同行。</p><p>房产要求：</p><p>1、住宅、公寓、别墅，实际居住的房产（必须可查档核实）多套房产额度可以累加，累加的房产需满足抵押</p><p>情况及还款情况。评估值在350-400万只能申请36万，＞400万，可以申请36万以上的额度。借款额度超过50万需</p><p>要做公证</p><p>2、名下有房产按揭/抵押贷款且正常还款6 个月以上，不限还款方式和贷款期限、公积金贷款可以。</p><p>3、城六区1975 年后；其他地区1985 年后</p><p>一抵必须在银行，二抵在指定白名单机构可进件（白名单机构同优利贷白名单），二抵不需要还满6个月。</p><p>抵押贷款在企业名下（为“企业流动资金”贷款且企业在借款人名下）可进件；</p><p>征信要求：（主借+共借要求一样）</p><p>逾期要求1、贷款类：近6个月最多6个1，不能有2，近12个月不能有3 ，近24个月不能有4 。</p><p>2、信用卡类：近6个月不能有2个2，近12个月不能有3，近24个月不能有4</p><p>信用卡和贷款合计使用额度需要&lt;0.98 主共借人，其中任意一方名下信用类负债＞140万，不准入。</p><p>信用卡使用率超80%的，还到80%以下，提供还款凭证可做</p><p>贷记卡法人机构数&gt;4，未销户贷记卡机构平均授信额度需要≥1.5万。准贷记卡不计入此项要求。</p><p>贷款/信用卡当前有逾期，逾期金额＜5000，需提供结清证明，≥5000的不准入</p><p>贷款审批+信用卡审批+保前审查+融资审批：近6 个月≤9次</p><p>同一家机构在连续14个自然日内同一种因查询，算作一次</p><p>A/B/C/D 类客群授信规则：</p><p>1、上限150 万2、评估值的3 成（京籍） 评估值1.5 成（非京籍）</p><p>负债计算方式：房值*90% —（本笔房贷余额+信贷余额+信用卡使用额度+已核实的第三方负债）＞0</p><p>E 类客群授信规则：</p><p>1、额度80万/100万/120万/150万（不超过估值的3成） 2、单个企业仅可以申请一笔贷款</p><p>授信额度36万-150万</p><p>还款方式定额月息-期本3% 等本等息等本等息</p><p>期限20期20期36期</p><p>利率1.39%/月1.09%/月1.38%/月</p><p>公证费借款金额的千0.78</p><p>手续费3.5%（放款前先交，需转对公账户）</p><p>服务费1.5%（放款前先交）</p><p>提前还款提前还款需提前15天申请：加收3个月利息</p><p>展期不允许展期</p><p>逾期应还金额的0.1%/日收取，包含当前未还本金、当月未还利息</p><p>申请资料：</p><p>1、优贷业务申请表、征信查询授权书、信息查询及使用授权书</p><p>2、身份证、户口本(主借款人+共同借款人)</p><p>3、婚姻证明（结婚证、离婚证，离婚协议或法院判决书） —非夫妻的额外加关系证明</p><p>4、房产证/房本复印件/预售房合同（须有交房页+购房发票）</p><p>5、贷款合同（注：公积金贷款或组合贷款需要公积金中心开具的还款流水）</p><p>6、近半年流水</p><p>7、营业执照（企业主或占股10%以上的股东）</p><p>8、贷款用途证明</p><p>9、合影</p><p>10、有二抵的，提供二抵贷款合同及还款流水（超过半年的提供半年）</p><p>11、主借人放款卡（只能选择工商、中国、建设、光大、广发、平安、招商、兴业、浦发）</p><p>房贷在企业名下:企业征信+提供贷款合同及还款流水（超过半年的提供半年）</p><p>E类客群除以上材料外需增加：</p><p>1、核心文件：高新企业证书+最近一年度纳税申报表+企业及实际控制人简介</p><p>2、建议提供最近一年度仅审计的财务报表+主/共借人其他房产资料+发明专利证书+企业征信报告</p>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('48', '2020-06-07 06:30:58.480000', null, null, null, null, '65', '18', '', null, null, null, null, '北京中银消费金融产品', null, '', '0.0', '0.0', '0', null, '0.0', '30.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('49', '2020-06-07 06:41:19.497000', null, '2020-06-07 06:41:41.089000', null, null, '100', '0', '', null, null, null, null, '爱分期', null, '<p><strong>普通单位额度：30</strong>万,月<strong>费率0.35%&nbsp;</strong>/优质单位：50万,月费率0.27%<strong>年限：</strong>最长3年&nbsp;，期限12/24/36期&nbsp; &nbsp;&nbsp;<strong>年龄：&nbsp;</strong>21-55周岁</p><p><strong>特点：进件广、利息低、时效快、不上贷款征信、（征信显示信用卡）</strong></p><p><strong>白户可做、不电核其他人、刚换单位可做、只看近一月查询</strong></p><p><strong>进件：</strong></p><p><strong>1.年轻学历客群</strong></p><p>满足全日制本科（含）以上学历；毕业年份限2003年（含）以后；</p><p>必须提供稳定性证明。</p><p><strong>2.缴金客户</strong></p><p>提供本人经我行认定的社保/公积金缴金核查记录，可以是最低基数。其中，近9个月内可核查缴金记录需≥6个月且当前连续三个月缴金正常；</p><p><strong>3.工资客户</strong></p><p>提供本人经我行认定的银行代发工资核查凭证，可认定代发月收入需≥5000元，其中，近9个月内代发记录需≥6个月且当前连续三个月代发正常（多本存折/对账单可累计叠加）。</p><p><strong>4.我行认定的优质客户</strong></p><p><strong>5.额度测算：</strong>普通单位可认定收入18倍</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;优质单位可认定收入24倍</p><p><strong>征信：</strong></p><p>1、当前均无&gt;500元金额的滞纳/账龄记录；</p><p>2、近6个月M1滞纳/账龄记录≤1次，无M2及以上滞纳/账龄记录；</p><p>3、近12个月M1滞纳/账龄记录累计≤3次，且M2滞纳/账龄记录≤2次，无M3及以上滞纳/账龄记录；</p><p>4、近24个月存在M3及以上记录；</p><p>5、历史最高逾期期数超标，历史出现过6期及以上逾期;</p><p>6、申请人最近1个月内经不同操作员查询人行征信次数＜4次。查询原因包括信用卡审批、贷款审批和担保资格审查；1个月内同一操作员相同原因的查询记录记作一次。</p><p>7、未结清个人消费贷款笔数≤9&nbsp;</p><p>8、贷记卡当前透支余额≤50万，未结清个人消费贷款余额≤50万</p><p><strong>发卡机构数要求：</strong></p><p>1、当前发卡法人机构数应≤10；</p><p>2、如当前发当前发卡法人机构数6至10，近6月信用卡平均额度使用率应≤70%；</p><p>3、客户名下最低还款卡片张数应≤3张；&nbsp; 当前无任意金额的滞纳/账龄记录；</p><p><strong>还款方式：</strong>等额本息</p><p><strong>放款方式：必须POS消费 （控MCC，禁入房产、投资、理财、税费类）审批通过后180天有效期</strong></p><p><strong>负债收入比：≤</strong>70%</p><p>负债收入比=申请人月支出÷[申请人本人及配偶月收入之和（若有）+申请人本人及配偶金融资产认定金额之和（若有）÷24]；</p><p>*申请人月支出=近6个月信用卡平均使用额度×10%+近6个月贷款月均还款额，个人住房贷款（含公积金贷款）月还款额不计；非按月还款的贷款，月还款额=贷款金额的两倍÷总月数。</p><p><strong>审慎准入职业：</strong></p><p>一线操作工、清洁工、勤杂工、司机、保安、其他临时工、简单体力劳动工（指从事建筑施工等室外作业，或玩具、纺织、制衣、制鞋等劳动密集型企业，或其他简单加工业等的工人）、营业人员、服务人员、佣金制销售及中介代理人员等在内的一线性质的工作人员。</p>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '5000.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('50', '2020-06-07 06:43:20.399000', null, '2020-06-07 09:18:06.878000', null, null, '100', '40', '', null, null, null, null, '瑞宝麟', null, '<figure class=\"table\"><table><tbody><tr><td colspan=\"13\">大额批款附加要求</td></tr><tr><td colspan=\"2\">产品名称</td><td colspan=\"3\">恒业贷</td><td colspan=\"4\">恒税贷</td><td colspan=\"4\">恒好贷</td></tr><tr><td colspan=\"2\">申请额度</td><td>15</td><td>20</td><td>50</td><td>15</td><td>20</td><td>30</td><td>40</td><td>15</td><td>20</td><td>30</td><td>40</td></tr><tr><td rowspan=\"8\">要求</td><td>注册时长&amp;实际经营时长（同时满足）</td><td>≥1</td><td>≥2</td><td>≥3</td><td>≥1</td><td>≥2</td><td>≥3</td><td>≥4</td><td>≥1</td><td>≥2</td><td>≥3</td><td>≥4</td></tr><tr><td>企业股权质押</td><td>股份质押&lt;50%</td><td colspan=\"2\">股份未被质押</td><td>股份质押&lt;50%</td><td colspan=\"3\">股份未被质押</td><td>股份质押&lt;50%</td><td colspan=\"3\">股份未被质押</td></tr><tr><td>近半年企业无借款人变更信息<br>（含股权持有人与份额变更）</td><td colspan=\"3\">/</td><td colspan=\"4\">是</td><td colspan=\"4\">/</td></tr><tr><td>配偶知晓借款</td><td colspan=\"3\">/</td><td colspan=\"4\">/</td><td colspan=\"4\">/</td></tr><tr><td>企业征信</td><td colspan=\"11\">批款金额≥40万，必须提供企业征信</td></tr><tr><td>房产（不区分本/外地）</td><td colspan=\"3\">/</td><td colspan=\"2\">/</td><td colspan=\"2\">有</td><td colspan=\"2\">/</td><td colspan=\"2\">有</td></tr><tr><td>法人要求共借</td><td colspan=\"2\">/</td><td>是</td><td colspan=\"4\">/</td><td colspan=\"4\">/</td></tr><tr><td>特殊情况</td><td colspan=\"3\">&nbsp; 如主要收入来源为自建房出租的客户不受营业执照限制</td><td colspan=\"2\">/</td><td>纳税信用评级为A/M,不受经营年限限制</td><td>1.连续两个纳税年度信用评级均为A；<br>2.年纳税额＞50万<br>以上两个条件同时满足，不受经营年限限制</td><td colspan=\"4\">　</td></tr><tr><td>备注</td><td colspan=\"12\">1.恒好贷&amp;恒税贷<br>&nbsp; &nbsp; &nbsp; &nbsp;涉及诉讼案件，被告无论金额大小，须提供结案证明；有失信和刑事犯罪记录，均不进件；3年内涉及“民间借贷纠纷”或“银行借款金融纠纷”案件，均不进件（含原被告、结案、撤销、在途案件）；<br>&nbsp; &nbsp; &nbsp; &nbsp;营业执照：必须为分公司所在地的营业执照，其他产品以产品大纲为准；<br>2.配偶知晓贷款/经营年限：如客户为我司老客户，还款无逾期；申请续贷时，不满足以上批款额度条件，风控可根据客户实际情况决定是否豁免；</td></tr></tbody></table></figure>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('51', '2020-06-07 06:45:16.849000', null, null, null, null, '58', '25', '', null, null, null, null, '邮储优享贷', null, '<p>年龄：25—58周岁&nbsp; &nbsp; &nbsp;</p><p>额度：15万--50万</p><p>期限：1年期（先息后本）授信3年</p><p>月息：年化5.655</p><p>要求：不能有经营性贷款，结清征信更新可做</p><ol><li>邮储内部白名单</li><li>非白名单的事业单位，国企沾边的优良单位</li></ol><p>优势：不打配偶电话， 不看小贷，网贷，&nbsp; 不看查询次数，远郊可接，逾期可沟通</p><p>负债：除住房商业贷款外，贷款余额+信用卡已使用额度不超70万</p><p>逾期：2年内不连2累6&nbsp; &nbsp; &nbsp; 5年内不连3累20&nbsp;（资质好的客户，可沟通，单笔单议）</p><p>查询：不看</p><p>资料：身份证+公积金卡+学历证书+职级证明</p><p>额度计算：普通员工公积金个缴基数÷0.12×1.34×24－贷贷余额</p><p>管理级别公积金个缴基数÷0.12×1.34×36－贷款余额</p><p>注：62—64年客户要求白名单或公积金个缴2000以上</p><p>贷款余额不超30万，信用卡已使用不超20万</p>', '0.0', '0.0', '0', null, '0.0', '70.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');
INSERT INTO `product` VALUES ('52', '2020-06-07 06:46:27.997000', null, null, null, '否', '55', '23', '', null, null, null, null, '平安普惠', null, '<p><strong>普惠产品基本准入条件：</strong></p><ol><li>年龄：23-55周岁</li><li>非白户：有信用卡，北京牡丹灵通卡，【接受全国征信】，名下有或者有过贷款【农村合作银行申请的贷款，助学贷款，佰仟分期购手机等】</li><li>北京工作满半年【特殊情况除外】</li><li>北京流水满半年【特殊情况除外】</li><li>征信要求:3个月不能有2个1，单月查询不能超过4次，1年不能超过18次，【O2O当前逾期做不了】</li></ol><p><strong>注意：平安普惠所有产品目前无任何手续费用</strong></p><p><strong>普惠产品流程</strong></p><ol><li>产品：保单贷，车主贷，按揭房贷，薪金贷，POS贷</li><li>材料：身份证＋保单（保单原件或无保单原件也可进件）/行驶证/工作/商户刷卡机</li><li>额度：2-50万</li><li>流程：线上申请出额度-视频签约-电核联系-实时放款</li><li>优点：追加贷款，随借随还，按天计息</li><li>特点：线上申请，在家秒贷，快出额度，无需流水，无需征信，无需证明，简单电核，视频面签，实时放款&nbsp;</li></ol><p>&nbsp;</p><p>&nbsp;</p><p><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 寿险贷</strong></p><p><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong>额度2-50万，按保单的年缴费10-45倍</p><p><strong>准入条件：</strong></p><ol><li>保险类型：分红型，传统型，万能型【月缴型连续缴纳2年不能断交】</li><li>生效时间：≥6个月</li><li>申请人必须是投保人</li><li>保单月交保费≥200，年缴保费≥2400</li><li>额度：50万</li><li>利息：0.6—1.79（备注一般给客户报最低六厘利息，最高1分左右）</li></ol><p><strong>申请资料：</strong></p><ol><li>身份证正反面</li><li>保单原件或保单官网账号</li></ol><p><strong>签约资料：</strong></p><ol><li>身份证</li><li>保单原件或保单官网账号</li><li>银行卡</li></ol><p><strong>注意：</strong>目前仅支持传统型，分红型，万能型保单，保单缴费方式：月缴，季缴，半年缴，年缴，申请流程简单，线上申请，可以叠加多份保单，平安保单可秒批【预授信】，无需审批。</p><p>目前线上申请支持的保险公司:平安人寿、中国人寿、太平人寿、新华人寿,太保人寿、生命人寿、阳光人寿、泰康人寿、信诚人寿、合众人寿、福人寿、弘康人寿、永诚人寿、民生人寿、长城人寿、安盘天平人寿、友邦保险、招商信诺、中英人寿、大都会人寿、中意人寿、中国人民、天安、农银、信泰、光大、华夏、国华等。</p><p>&nbsp;</p><p>&nbsp;</p><p><strong>优房贷</strong></p><p>额度：2-50万,月供的30-45倍批款</p><p><strong>准入条件：</strong></p><p>1.全国按揭房,按揭月供还款满3个月结清1年以内</p><p>2.申请人为按揭货款月供本人</p><p>3.年龄：23-55周岁</p><p>4.利息0.6-1.79</p><p><strong>申请材料：一张</strong>身份证</p><p><strong>签约资料：</strong>1.一张身份证秒出额度</p><p>2.银行卡</p><p>&nbsp;</p><p><strong>车主贷</strong></p><p>额度2-30万,目前车值8成批款</p><p><strong>准入条件：</strong></p><p>1.非营远车</p><p>2.九座以下私家车</p><p>3.全款车或按揭车3个月（外地的车或京牌车都可以进件）</p><p>4.商业险和交强险（商业险北京上的或者北京周边200公里）</p><p>5.抵押登记状态无法审请,解障抵押后当时就可申请</p><p><strong>申请材料:</strong></p><ol><li>身份证</li><li>行驶证</li></ol><p>3商业险【平安、中华联合财产、人保、太平洋、安盛、太平、新华、长安、永安、都邦、英大泰和财产、天安、大地、华安、阳光、国泰、安邦、紫金、永诚、安华农业】（必须有商业险才能进件）</p><p>1、身份证2、行驶证3、商业险保单4银行卡</p><p><strong>注意:</strong>平安车险客户可能秒批(预投信),无需审批</p><p><strong>POS贷</strong></p><p>额度2-50w,按流水给额度</p><p><strong>准入条件</strong></p><ol><li>pos机商户的法定代表人</li><li>中国国籍25-55周岁</li></ol><p>3营业执照有效且满1年</p><p>4安装POS机6个月以上</p><ol><li>六个月月均流水2万（六个月大于12万近一个月不能为零）</li></ol><p><strong>申请材料:</strong>身份证,营业执照,刷卡机,银行卡</p><p><strong>签约资料:</strong></p><p>1.身份证.</p><p>2银行卡</p><p><strong>薪金贷</strong></p><p>额度2-30万</p><p>&nbsp;</p><p><strong>准入条件</strong></p><p><strong>上班族：</strong></p><p>1.北京工作6个月</p><p>2工资打卡3000,有社保或公积金</p><p>3征信良好</p><p>4额度:2-30万</p><p><strong>法人：</strong>1.营业执照满一年</p><p>2有对公账户,半年的银行流水≥18W</p><p>3.有实际办公地址</p><p>4.征信良好</p><p><strong>申请资料:</strong></p><p>上班族：身份证、半年的银行流水、社保卡、工作证明</p><p>法人:身份证、半年的对公+对私银行流水、营业执照、办公场地租赁合同</p><p><strong>签约材料：</strong></p><p>申请材料+银行卡</p><p>&nbsp;</p><p>&nbsp;</p><p><strong>宅e经营贷</strong></p><p>光大银行版（华夏银行版）</p><p>准入条件：</p><p>借款人要求：个体工商户经营者/企业法定代表人/企业股东/企业实际控制人【出资方，但未持有股份】</p><p>年龄：借款人：25-55周岁</p><p>共有人：18-60周岁</p><p>借款人必须是产权人之一</p><p>征信白户只接受30-50周岁</p><p>房产性质：商品房，成本价房，央产房，酒店式公寓，经过上市交易的经济适用房</p><p>单套房上限500万，一个家庭可做3套房产，最高1500万。</p><p>利息：一抵0.94二抵（一抵正常按揭在银行）1.05</p><p><strong>优势</strong>&nbsp;：1.可以循环利用，类似于一张信用卡，可以多次使用，用有利息，不用不产生利息，适合做生意的短期周转2.不压房本（在建委盖已上抵的章）3.不下户4.不公证5,没有任何前置费用</p><p><strong>签约材料：</strong></p><p>个人材料：夫妻双方身份证，户口本，房本，结婚证，银行卡【二抵的需要提供一抵的借款合同，抵押物清单，还款对账单】</p><p>公司材料：1.营业执照复印件&nbsp;2.经营资格证明，需借款人签字＋公章【当借款人为企业股东或企业实际控制人时需提供公司信息与营业执照相符】</p><p>收入材料：1.收入证明原件&nbsp;2.最近3个月银行流水【公司和个人均可】</p><p>经营性用途材料：购销合同复印件[包含标的金额，付款日期，签署日期，交易对手信息，标的需符合营业执照经营范围，交易对手限定个体商户或企业，付款日期，合同签署日期需合理]</p><p><strong>征信要求：没有当前逾期，坏账，呆账，最近三个月查询不能超过8次！</strong></p>', '0.0', '0.0', '0', null, '0.0', '0.0', '0.0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0', '', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `page` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15', '2020-05-31 03:23:24.217000', null, null, null, '王者归来', '1', 'admin', '0', '0');
INSERT INTO `user` VALUES ('16', '2020-05-31 14:06:27.165000', null, null, null, '王者归来', '1', '张三', '0', '0');
INSERT INTO `user` VALUES ('19', '2020-06-01 07:34:46.936000', null, null, null, '', '', '', '0', '0');
INSERT INTO `user` VALUES ('20', '2020-06-01 08:14:17.837000', null, null, null, '', '', '', '0', '0');
INSERT INTO `user` VALUES ('21', '2020-06-01 08:15:10.444000', null, null, null, '', '', '', '0', '0');
INSERT INTO `user` VALUES ('22', '2020-06-01 08:19:20.413000', null, null, null, '', 'b', 'a', '0', '0');
INSERT INTO `user` VALUES ('23', '2020-06-01 08:28:23.570000', null, null, null, '', '1', '1', '0', '0');
INSERT INTO `user` VALUES ('24', '2020-06-01 08:29:51.579000', null, null, null, '', '1', '', '0', '0');
INSERT INTO `user` VALUES ('25', '2020-06-01 08:30:24.068000', null, null, null, '', '1', '', '0', '0');
INSERT INTO `user` VALUES ('26', '2020-06-01 08:36:08.969000', null, null, null, '', '1', '', '0', '0');
INSERT INTO `user` VALUES ('27', '2020-06-01 08:50:37.658000', null, null, null, '', '1', '', '0', '0');
INSERT INTO `user` VALUES ('28', '2020-06-01 08:53:26.525000', null, null, null, '', '1', 'a', '0', '0');
INSERT INTO `user` VALUES ('29', '2020-06-01 09:16:53.711000', null, null, null, '', '1', 'a', '0', '0');
