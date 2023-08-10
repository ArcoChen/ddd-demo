package org.ddd.demo.order.domain.add;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;
import org.ddd.demo.common.event.DomainEventPublisher;
import org.ddd.demo.order.client.dto.ProductDTO;
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

        List<Long> productIds = cmd.getProducts().stream().map(ProductDTO::getId).collect(Collectors.toList());;
        // 校验商品状态
        productGateway.checkProductStatus(productIds);
        // 库存校验
        inventoryGateway.checkInventory(productIds);
        // todo 收货地址校验

        Order order = orderFactory.getInstance(cmd);
        orderRepository.save(order);

        // 创建订单事件发布
        OrderAddCmdEvent orderAddCmdEvent = new OrderAddCmdEvent();
        DomainEventPublisher.getInstance().postSync(orderAddCmdEvent);
        return order.getId();
    }
}
