/*
 Navicat MySQL Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : booksystem

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 25/05/2021 17:01:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administered
-- ----------------------------
DROP TABLE IF EXISTS `administered`;
CREATE TABLE `administered`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administered
-- ----------------------------
INSERT INTO `administered` VALUES (1, 'wjl', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '书名',
  `price` float NULL DEFAULT NULL COMMENT '价格',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '暂无作者信息' COMMENT '作者\r\n',
  `publishdate` date NULL DEFAULT NULL COMMENT '出版日期',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '暂无分类' COMMENT '类别',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT './bookbackgroud/bookBackgroud.jpg' COMMENT '封面图片相对路径',
  `IBSN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '暂无IBSN码' COMMENT 'IBSN',
  `introductory` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '暂无简介信息' COMMENT '简介',
  `number` int(11) NULL DEFAULT 1 COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '高数', 60, '同济大学数学系', '2008-05-01', '数学类', '.\\bookbackgroud\\bookBackgroud1.jpg', '978-7-04-039662-1', '               暂无简介信息', 1);
INSERT INTO `book` VALUES (2, 'java程序设计', 60.5, '杨国兴', '2007-09-11', '计算机类', './bookbackgroud/bookBackgroud.jpg', '978-7-111-5479-9', '  暂无简介信息', 1);
INSERT INTO `book` VALUES (4, '线性代数', 80, '', NULL, '数学类', './bookbackgroud/bookBackgroud.jpg', '暂无IBSN码', ' 暂无简介信息', 1);
INSERT INTO `book` VALUES (5, '数据结构与算法分析', 99, '马克—艾伦—维斯', NULL, '计算机类', './bookbackgroud/bookBackgroud.jpg', '暂无IBSN码', '暂无简介信息', 1);
INSERT INTO `book` VALUES (6, 'c语言设计', 55, '暂无作者信息', NULL, '暂无分类', './bookbackgroud/bookBackgroud.jpg', '暂无IBSN码', ' 暂无简介', 1);
INSERT INTO `book` VALUES (7, '离散数学', 60, '暂无作者信息', NULL, '暂无分类', '.\\bookbackgroud\\bookBackgroud7.jpg', '暂无IBSN码', '  暂无简介信息', 1);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '借阅编号',
  `userid` int(255) NOT NULL COMMENT '读者编号',
  `bookid` int(255) NOT NULL COMMENT '图书编号',
  `outtime` date NOT NULL COMMENT '借书日期',
  `endtime` date NOT NULL COMMENT '到期日期',
  `backtime` date NULL DEFAULT NULL COMMENT '还书日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  INDEX `bookid`(`bookid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 1, 2, '2021-05-07', '2021-06-07', '2021-05-07');
INSERT INTO `borrow` VALUES (2, 1, 1, '2021-05-07', '2021-06-07', '2021-05-08');
INSERT INTO `borrow` VALUES (3, 1, 5, '2021-05-07', '2021-06-07', '2021-05-08');
INSERT INTO `borrow` VALUES (4, 1, 6, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (5, 1, 1, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (6, 1, 5, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (7, 1, 4, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (8, 1, 6, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (9, 1, 4, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (10, 1, 6, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (11, 1, 6, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (12, 1, 6, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (13, 1, 2, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (14, 1, 2, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (15, 1, 2, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (16, 1, 3, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (17, 1, 2, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (18, 1, 5, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (19, 1, 4, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (20, 1, 3, '2021-05-08', '2021-06-08', '2021-05-08');
INSERT INTO `borrow` VALUES (21, 11, 6, '2021-05-08', '2021-06-08', '2021-05-14');
INSERT INTO `borrow` VALUES (22, 1, 1, '2021-05-09', '2021-06-09', '2021-05-09');
INSERT INTO `borrow` VALUES (23, 1, 2, '2021-05-09', '2021-06-09', '2021-05-09');
INSERT INTO `borrow` VALUES (24, 1, 1, '2021-05-12', '2021-06-12', '2021-05-12');
INSERT INTO `borrow` VALUES (25, 14, 2, '2021-05-13', '2021-06-13', '2021-05-13');
INSERT INTO `borrow` VALUES (26, 1, 5, '2021-05-14', '2021-06-14', '2021-05-14');
INSERT INTO `borrow` VALUES (27, 1, 1, '2021-05-14', '2021-06-14', '2021-05-14');
INSERT INTO `borrow` VALUES (28, 1, 1, '2021-05-16', '2021-06-16', '2021-05-16');
INSERT INTO `borrow` VALUES (29, 1, 2, '2021-05-18', '2021-06-18', '2021-05-18');
INSERT INTO `borrow` VALUES (30, 1, 2, '2021-05-18', '2021-06-18', '2021-05-18');
INSERT INTO `borrow` VALUES (31, 1, 2, '2021-05-21', '2021-06-21', '2021-05-21');
INSERT INTO `borrow` VALUES (32, 1, 2, '2021-05-21', '2021-06-21', '2021-05-21');
INSERT INTO `borrow` VALUES (33, 1, 1, '2021-05-21', '2021-06-21', '2021-05-21');
INSERT INTO `borrow` VALUES (34, 11, 7, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (35, 11, 1, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (36, 11, 6, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (37, 11, 6, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (38, 11, 7, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (39, 1, 6, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (40, 1, 2, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (41, 1, 2, '2021-05-23', '2021-06-23', '2021-05-23');
INSERT INTO `borrow` VALUES (42, 1, 1, '2021-05-24', '2021-06-24', '2021-05-24');
INSERT INTO `borrow` VALUES (43, 1, 6, '2021-05-24', '2021-06-24', '2021-05-24');
INSERT INTO `borrow` VALUES (44, 1, 4, '2021-05-24', '2021-06-24', '2021-05-24');

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '.\\code\\01.jpg' COMMENT '验证码相对路径',
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES (1, '.\\code\\01.jpg', '6220');
INSERT INTO `code` VALUES (2, '.\\code\\02.jpg', '06624');
INSERT INTO `code` VALUES (3, '.\\code\\03.jpg', '你冷不冷');
INSERT INTO `code` VALUES (4, '.\\code\\04.jpg', 'giv6j');
INSERT INTO `code` VALUES (5, '.\\code\\05.jpg', '大象');
INSERT INTO `code` VALUES (6, '.\\code\\06.jpg', 'smwm');
INSERT INTO `code` VALUES (7, '.\\code\\07.jpg', '快周刊');
INSERT INTO `code` VALUES (8, '.\\code\\08.jpg', 'guanzhong');
INSERT INTO `code` VALUES (9, '.\\code\\09.jpg', '6m44m');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone` int(255) NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '居住他',
  `topphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT './topphone/0.jpg' COMMENT '头像路径',
  `mony` float NULL DEFAULT 100 COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wjl', '123', NULL, NULL, NULL, './topphone/1.jpg', 2028.5);
INSERT INTO `user` VALUES (2, 'wjl116', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (3, 'qwe', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (4, 'wjl22', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (5, 'wjl456', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (6, 'wjk123', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (7, 'll123', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (8, 'poi', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (9, 'cy1', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (10, 'cy2', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (11, 'wjl123', '123', NULL, NULL, NULL, './topphone/0.jpg', 35);
INSERT INTO `user` VALUES (12, 'wjl189', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (13, 'wjl12345', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (14, 'wjl852', '123', NULL, 1513318266, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (15, 'wjl789', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (29, 'wjlpp', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (30, 'wjl452', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);
INSERT INTO `user` VALUES (31, 'wjlopl', '123', NULL, NULL, NULL, './topphone/0.jpg', 100);

SET FOREIGN_KEY_CHECKS = 1;
