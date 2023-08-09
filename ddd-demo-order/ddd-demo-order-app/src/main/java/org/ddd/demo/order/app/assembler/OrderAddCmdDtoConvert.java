package org.ddd.demo.order.app.assembler;

import org.ddd.demo.common.convert.BaseConvert;
import org.ddd.demo.order.domain.add.OrderAddCmd;
import org.ddd.demo.order.client.dto.OrderAddDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TagAddCmdCmd和DTO转换器
 *
 * @author huangjiachang
 */
@Mapper
public interface OrderAddCmdDtoConvert extends
        BaseConvert<OrderAddDTO, OrderAddCmd> {

    OrderAddCmdDtoConvert INSTANCE = Mappers.getMapper(OrderAddCmdDtoConvert.class);
}