package cn.lili.modules.logistics.service.impl;

import cn.lili.modules.logistics.entity.dos.Warehouse;
import cn.lili.modules.logistics.entity.dos.WarehouseStock;
import cn.lili.modules.logistics.mapper.WarehouseMapper;
import cn.lili.modules.logistics.mapper.WarehouseStockMapper;
import cn.lili.modules.logistics.service.WarehouseSelectionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 仓库选择服务实现
 *
 * @author yourname
 * @since 2023/10/10
 */
@Service
public class WarehouseSelectionServiceImpl implements WarehouseSelectionService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private WarehouseStockMapper warehouseStockMapper;

    /**
     * 选择最优发货仓库
     *
     * @param goodsId    商品ID
     * @param skuId      商品SKU ID
     * @param userAddress 用户地址
     * @return 最优发货仓库
     */
    @Override
    public Optional<Warehouse> selectOptimalWarehouse(String goodsId, String skuId, String userAddress) {
        // 1. 获取所有启用的仓库
        QueryWrapper<Warehouse> warehouseQuery = new QueryWrapper<>();
        warehouseQuery.eq("enabled", true);
        List<Warehouse> warehouses = warehouseMapper.selectList(warehouseQuery);

        // 2. 筛选有足够库存的仓库
        QueryWrapper<WarehouseStock> stockQuery = new QueryWrapper<>();
        stockQuery.eq("goods_id", goodsId);
        stockQuery.eq("sku_id", skuId);
        stockQuery.gt("available_quantity", 0);
        List<WarehouseStock> warehouseStocks = warehouseStockMapper.selectList(stockQuery);

        // 3. 根据用户地址、物流成本等因素选择最优仓库
        // 这里可以添加更复杂的选择逻辑，例如：
        // - 仓库与用户的距离
        // - 物流成本
        // - 仓库库存数量
        // - 仓库类型

        // 示例：简单的选择逻辑，选择第一个有库存的仓库
        for (WarehouseStock stock : warehouseStocks) {
            for (Warehouse warehouse : warehouses) {
                if (stock.getWarehouseId().equals(warehouse.getId())) {
                    return Optional.of(warehouse);
                }
            }
        }

        // 4. 如果没有找到有库存的仓库，返回默认仓库
        QueryWrapper<Warehouse> defaultQuery = new QueryWrapper<>();
        defaultQuery.eq("default_warehouse", true);
        defaultQuery.eq("enabled", true);
        Warehouse defaultWarehouse = warehouseMapper.selectOne(defaultQuery);

        return Optional.ofNullable(defaultWarehouse);
    }
}
