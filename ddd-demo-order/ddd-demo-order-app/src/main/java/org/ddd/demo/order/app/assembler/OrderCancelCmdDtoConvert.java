package org.ddd.demo.order.app.assembler;



import org.ddd.demo.common.convert.BaseConvert;
import org.ddd.demo.order.domain.cancel.OrderCancelCmd;
import org.ddd.demo.order.client.dto.OrderCancelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TagRemoveCmd和DTO转换器
 *
 * @author huangjiachang
 */
@Mapper
public interface OrderCancelCmdDtoConvert extends
        BaseConvert<OrderCancelDTO, OrderCancelCmd> {

    OrderCancelCmdDtoConvert INSTANCE = Mappers.getMapper(OrderCancelCmdDtoConvert.class);
}