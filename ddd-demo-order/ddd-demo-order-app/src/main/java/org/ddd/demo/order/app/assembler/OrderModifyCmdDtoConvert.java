package org.ddd.demo.order.app.assembler;


import org.ddd.demo.common.convert.BaseConvert;
import org.ddd.demo.order.domain.modify.OrderModifyCmd;
import org.ddd.demo.order.client.dto.OrderModifyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TagModifyCmd和DTO转换器
 *
 * @author huangjiachang
 */
@Mapper
public interface OrderModifyCmdDtoConvert extends
        BaseConvert<OrderModifyDTO, OrderModifyCmd> {

    OrderModifyCmdDtoConvert INSTANCE = Mappers.getMapper(OrderModifyCmdDtoConvert.class);
}