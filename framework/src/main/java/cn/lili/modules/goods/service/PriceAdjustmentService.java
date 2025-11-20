package cn.lili.modules.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.lili.modules.goods.entity.dos.Goods;

/**
 * 价格调整服务接口
 *
 * @author yourname
 * @since 2023/10/10
 */
public interface PriceAdjustmentService extends IService<Goods> {

    /**
     * 库存需求预测
     *
     * @param goodsId 商品ID
     * @param days    预测天数
     * @return 预测的库存需求
     */
    Integer predictInventoryDemand(String goodsId, Integer days);
}
