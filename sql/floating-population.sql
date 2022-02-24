/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 8.141.48.181:3306
 Source Schema         : floating-population

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 24/02/2022 21:35:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fp_birth
-- ----------------------------
DROP TABLE IF EXISTS `fp_birth`;
CREATE TABLE `fp_birth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `id_card` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `gender` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `school` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '在读学校',
  `father_id` int(11) DEFAULT NULL COMMENT '父亲角色id',
  `mother_id` int(11) DEFAULT NULL COMMENT '母亲角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_birth
-- ----------------------------
BEGIN;
INSERT INTO `fp_birth` VALUES (1, '小明', '3242342343324', 12, '男', '翻斗幼儿园', 21, 22);
INSERT INTO `fp_birth` VALUES (2, '小明', '3242342343324', 13, '男', '翻斗幼儿园', 22, 23);
INSERT INTO `fp_birth` VALUES (3, '小明', '3242342343324', 14, '男', '翻斗幼儿园', 23, 24);
INSERT INTO `fp_birth` VALUES (4, '小明', '3242342343324', 15, '男', '翻斗幼儿园', 24, 25);
INSERT INTO `fp_birth` VALUES (5, '小明', '3242342343324', 16, '男', '翻斗幼儿园', 25, 26);
INSERT INTO `fp_birth` VALUES (6, '小明', '3242342343324', 17, '男', '翻斗幼儿园', 26, 27);
INSERT INTO `fp_birth` VALUES (7, '小明', '3242342343324', 18, '男', '翻斗幼儿园', 27, 28);
INSERT INTO `fp_birth` VALUES (8, '小明', '3242342343324', 19, '男', '翻斗幼儿园', 28, 29);
INSERT INTO `fp_birth` VALUES (9, '小明', '3242342343324', 20, '男', '翻斗幼儿园', 29, 30);
INSERT INTO `fp_birth` VALUES (10, '小明', '3242342343324', 21, '男', '翻斗幼儿园', 30, 31);
INSERT INTO `fp_birth` VALUES (11, '小明', '3242342343324', 22, '男', '翻斗幼儿园', 31, 32);
INSERT INTO `fp_birth` VALUES (12, '小红', '4234232344443', 12, '3', '温热额外情人', 32, 23);
COMMIT;

-- ----------------------------
-- Table structure for fp_illegal
-- ----------------------------
DROP TABLE IF EXISTS `fp_illegal`;
CREATE TABLE `fp_illegal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号',
  `punishment_auhority` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '处罚机关',
  `illegal_time` timestamp NULL DEFAULT NULL COMMENT '违法时间',
  `illegal_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '违法地点',
  `illegal_activities` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '违法行为',
  `illegal_person` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '违法人员',
  `illegal_id_card` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '违法人员身份证号',
  `forfeit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '罚款金额',
  `other_measures` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '其他措施',
  `penalty_time` timestamp NULL DEFAULT NULL COMMENT '处罚时间',
  `is_accepted` tinyint(1) DEFAULT NULL COMMENT '是否受理',
  `receiver` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '受理人',
  `acceptance_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '受理时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_illegal
-- ----------------------------
BEGIN;
INSERT INTO `fp_illegal` VALUES (1, '10001', '西城区交警大队', '2022-02-22 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '200', '无', '2021-02-21 00:00:00', 0, '管理员', '2022-02-22 16:55:05');
INSERT INTO `fp_illegal` VALUES (2, '10002', '西城区交警大队', '2022-02-23 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '201', '无', '2021-02-22 00:00:00', 0, '管理员', '2022-02-23 16:55:05');
INSERT INTO `fp_illegal` VALUES (3, '10003', '西城区交警大队', '2022-02-24 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '202', '无', '2021-03-23 00:00:00', 0, '管理员', '2022-02-24 16:55:05');
INSERT INTO `fp_illegal` VALUES (4, '10004', '西城区交警大队', '2022-02-25 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '203', '无', '2021-02-24 00:00:00', 0, '管理员', '2022-02-25 16:55:05');
INSERT INTO `fp_illegal` VALUES (5, '10005', '西城区交警大队', '2022-02-26 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '204', '无', '2021-02-25 00:00:00', 0, '管理员', '2022-02-26 16:55:05');
INSERT INTO `fp_illegal` VALUES (6, '10006', '西城区交警大队', '2022-02-27 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '205', '无', '2021-03-26 00:00:00', 0, '管理员', '2022-02-27 16:55:05');
INSERT INTO `fp_illegal` VALUES (7, '10007', '西城区交警大队', '2022-02-28 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '206', '无', '2021-04-27 00:00:00', 0, '管理员', '2022-02-28 16:55:05');
INSERT INTO `fp_illegal` VALUES (8, '10008', '西城区交警大队', '2022-03-01 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '207', '无', '2021-04-28 00:00:00', 0, '管理员', '2022-03-01 16:55:05');
INSERT INTO `fp_illegal` VALUES (9, '10009', '西城区交警大队', '2022-03-02 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '208', '无', '2021-05-01 00:00:00', 0, '管理员', '2022-03-02 16:55:05');
INSERT INTO `fp_illegal` VALUES (10, '10010', '西城区交警大队', '2022-03-03 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '209', '无', '2021-06-02 00:00:00', 0, '管理员', '2022-03-03 16:55:05');
INSERT INTO `fp_illegal` VALUES (11, '10011', '西城区交警大队', '2022-03-04 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '210', '无', '2021-07-03 00:00:00', 0, '管理员', '2022-03-04 16:55:05');
INSERT INTO `fp_illegal` VALUES (12, '10012', '西城区交警大队', '2022-03-05 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '211', '无', '2021-08-04 00:00:00', 0, '管理员', '2022-03-05 16:55:05');
INSERT INTO `fp_illegal` VALUES (13, '10013', '西城区交警大队', '2022-03-06 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '212', '无', '2021-08-05 00:00:00', 0, '管理员', '2022-03-06 16:55:05');
INSERT INTO `fp_illegal` VALUES (14, '10014', '西城区交警大队', '2022-03-07 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '213', '无', '2021-09-06 00:00:00', 0, '管理员', '2022-03-07 16:55:05');
INSERT INTO `fp_illegal` VALUES (15, '10015', '西城区交警大队', '2022-03-08 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '214', '无', '2021-10-07 00:00:00', 0, '管理员', '2022-03-08 16:55:05');
INSERT INTO `fp_illegal` VALUES (16, '10016', '西城区交警大队', '2022-03-09 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '215', '无', '2021-11-08 00:00:00', 0, '管理员', '2022-03-09 16:55:05');
INSERT INTO `fp_illegal` VALUES (17, '10017', '西城区交警大队', '2022-03-10 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '216', '无', '2021-12-09 00:00:00', 1, '管理员', '2022-03-10 16:55:05');
INSERT INTO `fp_illegal` VALUES (19, '10018', '西城区交警大队', '2022-03-12 00:00:00', '菜市场', '违规停车', '张三', '2222222222222', '218', '无', '2021-12-10 00:00:00', 1, '管理员', '2022-03-12 16:55:05');
COMMIT;

-- ----------------------------
-- Table structure for fp_info
-- ----------------------------
DROP TABLE IF EXISTS `fp_info`;
CREATE TABLE `fp_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `infoname` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `gender` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '民族',
  `id_card` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `political_outlook` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '政治面貌',
  `marital` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '婚姻状况',
  `current_sidence` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '现居地',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `is_senior_technician` tinyint(1) DEFAULT '0' COMMENT '是否为高级技术人才',
  `is_disability` tinyint(1) DEFAULT '0' COMMENT '是否残疾',
  `is_soldier` tinyint(1) DEFAULT '0' COMMENT '是否军人',
  `is_foreigner` tinyint(1) DEFAULT '0' COMMENT '是否外国人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_info
-- ----------------------------
BEGIN;
INSERT INTO `fp_info` VALUES (1, '顾行', 22, '男', '汉族', '110101192002216398', '群众', '未婚', '湖塘边', '1345678910', 1, 0, 1, 1);
INSERT INTO `fp_info` VALUES (2, '嘉浩', 55, '男', '汉族', '110101192002217278', '中国共产主义青年团团员', '未婚', '湖塘边02', '15649436801', 0, 1, 0, 0);
INSERT INTO `fp_info` VALUES (3, '柏永思', 18, '男', '汉族', '110101192002216814', '群众', '未婚', '湖塘边03', '13641237042', 0, 0, 0, 0);
INSERT INTO `fp_info` VALUES (4, '隆毅君', 55, '男', '汉族', '110101192002219070', '中国共产主义青年团团员', '未婚', '湖塘边04', '13817771799', 0, 0, 1, 0);
INSERT INTO `fp_info` VALUES (5, '茆畅', 20, '男', '汉族', '11010119200221961X', '群众', '未婚', '湖塘边05', '15192146442', 0, 0, 0, 1);
INSERT INTO `fp_info` VALUES (6, '旁梦菡', 21, '男', '汉族', '110101192002217294', '中国共产主义青年团团员', '已婚', '湖塘边06', '13078151407', 0, 1, 0, 0);
INSERT INTO `fp_info` VALUES (7, '但蕙', 22, '男', '汉族', '110101192002218879', '中国共产主义青年团团员', '未婚', '湖塘边07', '15571161912', 0, 0, 0, 0);
INSERT INTO `fp_info` VALUES (8, '贾濯', 23, '男', '汉族', '110101192002219855', '中国共产主义青年团团员', '未婚', '湖塘边08', '13876705612', 1, 0, 0, 1);
INSERT INTO `fp_info` VALUES (9, '鄢思凡', 24, '男', '汉族', '110101192002219556', '中国共产党党员', '未婚', '湖塘边09', '18929964831', 0, 0, 0, 0);
INSERT INTO `fp_info` VALUES (10, '衅海荣', 25, '男', '汉族', '110101192002218959', '中国共产党党员', '已婚', '湖塘边10', '18956856107', 1, 0, 1, 0);
INSERT INTO `fp_info` VALUES (12, '饶采萱', 27, '女', '汉族', '110101192002216670', '中国共产党党员', '已婚', '湖塘边12', '15647778592', 0, 0, 0, 0);
INSERT INTO `fp_info` VALUES (13, '诗墨', 28, '女', '汉族', '110101192002219353', '中国共产主义青年团团员', '未婚', '湖塘边13', '13008200989', 0, 1, 0, 0);
INSERT INTO `fp_info` VALUES (16, '莫正志', 45, '女', '汉族', '110101192002219134', '中国共产主义青年团团员', '未婚', '湖塘边16', '15337052526', 1, 0, 0, 0);
INSERT INTO `fp_info` VALUES (17, '魏雁菡', 32, '男', '汉族', '110101192002217972', '中国共产主义青年团团员', '丧偶', '湖塘边17', '13692553902', 0, 1, 1, 0);
INSERT INTO `fp_info` VALUES (18, '淦昆皓', 33, '男', '汉族', '110101192002218190', '中国共产主义青年团团员', '未婚', '湖塘边18', '15652921395', 1, 1, 0, 1);
INSERT INTO `fp_info` VALUES (19, '习和裕', 34, '男', '汉族', '110101192002218852', '群众', '丧偶', '湖塘边19', '13227313833', 0, 0, 1, 0);
INSERT INTO `fp_info` VALUES (20, '甲芸儿', 54, '女', '汉族', '110101192002217614', '群众', '未婚', '湖塘边20', '13779211887', 1, 0, 0, 0);
INSERT INTO `fp_info` VALUES (21, '通思懿', 36, '女', '汉族', '110101192002217390', '群众', '未婚', '湖塘边21', '15942022439', 0, 0, 0, 1);
INSERT INTO `fp_info` VALUES (22, '子车灵阳', 70, '男', '汉族', '110101192002218414', '群众', '未婚', '湖塘边22', '15338763111', 1, 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for fp_residence
-- ----------------------------
DROP TABLE IF EXISTS `fp_residence`;
CREATE TABLE `fp_residence` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `gender` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `id_card` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `occupation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '从业学位及职业',
  `work` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原工作单位',
  `landlord` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '暂住地址',
  `time_start` timestamp NULL DEFAULT NULL COMMENT '有效日期开始',
  `time_end` timestamp NULL DEFAULT NULL COMMENT '有效日期结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_residence
-- ----------------------------
BEGIN;
INSERT INTO `fp_residence` VALUES (1, '小明', '男', '32452345', '高级电工', '土木公司', '张三', '桥底下', '2022-03-23 00:00:00', '2022-09-23 00:00:00');
INSERT INTO `fp_residence` VALUES (2, '小明', '男', '32452346', '高级电工', '土木公司', '张三', '桥底下', '2022-03-24 00:00:00', '2022-09-24 00:00:00');
INSERT INTO `fp_residence` VALUES (3, '小明', '男', '32452347', '高级电工', '土木公司', '张三', '桥底下', '2022-03-25 00:00:00', '2022-09-25 00:00:00');
INSERT INTO `fp_residence` VALUES (4, '小明', '男', '32452348', '高级电工', '土木公司', '张三', '桥底下', '2022-03-26 00:00:00', '2022-09-26 00:00:00');
INSERT INTO `fp_residence` VALUES (5, '小明', '男', '32452349', '高级电工', '土木公司', '张三', '桥底下', '2022-03-27 00:00:00', '2022-09-27 00:00:00');
INSERT INTO `fp_residence` VALUES (6, '小明', '男', '32452350', '高级电工', '土木公司', '张三', '桥底下', '2022-03-28 00:00:00', '2022-09-28 00:00:00');
INSERT INTO `fp_residence` VALUES (7, '小明', '男', '32452351', '高级电工', '土木公司', '张三', '桥底下', '2022-03-29 00:00:00', '2022-09-29 00:00:00');
INSERT INTO `fp_residence` VALUES (8, '小明', '男', '32452352', '高级电工', '土木公司', '张三', '桥底下', '2022-03-30 00:00:00', '2022-09-30 00:00:00');
INSERT INTO `fp_residence` VALUES (9, '小明', '男', '32452353', '高级电工', '土木公司', '张三', '桥底下', '2022-03-31 00:00:00', '2022-10-01 00:00:00');
INSERT INTO `fp_residence` VALUES (10, '小明', '男', '32452354', '高级电工', '土木公司', '张三', '桥底下', '2022-04-01 00:00:00', '2022-10-02 00:00:00');
INSERT INTO `fp_residence` VALUES (11, '小明', '男', '32452355', '高级电工', '土木公司', '张三', '桥底下', '2022-04-02 00:00:00', '2022-10-03 00:00:00');
INSERT INTO `fp_residence` VALUES (12, '小明', '男', '32452356', '高级电工', '土木公司', '张三', '桥底下', '2022-04-03 00:00:00', '2022-10-04 00:00:00');
INSERT INTO `fp_residence` VALUES (13, '小明', '男', '32452357', '高级电工', '土木公司', '张三', '桥底下', '2022-04-04 00:00:00', '2022-10-05 00:00:00');
INSERT INTO `fp_residence` VALUES (14, '小明', '男', '32452358', '高级电工', '土木公司', '张三', '桥底下', '2022-04-05 00:00:00', '2022-10-06 00:00:00');
INSERT INTO `fp_residence` VALUES (15, '小明', '男', '32452359', '高级电工', '土木公司', '张三', '桥底下', '2022-04-06 00:00:00', '2022-10-07 00:00:00');
INSERT INTO `fp_residence` VALUES (16, '小明', '男', '32452360', '高级电工', '土木公司', '张三', '桥底下', '2022-04-07 00:00:00', '2022-10-08 00:00:00');
INSERT INTO `fp_residence` VALUES (17, '小明', '男', '32452361', '高级电工', '土木公司', '张三', '桥底下', '2022-04-08 00:00:00', '2022-10-09 00:00:00');
INSERT INTO `fp_residence` VALUES (18, '小明', '男', '32452362', '高级电工', '土木公司', '张三', '桥底下', '2022-04-09 00:00:00', '2022-10-10 00:00:00');
INSERT INTO `fp_residence` VALUES (19, '小明', '男', '32452363', '高级电工', '水泥公司', '张三', '水池', '2022-04-10 00:00:00', '2022-10-11 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for fp_user_birth
-- ----------------------------
DROP TABLE IF EXISTS `fp_user_birth`;
CREATE TABLE `fp_user_birth` (
  `id_user` int(8) NOT NULL,
  `id_birth` int(8) NOT NULL,
  PRIMARY KEY (`id_user`,`id_birth`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_user_birth
-- ----------------------------
BEGIN;
INSERT INTO `fp_user_birth` VALUES (17, 10);
COMMIT;

-- ----------------------------
-- Table structure for fp_user_illegal
-- ----------------------------
DROP TABLE IF EXISTS `fp_user_illegal`;
CREATE TABLE `fp_user_illegal` (
  `id_user` int(8) NOT NULL,
  `id_illegal` int(8) NOT NULL,
  PRIMARY KEY (`id_user`,`id_illegal`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_user_illegal
-- ----------------------------
BEGIN;
INSERT INTO `fp_user_illegal` VALUES (17, 10);
INSERT INTO `fp_user_illegal` VALUES (17, 11);
INSERT INTO `fp_user_illegal` VALUES (17, 12);
COMMIT;

-- ----------------------------
-- Table structure for fp_user_info
-- ----------------------------
DROP TABLE IF EXISTS `fp_user_info`;
CREATE TABLE `fp_user_info` (
  `id_user` int(8) NOT NULL,
  `id_info` int(8) NOT NULL,
  PRIMARY KEY (`id_user`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_user_info
-- ----------------------------
BEGIN;
INSERT INTO `fp_user_info` VALUES (1, 10);
INSERT INTO `fp_user_info` VALUES (17, 10);
COMMIT;

-- ----------------------------
-- Table structure for fp_user_residence
-- ----------------------------
DROP TABLE IF EXISTS `fp_user_residence`;
CREATE TABLE `fp_user_residence` (
  `id_user` int(8) NOT NULL,
  `id_residence` int(8) NOT NULL,
  PRIMARY KEY (`id_user`,`id_residence`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of fp_user_residence
-- ----------------------------
BEGIN;
INSERT INTO `fp_user_residence` VALUES (17, 10);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES ('user', 'el-icon-user', 'icon');
INSERT INTO `sys_dict` VALUES ('house', 'el-icon-house', 'icon');
INSERT INTO `sys_dict` VALUES ('menu', 'el-icon-menu', 'icon');
INSERT INTO `sys_dict` VALUES ('s-custom', 'el-icon-s-custom', 'icon');
INSERT INTO `sys_dict` VALUES ('s-grid', 'el-icon-s-grid', 'icon');
INSERT INTO `sys_dict` VALUES ('document', 'el-icon-document', 'icon');
INSERT INTO `sys_dict` VALUES ('coffee', 'el-icon-coffee\r\n', 'icon');
INSERT INTO `sys_dict` VALUES ('s-marketing', 'el-icon-s-marketing', 'icon');
COMMIT;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小(kb)',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否禁用链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
BEGIN;
INSERT INTO `sys_file` VALUES (39, 'Arcane.jpg', 'jpg', 86, 'http://8.141.48.181:8081/api/file/58c2c2c57e2943019e04e1208bed5490.jpg', 'e2e8de597f91e49303ddf51078f6612f', 1, 1);
INSERT INTO `sys_file` VALUES (40, 'Snipaste_2021-08-26_08-45-48.jpg', 'jpg', 107, 'http://8.141.48.181:8081/api/file/3be99304ca0746e89ef03b3f0e3c6b14.jpg', '9cb9ab6c38a089118a44150a56cf30f8', 0, 1);
INSERT INTO `sys_file` VALUES (41, '施工中.png', 'png', 329, 'http://8.141.48.181:8081/api/file/7abebd69c0ae48b1839cfe1711866490.png', 'de4df8e740c6c415b4dbc89f183c6458', 0, 1);
INSERT INTO `sys_file` VALUES (42, 'Arcane.jpg', 'jpg', 86, 'http://8.141.48.181:8081/api/file/58c2c2c57e2943019e04e1208bed5490.jpg', 'e2e8de597f91e49303ddf51078f6612f', 0, 1);
INSERT INTO `sys_file` VALUES (43, 'qq头像.jpg', 'jpg', 54, 'http://8.141.48.181:8081/api/file/872f393961c54efda45ac64cac8ff9b5.jpg', 'dc2a7ef9baaed15f142eae7af4dd66e9', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路径',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `page_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '页面路径',
  `sort_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '主页', '/home', 'el-icon-house', NULL, NULL, 'Home', 0);
INSERT INTO `sys_menu` VALUES (2, '仪 表 盘', '/dashboard', 'el-icon-s-marketing', '11', NULL, 'Dashboard', 100);
INSERT INTO `sys_menu` VALUES (4, '系统管理', NULL, 'el-icon-s-grid', NULL, NULL, NULL, 300);
INSERT INTO `sys_menu` VALUES (5, '用户管理', '/user', 'el-icon-user', NULL, 4, 'User', 301);
INSERT INTO `sys_menu` VALUES (6, '角色管理', '/role', 'el-icon-s-custom', NULL, 4, 'Role', 302);
INSERT INTO `sys_menu` VALUES (7, '菜单管理', '/menu', 'el-icon-menu', NULL, 4, 'Menu', 303);
INSERT INTO `sys_menu` VALUES (8, '文件管理', '/file', 'el-icon-document', NULL, 4, 'File', 304);
INSERT INTO `sys_menu` VALUES (11, '流动人口管理', NULL, 'el-icon-s-grid', NULL, NULL, NULL, 400);
INSERT INTO `sys_menu` VALUES (12, '人口信息管理', '/info', 'el-icon-document', NULL, 11, 'Info', 401);
INSERT INTO `sys_menu` VALUES (13, '违法记录管理', '/illegal', 'el-icon-document', NULL, 11, 'Illegal', 403);
INSERT INTO `sys_menu` VALUES (14, '生育记录管理', '/birth', 'el-icon-s-grid', NULL, 11, 'Birth', 404);
INSERT INTO `sys_menu` VALUES (15, '暂住证管理', '/residence', 'el-icon-document', NULL, 11, 'Residence', 402);
INSERT INTO `sys_menu` VALUES (16, '个人管理', '', 'el-icon-coffee\r\n', NULL, NULL, '', 500);
INSERT INTO `sys_menu` VALUES (17, '个人数据查看', '/my', 'el-icon-s-custom', NULL, 16, 'My', 501);
INSERT INTO `sys_menu` VALUES (18, 'test', '/test', 'el-icon-s-grid', 'test', 16, 'test', 502);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `flag` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '管理员', '管理员', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES (2, '普通用户', '普通用户', 'ROLE_USER');
INSERT INTO `sys_role` VALUES (3, '123', '23', '213');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (2, 16);
INSERT INTO `sys_role_menu` VALUES (2, 17);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 5);
INSERT INTO `sys_role_menu` VALUES (3, 6);
INSERT INTO `sys_role_menu` VALUES (3, 7);
INSERT INTO `sys_role_menu` VALUES (3, 8);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `avatar_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `role` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', 'admin', '管理员', 'admin@qq.com', '13988997788', '浙江', '2022-01-22 21:10:27', 'http://m.imeitou.com/uploads/allimg/2019022710/ayk4dr5gkvi.jpg', 'ROLE_ADMIN');
INSERT INTO `sys_user` VALUES (16, '2', '', '甄姬', '2', '2', '2', '2022-02-26 22:10:14', '', 'ROLE_USER');
INSERT INTO `sys_user` VALUES (17, '333', '123', '我是三三', '3', '3', '3', '2022-02-26 22:10:18', 'http://8.141.48.181:8081/api/file/872f393961c54efda45ac64cac8ff9b5.jpg', 'ROLE_USER');
INSERT INTO `sys_user` VALUES (19, 'ys', '123', '亚瑟', '3', '3', '3', '2022-04-29 16:59:44', '', '');
INSERT INTO `sys_user` VALUES (20, 'lx', '123', '李信', '2', '2', '2', '2022-05-29 17:12:04', '2', '');
INSERT INTO `sys_user` VALUES (25, 'sir324', '123', '安琪拉', '', '', '', '2022-06-08 17:00:47', '', 'ROLE_USER');
INSERT INTO `sys_user` VALUES (26, 'daji', '', '妲己', '11', '1', '1', '2022-07-08 17:20:01', '', '213');
INSERT INTO `sys_user` VALUES (28, 'ddd', '123', 'ddd', '', '', '', '2022-11-09 10:41:07', '', 'ROLE_USER');
INSERT INTO `sys_user` VALUES (29, '123', '123', 'ddds', 'd', 'd', 'd', '2022-12-10 11:53:31', '', 'ROLE_USER');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
