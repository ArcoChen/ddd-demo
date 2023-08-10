package org.ddd.demo.order.domain.modify;

import org.ddd.demo.common.event.DomainEventPublisher;
import org.ddd.demo.order.domain.InventoryGateway;
import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.domain.OrderRepository;
import org.ddd.demo.order.domain.ProductGateway;
import org.ddd.demo.order.domain.add.OrderAddCmdEvent;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class OrderModifyCmdHandler {
    @Resource
    private ProductGateway productGateway;

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
        // 商品状态校验
        productGateway.checkProductStatus(cmd.getId());

        // todo 收货地址校验

        order.modify(cmd);
        orderRepository.update(order);

        // 修改订单事件发布
        OrderModifyCmdEvent orderModifyCmdEvent = new OrderModifyCmdEvent();
        DomainEventPublisher.getInstance().postSync(orderModifyCmdEvent);
        return Boolean.TRUE;
    }
}
