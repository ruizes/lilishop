package cn.lili.modules.logistics.service;

import cn.lili.modules.logistics.entity.dos.Warehouse;
import java.util.Optional;

/**
 * 仓库选择服务接口
 *
 * @author yourname
 * @since 2023/10/10
 */
public interface WarehouseSelectionService {

    /**
     * 选择最优发货仓库
     *
     * @param goodsId    商品ID
     * @param skuId      商品SKU ID
     * @param userAddress 用户地址
     * @return 最优发货仓库
     */
    Optional<Warehouse> selectOptimalWarehouse(String goodsId, String skuId, String userAddress);
}
