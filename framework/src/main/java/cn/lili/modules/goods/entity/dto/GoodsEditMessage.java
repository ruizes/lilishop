package cn.lili.modules.goods.entity.dto;

import lombok.Data;

/**
 * 商品编辑实时消息
 *
 * @author yourname
 * @since 2023/10/10
 */
@Data
public class GoodsEditMessage {

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 字段名
     */
    private String field;

    /**
     * 新值
     */
    private Object value;

    /**
     * 编辑人ID
     */
    private String editorId;

    /**
     * 编辑人名称
     */
    private String editorName;

    /**
     * 编辑时间
     */
    private Long editTime;

    /**
     * 操作类型：update/delete/insert
     */
    private String operation;
}
