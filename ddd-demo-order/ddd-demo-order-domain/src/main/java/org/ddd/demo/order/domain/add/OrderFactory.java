package org.ddd.demo.order.domain.add;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ddd.demo.order.domain.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author huangjiachang
 */
@Component
public class OrderFactory {
    public Order getInstance(OrderAddCmd cmd) {
        Order instance = new Order();
        return instance;
    }
}
