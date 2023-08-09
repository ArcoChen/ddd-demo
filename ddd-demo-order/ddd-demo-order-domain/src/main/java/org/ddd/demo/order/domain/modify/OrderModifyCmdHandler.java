package org.ddd.demo.order.domain.modify;

import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.domain.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class OrderModifyCmdHandler {

    @Resource
    private OrderRepository orderRepository;


    /**
     * 修改订单
     *
     * @param cmd cmd
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean handle(OrderModifyCmd cmd) {
        Order order = orderRepository.getOrderById(cmd.getId());
        order.modify(cmd);
        orderRepository.update(order);
        return Boolean.TRUE;
    }
}
