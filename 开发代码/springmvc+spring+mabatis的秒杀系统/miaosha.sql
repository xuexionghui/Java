/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-28 20:19:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for msmerchant
-- ----------------------------
DROP TABLE IF EXISTS `msmerchant`;
CREATE TABLE `msmerchant` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `merchantname` varchar(255) DEFAULT NULL,
  `merchantaccount` varchar(255) DEFAULT NULL,
  `merchantpassword` varchar(255) DEFAULT NULL,
  `merchantscope` varchar(255) DEFAULT NULL,
  `merchantshopname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of msmerchant
-- ----------------------------

-- ----------------------------
-- Table structure for msorder
-- ----------------------------
DROP TABLE IF EXISTS `msorder`;
CREATE TABLE `msorder` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `productid` int(100) DEFAULT NULL,
  `payamount` int(100) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `merchantid` int(100) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `paytime` date DEFAULT NULL,
  `paystatus` int(11) DEFAULT NULL,
  `receivingadress` varchar(255) DEFAULT NULL,
  `receivingname` varchar(255) DEFAULT NULL,
  `receivingphone` varchar(255) DEFAULT NULL,
  `tradeserialnumber` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `paytype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of msorder
-- ----------------------------

-- ----------------------------
-- Table structure for msproductdetail
-- ----------------------------
DROP TABLE IF EXISTS `msproductdetail`;
CREATE TABLE `msproductdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `merchantid` int(11) DEFAULT NULL,
  `productplace` varchar(255) DEFAULT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `brandname` varchar(255) DEFAULT NULL,
  `productdetailpicture` varchar(255) DEFAULT NULL,
  `productweight` varchar(255) DEFAULT NULL,
  `specification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of msproductdetail
-- ----------------------------

-- ----------------------------
-- Table structure for msproductinfo
-- ----------------------------
DROP TABLE IF EXISTS `msproductinfo`;
CREATE TABLE `msproductinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `producttitle` varchar(255) DEFAULT NULL,
  `productpicture` varchar(255) DEFAULT NULL,
  `miaoshaprice` int(11) DEFAULT NULL,
  `originalprice` int(11) DEFAULT NULL,
  `msmerchantid` int(11) DEFAULT NULL,
  `applydate` date DEFAULT NULL,
  `auditdate` date DEFAULT NULL,
  `auditstate` int(11) DEFAULT NULL,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `starttimestring` varchar(255) DEFAULT NULL,
  `endtimestring` varchar(255) DEFAULT NULL,
  `productcount` int(11) DEFAULT NULL,
  `stockcount` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of msproductinfo
-- ----------------------------

-- ----------------------------
-- Table structure for msuser
-- ----------------------------
DROP TABLE IF EXISTS `msuser`;
CREATE TABLE `msuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `useraccount` varchar(255) DEFAULT NULL,
  `userpassword` varchar(255) DEFAULT NULL,
  `usersex` int(11) DEFAULT NULL,
  `userage` int(11) DEFAULT NULL,
  `useraddress` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of msuser
-- ----------------------------

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person
-- ----------------------------
