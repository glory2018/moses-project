/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : moses

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-06-22 11:32:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('149');
INSERT INTO `hibernate_sequence` VALUES ('149');
INSERT INTO `hibernate_sequence` VALUES ('149');
INSERT INTO `hibernate_sequence` VALUES ('149');

-- ----------------------------
-- Table structure for instrument
-- ----------------------------
DROP TABLE IF EXISTS `instrument`;
CREATE TABLE `instrument` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `instrument_admin` varchar(255) DEFAULT NULL,
  `instrument_code` varchar(9) DEFAULT NULL,
  `instrument_name` varchar(255) NOT NULL,
  `laboratory_code` varchar(255) DEFAULT NULL,
  `purchase_date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t4ovmrpftp7q5n1a78e5rtdhp` (`instrument_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of instrument
-- ----------------------------
INSERT INTO `instrument` VALUES ('1', null, null, null, null, null, 'A19000061', '高速视觉采集系统', '031005', '20191115');
INSERT INTO `instrument` VALUES ('2', null, null, null, null, null, 'A19000062', '精密测量系统', '031005', '20181219');
INSERT INTO `instrument` VALUES ('3', null, null, null, null, null, 'A19000063', '纳米粒度仪', '402001', '20160325');
INSERT INTO `instrument` VALUES ('4', null, null, null, null, null, 'A19000064', '大型计算系统', '043012', '20180326');
INSERT INTO `instrument` VALUES ('5', null, null, null, null, null, 'A19000065', '高压液相色谱仪', '402001', '20160330');
INSERT INTO `instrument` VALUES ('6', null, null, null, null, null, 'A19000066', '激光共聚焦高内涵成像西酮', '402002', '20160106');
INSERT INTO `instrument` VALUES ('7', null, null, null, null, null, 'A19000067', '高速红外跟踪系统 ', '004001', '20151216');
INSERT INTO `instrument` VALUES ('8', null, null, null, null, null, 'A19000068', '超分辨液质联用仪HF-X', '500002', '20171228');
INSERT INTO `instrument` VALUES ('9', null, null, null, null, null, 'A19000069', '高速视觉采集处理系统', '031005', '20191115');
INSERT INTO `instrument` VALUES ('10', null, null, null, null, null, 'A19000070', '偏光显微镜', '402001', '20160330');
INSERT INTO `instrument` VALUES ('11', null, null, null, null, null, 'A19000071', '高速红外跟踪系统 ', '004001', '20151216');
INSERT INTO `instrument` VALUES ('12', null, null, null, null, null, 'A19000072', '高速红外跟踪系统 ', '004001', '20151216');
INSERT INTO `instrument` VALUES ('13', null, null, null, null, null, 'A19000073', '高速红外跟踪系统 ', '004001', '20151216');
INSERT INTO `instrument` VALUES ('14', null, null, null, null, null, 'A19000074', '高速红外跟踪系统 ', '004001', '20151216');
INSERT INTO `instrument` VALUES ('15', null, null, null, null, null, 'A19000075', '核磁共振仪', '402002', '20110315');
INSERT INTO `instrument` VALUES ('16', null, null, null, null, null, 'A19000076', 'Zeiss高分辨场发射扫描电镜（附有能谱仪）', '012024', '20190404');
INSERT INTO `instrument` VALUES ('17', null, null, null, null, null, 'A19000077', '400兆核磁共振谱仪', '402002', '20130515');
INSERT INTO `instrument` VALUES ('18', null, null, null, null, null, 'A19000078', '高速视觉采集处理系统', '031005', '20191115');
INSERT INTO `instrument` VALUES ('19', null, null, null, null, null, 'A19000079', '高速视觉采集处理系统', '031005', '20191115');
INSERT INTO `instrument` VALUES ('20', null, null, null, null, null, 'A19000080', '冷冻干燥机', '402001', '20160330');
INSERT INTO `instrument` VALUES ('21', null, null, null, null, null, 'A19000081', '动态水蒸气吸附仪', '402001', '20160330');
INSERT INTO `instrument` VALUES ('22', null, null, null, null, null, 'A19000082', '离子色谱', '402002', '20180227');
INSERT INTO `instrument` VALUES ('23', null, null, null, null, null, 'A19000083', '离子色谱', '402002', '20180227');
INSERT INTO `instrument` VALUES ('24', null, null, null, null, null, 'A19000084', 'EchoMRI清醒动物身体成分分析仪', '500003', '20190426');
INSERT INTO `instrument` VALUES ('25', null, null, null, null, null, 'A19000085', '纳米粒度及ZETA电位分析仪', '402003', '20160727');
INSERT INTO `instrument` VALUES ('26', null, null, null, null, null, 'A19000086', '计算服务器', '916004', '20171206');
INSERT INTO `instrument` VALUES ('27', null, null, null, null, null, 'A19000087', '精密测量系统', '031005', '20181219');

-- ----------------------------
-- Table structure for instrument_photos
-- ----------------------------
DROP TABLE IF EXISTS `instrument_photos`;
CREATE TABLE `instrument_photos` (
  `instrument_id` bigint(20) NOT NULL,
  `photos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`instrument_id`,`photos_id`),
  UNIQUE KEY `UK_8jmibq4177aubhxiqv0blqevq` (`photos_id`),
  CONSTRAINT `FK7ptfeab40qp23s2fvtlu7aukh` FOREIGN KEY (`photos_id`) REFERENCES `photo` (`id`),
  CONSTRAINT `FKfmqscr3kp4bgl3ripuv15q4ym` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of instrument_photos
-- ----------------------------

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `laboratory_code` varchar(255) DEFAULT NULL,
  `laboratory_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t33f1po5v87t4bkkx1bnixukt` (`laboratory_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('28', null, null, null, null, '031005', '跨介质实验中心');
INSERT INTO `laboratory` VALUES ('29', null, null, null, null, '402001', '先进药剂学中心');
INSERT INTO `laboratory` VALUES ('30', null, null, null, null, '043012', '计算物理实验室');
INSERT INTO `laboratory` VALUES ('31', null, null, null, null, '402002', '药学技术中心');
INSERT INTO `laboratory` VALUES ('32', null, null, null, null, '004001', '水工实验室');
INSERT INTO `laboratory` VALUES ('33', null, null, null, null, '500002', '生物医学测试中心');
INSERT INTO `laboratory` VALUES ('34', null, null, null, null, '012024', '电镜实验室');
INSERT INTO `laboratory` VALUES ('35', null, null, null, null, '500003', '实验动物中心');
INSERT INTO `laboratory` VALUES ('36', null, null, null, null, '402003', '药学实验教学中心');
INSERT INTO `laboratory` VALUES ('37', null, null, null, null, '916004', '生物信息学开放实验室');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `modify_user_id` varchar(255) DEFAULT NULL,
  `photo_code` varchar(255) DEFAULT NULL,
  `photo_name` varchar(255) DEFAULT NULL,
  `photo_path` varchar(255) DEFAULT NULL,
  `instrument_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjisd7p31h10qx4cbo9x34d486` (`instrument_id`),
  CONSTRAINT `FKjisd7p31h10qx4cbo9x34d486` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of photo
-- ----------------------------

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
  `password` varchar(255) DEFAULT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('38', null, null, null, null, null, '680059', '马颖华');
INSERT INTO `user` VALUES ('39', null, null, null, null, null, '670033', '牛卫星');
INSERT INTO `user` VALUES ('40', null, null, null, null, null, '680104', '牛文鹏');
INSERT INTO `user` VALUES ('41', null, null, null, null, null, '980005', '牛晓伟');
INSERT INTO `user` VALUES ('42', null, null, null, null, null, '680013', '倪峰');
INSERT INTO `user` VALUES ('43', null, null, null, null, null, '330236', '倪建尉');
INSERT INTO `user` VALUES ('44', null, null, null, null, null, '330069', '倪林红');
INSERT INTO `user` VALUES ('45', null, null, null, null, null, '330326', '倪庆雷');
INSERT INTO `user` VALUES ('46', null, null, null, null, null, '980016', '倪蕊');
INSERT INTO `user` VALUES ('47', null, null, null, null, null, '680016', '倪书乐');
INSERT INTO `user` VALUES ('48', null, null, null, null, null, '330177', '郝明彬');
INSERT INTO `user` VALUES ('49', null, null, null, null, null, '330027', '郝卫明');
INSERT INTO `user` VALUES ('50', null, null, null, null, null, '980022', '方放');
INSERT INTO `user` VALUES ('51', null, null, null, null, null, '680036', '王大广');
INSERT INTO `user` VALUES ('52', null, null, null, null, null, '680103', '王凡');
INSERT INTO `user` VALUES ('53', null, null, null, null, null, '330392', '王福');
INSERT INTO `user` VALUES ('54', null, null, null, null, null, '680068', '王福冰');
INSERT INTO `user` VALUES ('55', null, null, null, null, null, '330365', '王宏伟');
INSERT INTO `user` VALUES ('56', null, null, null, null, null, '330038', '王厚文');
INSERT INTO `user` VALUES ('57', null, null, null, null, null, '680022', '王健生');
INSERT INTO `user` VALUES ('58', null, null, null, null, null, '330045', '王俊');
INSERT INTO `user` VALUES ('59', null, null, null, null, null, '680081', '王来');
INSERT INTO `user` VALUES ('60', null, null, null, null, null, '680002', '王明');
INSERT INTO `user` VALUES ('61', null, null, null, null, null, '330396', '王清华');
INSERT INTO `user` VALUES ('62', null, null, null, null, null, '330382', '王瑞');
INSERT INTO `user` VALUES ('63', null, null, null, null, null, '330032', '王文');
INSERT INTO `user` VALUES ('64', null, null, null, null, null, '330263', '王许亚');
INSERT INTO `user` VALUES ('65', null, null, null, null, null, '330362', '王亚英');
INSERT INTO `user` VALUES ('66', null, null, null, null, null, '330085', '王衍泰');
INSERT INTO `user` VALUES ('67', null, null, null, null, null, '330033', '王彦');
INSERT INTO `user` VALUES ('68', null, null, null, null, null, '680088', '王彦姝');
INSERT INTO `user` VALUES ('69', null, null, null, null, null, '330068', '王吟颖');
INSERT INTO `user` VALUES ('70', null, null, null, null, null, '670018', '王英存');
INSERT INTO `user` VALUES ('71', null, null, null, null, null, '940106', '王莹');
INSERT INTO `user` VALUES ('72', null, null, null, null, null, '330287', '王颖飞');
INSERT INTO `user` VALUES ('73', null, null, null, null, null, '330080', '王勇');
INSERT INTO `user` VALUES ('74', null, null, null, null, null, '330359', '王占锋');
INSERT INTO `user` VALUES ('75', null, null, null, null, null, '330006', '王志鹏');
INSERT INTO `user` VALUES ('76', null, null, null, null, null, '680031', '王酌');
INSERT INTO `user` VALUES ('77', null, null, null, null, null, '330314', '王子辉');
INSERT INTO `user` VALUES ('78', null, null, null, null, null, '330040', '牛华春');
INSERT INTO `user` VALUES ('79', null, null, null, null, null, '330331', '牛树锋');
INSERT INTO `user` VALUES ('80', null, null, null, null, null, '330240', '牛欣');
INSERT INTO `user` VALUES ('81', null, null, null, null, null, '330346', '赵建军');
INSERT INTO `user` VALUES ('82', null, null, null, null, null, '670009', '赵建娜');
INSERT INTO `user` VALUES ('83', null, null, null, null, null, '330233', '赵剑');
INSERT INTO `user` VALUES ('84', null, null, null, null, null, '330289', '赵蕉');
INSERT INTO `user` VALUES ('85', null, null, null, null, null, '330384', '赵晶');
INSERT INTO `user` VALUES ('86', null, null, null, null, null, '330229', '赵军');
INSERT INTO `user` VALUES ('87', null, null, null, null, null, '330281', '赵军');
INSERT INTO `user` VALUES ('88', null, null, null, null, null, '680073', '赵亮');
INSERT INTO `user` VALUES ('89', null, null, null, null, null, '680018', '赵亮亮');
INSERT INTO `user` VALUES ('90', null, null, null, null, null, '330070', '赵龙');
INSERT INTO `user` VALUES ('91', null, null, null, null, null, '330369', '赵陆军');
INSERT INTO `user` VALUES ('92', null, null, null, null, null, '680047', '赵路珂');
INSERT INTO `user` VALUES ('93', null, null, null, null, null, '330189', '赵梅');
INSERT INTO `user` VALUES ('94', null, null, null, null, null, '330132', '赵敏');
INSERT INTO `user` VALUES ('95', null, null, null, null, null, '330329', '赵派');
INSERT INTO `user` VALUES ('96', null, null, null, null, null, '980009', '赵鹏');
INSERT INTO `user` VALUES ('97', null, null, null, null, null, '330151', '赵琪');
INSERT INTO `user` VALUES ('98', null, null, null, null, null, '680091', '赵少伟');
INSERT INTO `user` VALUES ('99', null, null, null, null, null, '330367', '赵少霞');
INSERT INTO `user` VALUES ('100', null, null, null, null, null, '330372', '赵胜琴');
INSERT INTO `user` VALUES ('101', null, null, null, null, null, '680061', '赵树华');
INSERT INTO `user` VALUES ('102', null, null, null, null, null, '680095', '赵天津');
INSERT INTO `user` VALUES ('103', null, null, null, null, null, '680041', '赵铁夫');
INSERT INTO `user` VALUES ('104', null, null, null, null, null, '330293', '赵巍');
INSERT INTO `user` VALUES ('105', null, null, null, null, null, '330360', '赵伟');
INSERT INTO `user` VALUES ('106', null, null, null, null, null, '330345', '赵西文');
INSERT INTO `user` VALUES ('107', null, null, null, null, null, '951368', '赵小梅');
INSERT INTO `user` VALUES ('108', null, null, null, null, null, '670041', '赵晓帆');
INSERT INTO `user` VALUES ('109', null, null, null, null, null, '330093', '赵晓刚');
INSERT INTO `user` VALUES ('110', null, null, null, null, null, '330009', '赵晓芸');
INSERT INTO `user` VALUES ('111', null, null, null, null, null, '330224', '赵晔');
INSERT INTO `user` VALUES ('112', null, null, null, null, null, '330337', '赵英武');
INSERT INTO `user` VALUES ('113', null, null, null, null, null, '330060', '赵永健');
INSERT INTO `user` VALUES ('114', null, null, null, null, null, '330036', '赵永哲');
INSERT INTO `user` VALUES ('115', null, null, null, null, null, '330051', '赵再兴');
INSERT INTO `user` VALUES ('116', null, null, null, null, null, '330237', '赵哲');
INSERT INTO `user` VALUES ('117', null, null, null, null, null, '330087', '赵争学');
INSERT INTO `user` VALUES ('118', null, null, null, null, null, '330104', '赵志生');
INSERT INTO `user` VALUES ('119', null, null, null, null, null, '330122', '赵卓远');
INSERT INTO `user` VALUES ('120', null, null, null, null, null, '330049', '钱博');
INSERT INTO `user` VALUES ('121', null, null, null, null, null, '680004', '钱超');
INSERT INTO `user` VALUES ('122', null, null, null, null, null, '330370', '钱弛');
INSERT INTO `user` VALUES ('123', null, null, null, null, null, '680116', '钱传杰');
INSERT INTO `user` VALUES ('124', null, null, null, null, null, '330178', '钱菲');
INSERT INTO `user` VALUES ('125', null, null, null, null, null, '951389', '钱改改');
INSERT INTO `user` VALUES ('126', null, null, null, null, null, '330247', '钱鹤丰');
INSERT INTO `user` VALUES ('127', null, null, null, null, null, '680025', '钱弘');
INSERT INTO `user` VALUES ('128', null, null, null, null, null, '330157', '钱洪玉');
INSERT INTO `user` VALUES ('129', null, null, null, null, null, '330286', '钱洪云');
INSERT INTO `user` VALUES ('130', null, null, null, null, null, '330325', '钱辉');
INSERT INTO `user` VALUES ('131', null, null, null, null, null, '330170', '钱建富');
INSERT INTO `user` VALUES ('132', null, null, null, null, null, '670046', '钱洁');
INSERT INTO `user` VALUES ('133', null, null, null, null, null, '330017', '钱金宝');
INSERT INTO `user` VALUES ('134', null, null, null, null, null, '980004', '钱静');
INSERT INTO `user` VALUES ('135', null, null, null, null, null, '330142', '周文锋');
INSERT INTO `user` VALUES ('136', null, null, null, null, null, '670019', '周文棠');
INSERT INTO `user` VALUES ('137', null, null, null, null, null, '670047', '周艳红');
INSERT INTO `user` VALUES ('138', null, null, null, null, null, '680058', '周振清');
INSERT INTO `user` VALUES ('139', null, null, null, null, null, '330261', '周忠海');
INSERT INTO `user` VALUES ('140', null, null, null, null, null, '330368', '武爱斌');
INSERT INTO `user` VALUES ('141', null, null, null, null, null, '670024', '武大为');
INSERT INTO `user` VALUES ('142', null, null, null, null, null, '330318', '武鸿军');
INSERT INTO `user` VALUES ('143', null, null, null, null, null, '330001', '武锦文');
INSERT INTO `user` VALUES ('144', null, null, null, null, null, '330048', '武莉');
INSERT INTO `user` VALUES ('145', null, null, null, null, null, '670040', '武萍玉');
INSERT INTO `user` VALUES ('146', null, null, null, null, null, '330042', '武新现');
INSERT INTO `user` VALUES ('147', null, null, null, null, null, '330043', '武怡芳');
INSERT INTO `user` VALUES ('148', null, null, null, null, null, '330101', '武战强');
