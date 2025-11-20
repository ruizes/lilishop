package cn.lili.modules.goods.controller.WebSocket;

import cn.lili.modules.goods.entity.dto.GoodsEditMessage;
import cn.lili.modules.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 商品编辑WebSocket控制器
 *
 * @author yourname
 * @since 2023/10/10
 */
@Controller
public class GoodsEditWebSocketController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 处理商品编辑消息
     *
     * @param message 商品编辑消息
     * @return 商品编辑消息
     */
    @MessageMapping("/goods/edit")
    @SendTo("/topic/goods/edit")
    public GoodsEditMessage handleGoodsEdit(GoodsEditMessage message) {
        // 版本号冲突检测
        Long currentVersion = goodsService.getGoodsVersion(message.getGoodsId());
        if (currentVersion != null && message.getVersion() != null && !currentVersion.equals(message.getVersion() - 1)) {
            // 发生版本冲突
            message.setOperation("conflict");
            message.setValue("版本冲突，请重新编辑");
            return message;
        }
        // 更新商品信息和版本号
        goodsService.updateGoodsField(message.getGoodsId(), message.getField(), message.getValue());
        Long newVersion = goodsService.incrementGoodsVersion(message.getGoodsId());
        message.setVersion(newVersion);
        message.setEditTime(System.currentTimeMillis());
        return message;
    }
}
