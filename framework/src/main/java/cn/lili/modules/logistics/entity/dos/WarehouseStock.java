package cn.lili.modules.logistics.entity.dos;

import cn.lili.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仓库库存实体
 *
 * @author yourname
 * @since 2023/10/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_warehouse_stock")
@ApiModel(value = "仓库库存")
public class WarehouseStock extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库ID")
    private String warehouseId;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "商品SKU ID")
    private String skuId;

    @ApiModelProperty(value = "库存数量")
    private Integer quantity;

    @ApiModelProperty(value = "可用库存")
    private Integer availableQuantity;

    @ApiModelProperty(value = "锁定库存")
    private Integer lockedQuantity;

    @ApiModelProperty(value = "预警库存")
    private Integer alertQuantity;
}
