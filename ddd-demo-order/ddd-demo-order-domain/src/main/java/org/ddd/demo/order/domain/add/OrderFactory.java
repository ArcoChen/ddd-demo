package org.ddd.demo.order.domain.add;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ddd.demo.order.client.enums.OrderStatusEnum;
import org.ddd.demo.order.domain.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 订单聚合 - 聚合工厂
 *
 * @author huangjiachang
 */
@Component
public class OrderFactory {

    public Order getInstance(OrderAddCmd cmd) {
        Order instance = new Order();
        instance.setOrderStatus(OrderStatusEnum.VALID);
        instance.setProducts(cmd.getProducts());
        instance.setDeliveryAddress(cmd.getDeliveryAddress());
        return instance;
    }
}
