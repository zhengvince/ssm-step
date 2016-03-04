/*
Navicat MySQL Data Transfer

Source Server         : laravel5111
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-03-04 16:10:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bland` varchar(30) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '奥迪', '黑色');
INSERT INTO `car` VALUES ('2', '奔驰', '白色');
INSERT INTO `car` VALUES ('3', '宝马', '红色');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `age` smallint(5) unsigned DEFAULT NULL,
  `salt` varchar(60) DEFAULT NULL,
  `locked` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '333333', '18', null, null);
INSERT INTO `user` VALUES ('2', 'lisi', '444444', '24', null, null);
INSERT INTO `user` VALUES ('3', 'wangwu', '555555', '28', null, null);
INSERT INTO `user` VALUES ('4', 'zhaoliu', '666666', '35', null, null);
