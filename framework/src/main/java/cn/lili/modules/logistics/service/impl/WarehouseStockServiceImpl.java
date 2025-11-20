package cn.lili.modules.logistics.service.impl;

import cn.lili.modules.logistics.entity.dos.WarehouseStock;
import cn.lili.modules.logistics.mapper.WarehouseStockMapper;
import cn.lili.modules.logistics.service.WarehouseStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 仓库库存服务实现
 *
 * @author yourname
 * @since 2023/10/10
 */
@Service
public class WarehouseStockServiceImpl extends ServiceImpl<WarehouseStockMapper, WarehouseStock> implements WarehouseStockService {
}
