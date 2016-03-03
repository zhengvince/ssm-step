/*
 Navicat Premium Data Transfer

 Source Server         : mac
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : learn

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 03/01/2016 19:39:50 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bland` varchar(30) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `car`
-- ----------------------------
BEGIN;
INSERT INTO `car` VALUES ('1', '奥迪', '黑色'), ('2', '奔驰', '白色'), ('3', '宝马', '红色');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `age` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'zhangsan', '333333', '18'), ('2', 'lisi', '444444', '24'), ('3', 'wangwu', '555555', '28'), ('4', 'zhaoliu', '666666', '35');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
