/*
 Navicat Premium Data Transfer

 Source Server         : 5.7
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3305
 Source Schema         : qygldb

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 31/12/2021 16:20:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '无意义，主键uuid',
  `orderNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号不为空，唯一',
  `orderTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下单时间',
  `orderDesc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单描述（其他信息）',
  `payType` int(11) NULL DEFAULT NULL COMMENT '支付方式（0支付包，1微信，2其他）',
  `orderStatus` int(11) NULL DEFAULT NULL COMMENT '订单状态（0未支付，1已支付）',
  `productid` int(11) NULL DEFAULT NULL COMMENT '产品id外键',
  `userid` int(11) NULL DEFAULT NULL COMMENT '会员（联系人）id外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '12', '2021-12-11', NULL, 1, 1, 4, 1);
INSERT INTO `orders` VALUES (3, '12', '2021-12-11', NULL, 1, 1, 4, 1);
INSERT INTO `orders` VALUES (4, '12', '2021-12-11', NULL, 1, 1, 4, 1);
INSERT INTO `orders` VALUES (34, '12', '2021-12-11', NULL, 1, 1, 4, 1);
INSERT INTO `orders` VALUES (66, '12', '2021-12-11', NULL, 1, 1, 7, 1);

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '无意义，主键',
  `productNum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `productName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品名称',
  `cityName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `departureTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `productPrice` decimal(10, 2) NULL DEFAULT NULL,
  `productDesc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品描述',
  `productStatus` int(11) NULL DEFAULT NULL COMMENT '状态（0关闭，开启）',
  PRIMARY KEY (`id`, `productNum`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (4, '45', '苹果', '萍乡', '2021-12-11', 12.00, '水果', 0);
INSERT INTO `products` VALUES (7, '1234', '西瓜', '萍乡', '2021-12-11', 12.00, '水果', 0);
INSERT INTO `products` VALUES (8, '567', '苹果', '萍乡', '2021-12-11', 12.00, '水果', 0);
INSERT INTO `products` VALUES (96, '4', '苹果', '萍乡', '2021-12-11', 12.00, '水果', 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '无意义，主键id',
  `account` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `birthday` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生日',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `account`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'tan', '123', NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES (17, '潘平', '123', '女', '天津 天津市 武清区', '2014-09-07', 's.iyjwe@ztoexdbv.gl');
INSERT INTO `users` VALUES (26, '刘涛', '123', '男', '浙江省 台州市 临海市', '2004-02-22', 'd.vruxm@vsmlgp.do');
INSERT INTO `users` VALUES (27, '蔡洋', '123', '男', '澳门特别行政区 澳门半岛 -', '2021-07-30', 'm.nedubtqsmk@tgsgv.mq');
INSERT INTO `users` VALUES (28, '袁丽', '123', '女', '云南省 玉溪市 新平彝族傣族自治县', '2019-07-16', 'b.iprmk@obrkuqpgy.kg');
INSERT INTO `users` VALUES (29, '谭娟', '123', '男', '山西省 长治市 其它区', '1975-11-02', 'q.ksdsgfmwj@qwypp.ru');
INSERT INTO `users` VALUES (30, '潘秀兰', '123', '男', '贵州省 黔南布依族苗族自治州 独山县', '1992-02-19', 'm.kcmtx@fxadnty.yu');
INSERT INTO `users` VALUES (31, '叶超', '123', '女', '黑龙江省 齐齐哈尔市 富拉尔基区', '2006-09-22', 'm.wfdkauf@zqlx.bz');
INSERT INTO `users` VALUES (32, '罗娟', '123', '男', '云南省 红河哈尼族彝族自治州 蒙自市', '1975-09-26', 'y.rtsdmmuu@inze.vg');
INSERT INTO `users` VALUES (33, '尹娜', '123', '男', '河南省 平顶山市 汝州市', '2007-04-14', 'e.tfbvj@tieipypp.ye');
INSERT INTO `users` VALUES (34, '董超', '123', '女', '香港特别行政区 九龙 黄大仙区', '1993-07-21', 'l.pvkeuoen@mmnm.tel');
INSERT INTO `users` VALUES (35, '康杰', '123', '女', '湖北省 孝感市 云梦县', '2012-01-18', 'v.bwtkngopyy@gbgzk.lk');
INSERT INTO `users` VALUES (36, 'qwe1', '123', '女', '江西工业工程职业技术学院', '2021-12-03', '18720014135@qq.com');
INSERT INTO `users` VALUES (37, 'tan1', '123', '女', '江西工业工程职业技术学院', '2021-12-26', 'taninsist@gmail.com');

SET FOREIGN_KEY_CHECKS = 1;
