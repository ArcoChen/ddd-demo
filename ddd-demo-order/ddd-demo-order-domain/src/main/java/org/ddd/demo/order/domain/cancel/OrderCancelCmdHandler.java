package org.ddd.demo.order.domain.cancel;

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
        order.cancel();
        orderRepository.update(order);
        return Boolean.TRUE;
    }
}
