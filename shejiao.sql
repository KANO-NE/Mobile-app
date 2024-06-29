/*
Navicat MySQL Data Transfer

Source Server         : zyq
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : shejiao

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2024-06-29 21:32:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动名称',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动介绍',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动图片',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动创建人',
  `num` int DEFAULT NULL COMMENT '活动规模',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='活动';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '爱狗人士', '爱狗人士', 'http://localhost:9090/files/1716079007398-EnpxPNGpsKlc0f1db022e239dca19373c91b037bfe96.png', '1', '1', '2024-06-19 08:36', '萌宠');
INSERT INTO `activity` VALUES ('2', '爱猫人士', '爱猫人士', 'http://localhost:9090/files/1716079130272-HLGypNhI62iD81708b8acda65bbc4854a573147d6179.png', '1', '1', '2024-06-19 08:38', '萌宠');
INSERT INTO `activity` VALUES ('3', '吃货天地', '吃货', 'http://localhost:9090/files/1716079186151-UwGIbu6E4jx61eb60085127b833dc7e3b00de9ba3892.png', '1', '2', '2024-06-19 08:39', '美食');
INSERT INTO `activity` VALUES ('4', '跑步吧', '日行千里', 'http://localhost:9090/files/1716079203210-YUxUg89lAM1i5620380de8184e1757b2ba4c1f1c07b3.png', '1', '2', '2024-06-19 08:40', '运动');
INSERT INTO `activity` VALUES ('5', '滑板', '滑板', 'http://localhost:9090/files/1716079217596-KTpVmbEULFoN1da99558d96c139abc350742e90620c9.png', '1', '1', '2024-06-19 08:40', '运动');
INSERT INTO `activity` VALUES ('7', '铲屎官', '铲屎官', 'http://localhost:9090/files/1716107220634-yEDj3Dbidprm81708b8acda65bbc4854a573147d6179.png', '2', '1', '2024-06-19 16:27', '萌宠');

-- ----------------------------
-- Table structure for activityrecords
-- ----------------------------
DROP TABLE IF EXISTS `activityrecords`;
CREATE TABLE `activityrecords` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `activity_id` int DEFAULT NULL COMMENT '活动编号',
  `user_id` int DEFAULT NULL COMMENT '用户编号',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='活动记录';

-- ----------------------------
-- Records of activityrecords
-- ----------------------------
INSERT INTO `activityrecords` VALUES ('1', '1', '1', '2024-06-19 08:36');
INSERT INTO `activityrecords` VALUES ('2', '2', '1', '2024-06-19 08:38');
INSERT INTO `activityrecords` VALUES ('3', '3', '1', '2024-06-19 08:39');
INSERT INTO `activityrecords` VALUES ('4', '4', '1', '2024-06-19 08:40');
INSERT INTO `activityrecords` VALUES ('5', '5', '1', '2024-06-19 08:40');
INSERT INTO `activityrecords` VALUES ('13', '7', '2', '2024-06-19 16:27');
INSERT INTO `activityrecords` VALUES ('21', '3', '3', '2024-06-29 16:06');
INSERT INTO `activityrecords` VALUES ('22', '4', '3', '2024-06-29 18:34');

-- ----------------------------
-- Table structure for activitytype
-- ----------------------------
DROP TABLE IF EXISTS `activitytype`;
CREATE TABLE `activitytype` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数值',
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='活动类型';

-- ----------------------------
-- Records of activitytype
-- ----------------------------
INSERT INTO `activitytype` VALUES ('1', '全部', '全部');
INSERT INTO `activitytype` VALUES ('2', '萌宠', '萌宠');
INSERT INTO `activitytype` VALUES ('3', '运动', '运动');
INSERT INTO `activitytype` VALUES ('4', '美食', '美食');
INSERT INTO `activitytype` VALUES ('5', '学习', '学习');
INSERT INTO `activitytype` VALUES ('6', '创业', '创业');
INSERT INTO `activitytype` VALUES ('7', '旅游', '旅游');
INSERT INTO `activitytype` VALUES ('8', '知识', '知识');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '官网运营官', 'http://localhost:9090/files/1697438073596-avatar.png', 'ADMIN', '13677889922', 'admin@xm.com');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '跳转地址',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='海报';

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', '首页', 'http://localhost:9090/files/1715730314080-1704122125648-bg1.jpg', null, '管理员', '2024年6月15日07:37:15');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `topic_id` int DEFAULT NULL COMMENT '收藏话题编号',
  `user_id` int DEFAULT NULL COMMENT '收藏用户编号',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='收藏';

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '6', '2', '2024-06-20 23:48:27');
INSERT INTO `collect` VALUES ('2', '1', '2', '2024-06-20 23:48:27');
INSERT INTO `collect` VALUES ('6', '6', '1', '2024-06-26 09:18:39');
INSERT INTO `collect` VALUES ('7', '1', '3', '2024-06-29 20:25:00');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '聊天内容',
  `accept_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '接收人',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='客服聊天';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('8', '2', '你好', null, '2024-06-13 17:23');
INSERT INTO `customer` VALUES ('9', '2', '您好，有什么问题吗', '2', '2024-06-13 17:24');
INSERT INTO `customer` VALUES ('10', '3', '012313', null, '2024-06-29 16:25');

-- ----------------------------
-- Table structure for historyrecord
-- ----------------------------
DROP TABLE IF EXISTS `historyrecord`;
CREATE TABLE `historyrecord` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content_id` int DEFAULT NULL COMMENT '内容编号',
  `plate` int DEFAULT NULL COMMENT '板块编号',
  `user_id` int DEFAULT NULL COMMENT '用户编号',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '浏览时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='历史记录';

-- ----------------------------
-- Records of historyrecord
-- ----------------------------
INSERT INTO `historyrecord` VALUES ('1', '6', '1', '2', '2024-06-12 22:00:50');
INSERT INTO `historyrecord` VALUES ('2', '1', '2', '2', '2024-06-12 22:05:45');
INSERT INTO `historyrecord` VALUES ('3', '2', '1', '2', '2024-06-12 22:31:51');
INSERT INTO `historyrecord` VALUES ('4', '7', '2', '2', '2024-06-12 22:35:01');
INSERT INTO `historyrecord` VALUES ('5', '5', '1', '2', '2024-06-12 22:58:31');
INSERT INTO `historyrecord` VALUES ('6', '5', '2', '2', '2024-06-12 22:59:02');
INSERT INTO `historyrecord` VALUES ('7', '6', '1', '2', '2024-06-20 23:02:14');
INSERT INTO `historyrecord` VALUES ('8', '6', '1', '2', '2024-06-21 19:07:45');
INSERT INTO `historyrecord` VALUES ('9', '7', '2', '1', '2024-06-26 08:42:15');
INSERT INTO `historyrecord` VALUES ('10', '5', '1', '2', '2024-06-26 16:03:27');
INSERT INTO `historyrecord` VALUES ('11', '5', '1', '2', '2024-06-26 17:29:24');
INSERT INTO `historyrecord` VALUES ('12', '6', '1', '3', '2024-06-29 16:08:19');
INSERT INTO `historyrecord` VALUES ('13', '6', '1', '3', '2024-06-29 16:08:23');
INSERT INTO `historyrecord` VALUES ('14', '6', '1', '3', '2024-06-29 19:25:14');
INSERT INTO `historyrecord` VALUES ('15', '6', '1', '3', '2024-06-29 20:09:02');
INSERT INTO `historyrecord` VALUES ('16', '7', '2', '3', '2024-06-29 20:25:38');
INSERT INTO `historyrecord` VALUES ('17', '7', '2', '3', '2024-06-29 20:26:25');
INSERT INTO `historyrecord` VALUES ('18', '7', '2', '3', '2024-06-29 20:34:02');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='公告信息表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '今天系统正式上线，开始内测', '今天系统正式上线，开始内测', '2024-06-12', 'admin');
INSERT INTO `notice` VALUES ('2', '所有功能都已完成，可以正常使用', '所有功能都已完成，可以正常使用', '2024-06-12', 'admin');
INSERT INTO `notice` VALUES ('3', '社交小程序正式上线！', '社交小程序正式上线！', '2024-06-12', 'admin');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `reply` int DEFAULT NULL COMMENT '回复人数',
  `num` int DEFAULT NULL COMMENT '浏览次数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='今日话题';

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '不得不说我有个秘密告诉你', '1', '1', '2024年6月14日20:54:06', '管理员');
INSERT INTO `topic` VALUES ('2', '你有什么喜欢吃的东西呀？', '0', '0', '2024年6月14日22:30:30', '管理员');
INSERT INTO `topic` VALUES ('5', '最喜欢的运动是什么？', '0', '0', '2024-06-19 15:10:22', '123');
INSERT INTO `topic` VALUES ('6', '你最喜欢吃什么口味的食物？', '2', '4', '2024-06-19 15:10:22', '123');
INSERT INTO `topic` VALUES ('7', '如何更好的学习', '0', '0', '2024-06-29 19:34:11', 'yh1');

-- ----------------------------
-- Table structure for topicreply
-- ----------------------------
DROP TABLE IF EXISTS `topicreply`;
CREATE TABLE `topicreply` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `topic_id` int DEFAULT NULL COMMENT '话题编号',
  `user_id` int DEFAULT NULL COMMENT '留言用户编号',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '留言内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='话题回复信息';

-- ----------------------------
-- Records of topicreply
-- ----------------------------
INSERT INTO `topicreply` VALUES ('1', '6', '1', '123', '2024-06-26 09:18');
INSERT INTO `topicreply` VALUES ('2', '1', '3', '111', '2024-06-29 16:08');
INSERT INTO `topicreply` VALUES ('3', '6', '3', '微辣', '2024-06-29 19:25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户介绍',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '禁用状态',
  `lasttime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '官网运营', '123', null, '13677889922', 'USER', '女', 'http://localhost:9090/files/1716079929395-7vG5kDqlnCCR859140fd96afd3c83414a85fc31695af.png', null, null);
INSERT INTO `user` VALUES ('2', '1234', '1234', '123', '123', null, '123', 'USER', '女', 'http://localhost:9090/files/1716100189227-微信图片_20230717214313.jpg', null, null);
INSERT INTO `user` VALUES ('3', 'yonghu1', '123321', 'yh1', null, '2000-01-01', '12311110001', 'USER', null, 'http://localhost:9090/files/1719648325826-w0zuOxJ3pjy3ee12bde16d5dd57fb58e759aa2118361.jpg', null, null);
INSERT INTO `user` VALUES ('4', 'yh2', '123321', 'yh2', null, '2000-01-01', '12311112222', 'USER', null, 'http://localhost:9090/files/1719659366299-Light_67994735.png', null, null);

-- ----------------------------
-- Table structure for usercollect
-- ----------------------------
DROP TABLE IF EXISTS `usercollect`;
CREATE TABLE `usercollect` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int DEFAULT NULL COMMENT '用户编号',
  `target_id` int DEFAULT NULL COMMENT '关注对象编号',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户关注';

-- ----------------------------
-- Records of usercollect
-- ----------------------------
INSERT INTO `usercollect` VALUES ('2', '2', '1', '2024-06-21 20:49:39');
INSERT INTO `usercollect` VALUES ('3', '1', '2', '2024-06-26 08:58:36');
INSERT INTO `usercollect` VALUES ('4', '3', '2', '2024-06-29 16:06:56');
INSERT INTO `usercollect` VALUES ('5', '3', '4', '2024-06-29 19:22:02');
