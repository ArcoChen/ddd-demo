package org.ddd.demo.order.domain.add;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ddd.demo.common.event.DomainEventPublisher;
import org.ddd.demo.order.domain.InventoryGateway;
import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.domain.OrderRepository;
import org.ddd.demo.order.domain.ProductGateway;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class OrderAddCmdHandler {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private ProductGateway productGateway;

    @Resource
    private InventoryGateway inventoryGateway;

    @Resource
    private OrderFactory orderFactory;


    /**
     * 创建订单
     *
     * @param cmd cmd
     */
    @Transactional(rollbackFor = Exception.class)
    public Long handle(OrderAddCmd cmd) {
        // 校验商品状态
        productGateway.checkProductStatus(cmd.getProductId());
        // 库存校验
        inventoryGateway.checkInventory(cmd.getProductId());

        Order order = orderFactory.getInstance(cmd);
        orderRepository.save(order);

        // 创建订单事件发布
        OrderAddCmdEvent orderAddCmdEvent = new OrderAddCmdEvent();
        DomainEventPublisher.getInstance().postSync(orderAddCmdEvent);
        return order.getId();
    }
}
