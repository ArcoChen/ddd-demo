package org.ddd.demo.order.infrastructure.assembler;

import org.ddd.demo.order.domain.Order;
import org.ddd.demo.order.infrastructure.BaseConvert;
import org.ddd.demo.order.infrastructure.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author huangjiachang
 */
@Mapper
public interface OrderDoConvert extends BaseConvert<Order, OrderDO> {
    OrderDoConvert INSTANCE = Mappers.getMapper(OrderDoConvert.class);
}
