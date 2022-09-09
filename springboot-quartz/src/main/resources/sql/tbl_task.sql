/*
 Navicat Premium Data Transfer

 Source Server         : mysql_8.0.21
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : springboot_quartz

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 09/09/2022 16:15:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_task
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task`;
CREATE TABLE `tbl_task`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(0) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间/注册时间',
  `modify_by` bigint(0) NULL DEFAULT NULL COMMENT '最后更新人',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  `concurrent` tinyint(0) NULL DEFAULT NULL COMMENT '是否允许并发',
  `cron` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定时规则',
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '执行参数',
  `disabled` tinyint(0) NULL DEFAULT NULL COMMENT '是否禁用',
  `exec_at` datetime(0) NULL DEFAULT NULL COMMENT '执行时间',
  `exec_result` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行结果',
  `job_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行类',
  `job_group` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_task
-- ----------------------------
INSERT INTO `tbl_task` VALUES (6, NULL, NULL, NULL, NULL, 0, '0/10 * * * * ? *', NULL, 0, '2022-09-09 16:11:30', '执行成功', 'com.lwc.springbootquartz.job.TestJob', NULL, '测试任务', '测试任务');

SET FOREIGN_KEY_CHECKS = 1;
