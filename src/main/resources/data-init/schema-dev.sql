CREATE TABLE `turbine_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `turbine_id` varchar(64) NOT NULL COMMENT '风机ID',
  `turbine_name` varchar(64) DEFAULT NULL COMMENT '风机名称',
  `ip` varchar(64) NOT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
);