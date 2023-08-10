package org.ddd.demo.order.domain.cancel;

import org.ddd.demo.common.exception.DemoException;
import org.ddd.demo.order.client.enums.OrderStatusEnum;
import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.domain.OrderRepository;
import org.ddd.demo.order.domain.modify.OrderModifyCmd;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
@Component
public class OrderCancelCmdHandler {

    @Resource
    private OrderRepository orderRepository;

    /**
     * 取消订单
     *
     * @param cmd cmd
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean handle(OrderCancelCmd cmd) {
        Order order = orderRepository.getOrderById(cmd.getId());

        // 订单状态校验
        if(!OrderStatusEnum.VALID.equals(order.getOrderStatus())){
            throw new DemoException("订单已取消过，不可再次取消");
        }
        // todo 订单超时校验

        // 订单取消
        order.cancel();
        orderRepository.update(order);

        // 订单取消，无需发送事件，不进行消息推送
        return Boolean.TRUE;
    }
}
