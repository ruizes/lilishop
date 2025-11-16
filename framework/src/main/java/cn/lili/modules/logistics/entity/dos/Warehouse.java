package cn.lili.modules.logistics.entity.dos;

import cn.lili.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仓库实体
 *
 * @author yourname
 * @since 2023/10/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_warehouse")
@ApiModel(value = "仓库")
public class Warehouse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库名称")
    private String name;

    @ApiModelProperty(value = "仓库编码")
    private String code;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区/县")
    private String district;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "是否默认仓库")
    private Boolean defaultWarehouse;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "仓库类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String remark;
}
