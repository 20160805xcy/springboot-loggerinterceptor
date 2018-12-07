/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : wolf

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-12-07 14:37:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `log_client_ip` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '客户端请求ip',
  `log_uri` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '客户端请求路径',
  `log_type` varchar(55) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式(普通请求,ajax请求)',
  `log_method` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式(get,post)',
  `log_param_data` longtext COLLATE utf8mb4_bin COMMENT '请求的参数json',
  `log_session_id` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求接口唯一session标识',
  `log_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求时间',
  `log_return_time` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接口返回时间',
  `log_return_data` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接口返回json',
  `log_http_status_code` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'http接口返回状态码',
  `log_time_consuming` int(8) DEFAULT NULL,
  UNIQUE KEY `id主键` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='日志记录';

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES ('1', '0:0:0:0:0:0:0:1', '/loginfo/login', null, 'GET', 0x7B7D, null, null, '1543912885241', '{\"msg\":\"用户:null,登录成功.\"}', '200', '4');
INSERT INTO `log_info` VALUES ('2', '0:0:0:0:0:0:0:1', '/loginfo/login', null, 'GET', 0x7B226E616D65223A5B227A68616E73616E225D7D, null, null, '1543913163844', '{\"msg\":\"用户:zhansan,登录成功.\"}', '200', '3');
INSERT INTO `log_info` VALUES ('3', '192.168.6.102', '/error', null, 'GET', 0x7B7D, null, null, '1544155248034', 'null', '404', '44');
INSERT INTO `log_info` VALUES ('4', '192.168.6.102', '/loginfo/login', null, 'GET', 0x7B7D, null, null, '1544155322790', '{\"msg\":\"用户:null,登录成功.\"}', '200', '14447');
INSERT INTO `log_info` VALUES ('5', '192.168.6.102', '/loginfo/login', null, 'GET', 0x7B7D, null, null, '1544155465263', '{\"msg\":\"用户:null,登录成功.\"}', '200', '14021');
