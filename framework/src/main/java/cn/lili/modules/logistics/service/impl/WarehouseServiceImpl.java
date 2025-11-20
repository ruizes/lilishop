package cn.lili.modules.logistics.service.impl;

import cn.lili.modules.logistics.entity.dos.Warehouse;
import cn.lili.modules.logistics.mapper.WarehouseMapper;
import cn.lili.modules.logistics.service.WarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 仓库服务实现
 *
 * @author yourname
 * @since 2023/10/10
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {
}
