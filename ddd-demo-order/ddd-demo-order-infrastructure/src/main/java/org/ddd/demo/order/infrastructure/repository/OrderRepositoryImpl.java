package org.ddd.demo.order.infrastructure.repository;

import org.ddd.demo.common.baseDao.AbstractDao;
import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.domain.OrderRepository;
import org.ddd.demo.order.infrastructure.OrderDO;
import org.ddd.demo.order.infrastructure.assembler.OrderDoConvert;
import org.springframework.stereotype.Component;

/**
 * @author huangjiachang
 */
@Component
public class OrderRepositoryImpl extends AbstractDao<OrderMapper, OrderDO> implements OrderRepository {
    @Override
    public Order save(Order order) {
        OrderDO orderDO = OrderDoConvert.INSTANCE.dto2Do(order);
        super.save(orderDO);
        return OrderDoConvert.INSTANCE.do2Dto(orderDO);
    }

    @Override
    public Order update(Order order) {
        OrderDO tagDO = OrderDoConvert.INSTANCE.dto2Do(order);
        super.updateById(tagDO);
        return OrderDoConvert.INSTANCE.do2Dto(tagDO);
    }

    @Override
    public Order getOrderById(Long id) {
        return OrderDoConvert.INSTANCE.do2Dto(super.getById(id));
    }
}
