-- 创建仓库表
CREATE TABLE `li_warehouse` (
  `id` varchar(32) NOT NULL COMMENT '仓库ID',
  `name` varchar(100) NOT NULL COMMENT '仓库名称',
  `code` varchar(50) NOT NULL COMMENT '仓库编码',
  `province` varchar(50) NOT NULL COMMENT '省份',
  `city` varchar(50) NOT NULL COMMENT '城市',
  `district` varchar(50) NOT NULL COMMENT '区/县',
  `address` varchar(255) NOT NULL COMMENT '详细地址',
  `contact` varchar(50) NOT NULL COMMENT '联系人',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  `default_warehouse` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否默认仓库',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `type` varchar(50) DEFAULT NULL COMMENT '仓库类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_warehouse_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库表';

-- 创建仓库库存表
CREATE TABLE `li_warehouse_stock` (
  `id` varchar(32) NOT NULL COMMENT '库存ID',
  `warehouse_id` varchar(32) NOT NULL COMMENT '仓库ID',
  `goods_id` varchar(32) NOT NULL COMMENT '商品ID',
  `sku_id` varchar(32) NOT NULL COMMENT '商品SKU ID',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量',
  `available_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '可用库存',
  `locked_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '锁定库存',
  `alert_quantity` int(11) DEFAULT '0' COMMENT '预警库存',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_warehouse_stock_warehouse` (`warehouse_id`),
  KEY `idx_warehouse_stock_goods` (`goods_id`),
  KEY `idx_warehouse_stock_sku` (`sku_id`),
  KEY `idx_warehouse_stock_warehouse_sku` (`warehouse_id`, `sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库库存表';

-- 创建库存操作日志表
CREATE TABLE `li_stock_operation_log` (
  `id` varchar(32) NOT NULL COMMENT '日志ID',
  `warehouse_id` varchar(32) DEFAULT NULL COMMENT '仓库ID',
  `goods_id` varchar(32) NOT NULL COMMENT '商品ID',
  `sku_id` varchar(32) NOT NULL COMMENT '商品SKU ID',
  `operation_type` varchar(50) NOT NULL COMMENT '操作类型',
  `quantity` int(11) NOT NULL COMMENT '操作数量',
  `before_quantity` int(11) NOT NULL COMMENT '操作前数量',
  `after_quantity` int(11) NOT NULL COMMENT '操作后数量',
  `operator` varchar(50) NOT NULL COMMENT '操作人',
  `description` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `relation_no` varchar(50) DEFAULT NULL COMMENT '关联单号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_stock_log_warehouse` (`warehouse_id`),
  KEY `idx_stock_log_goods` (`goods_id`),
  KEY `idx_stock_log_sku` (`sku_id`),
  KEY `idx_stock_log_operation` (`operation_type`),
  KEY `idx_stock_log_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存操作日志表';

-- 初始化默认仓库数据
INSERT INTO `li_warehouse` (`id`, `name`, `code`, `province`, `city`, `district`, `address`, `contact`, `phone`, `default_warehouse`, `enabled`, `type`, `remark`, `create_time`) VALUES
('WH001', '默认仓库', 'DEFAULT', '北京市', '北京市', '朝阳区', '北京市朝阳区建国路88号', '张三', '13800138000', 1, 1, '普通仓库', '系统默认仓库', NOW());
