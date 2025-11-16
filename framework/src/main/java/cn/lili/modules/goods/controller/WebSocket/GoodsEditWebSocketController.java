package cn.lili.modules.goods.controller.WebSocket;

import cn.lili.modules.goods.entity.dto.GoodsEditMessage;
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

    /**
     * 处理商品编辑消息
     *
     * @param message 商品编辑消息
     * @return 商品编辑消息
     */
    @MessageMapping("/goods/edit")
    @SendTo("/topic/goods/edit")
    public GoodsEditMessage handleGoodsEdit(GoodsEditMessage message) {
        // 可以在这里添加额外的处理逻辑，如权限验证、冲突检测等
        message.setEditTime(System.currentTimeMillis());
        return message;
    }
}
