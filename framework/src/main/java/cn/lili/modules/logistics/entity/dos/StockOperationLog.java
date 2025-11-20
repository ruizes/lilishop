package cn.lili.modules.logistics.entity.dos;

import cn.lili.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存操作日志实体
 *
 * @author yourname
 * @since 2023/10/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_stock_operation_log")
@ApiModel(value = "库存操作日志")
public class StockOperationLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库ID")
    private String warehouseId;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "商品SKU ID")
    private String skuId;

    @ApiModelProperty(value = "操作类型")
    private String operationType;

    @ApiModelProperty(value = "操作数量")
    private Integer quantity;

    @ApiModelProperty(value = "操作前数量")
    private Integer beforeQuantity;

    @ApiModelProperty(value = "操作后数量")
    private Integer afterQuantity;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作描述")
    private String description;

    @ApiModelProperty(value = "关联单号")
    private String relationNo;
}
