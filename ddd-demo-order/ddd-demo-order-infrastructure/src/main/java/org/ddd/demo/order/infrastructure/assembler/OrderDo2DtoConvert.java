package org.ddd.demo.order.infrastructure.assembler;

import com.github.pagehelper.PageInfo;
import org.ddd.demo.order.client.dto.OrderDTO;
import org.ddd.demo.order.infrastructure.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author huangjiachang
 */
@Mapper
public interface OrderDo2DtoConvert {
    OrderDo2DtoConvert INSTANCE = Mappers.getMapper(OrderDo2DtoConvert.class);

    /**
     * toDto
     *
     * @param orderDO orderDO
     * @return MetadataDTO
     */
    OrderDTO toDto(OrderDO orderDO);


    /**
     * toDto
     *
     * @param orders orders
     * @return MetadataDTO
     */
    List<OrderDTO> toDtoList(List<OrderDO> orders);

    /**
     * 转分页
     *
     * @param orders orders
     * @return PageInfo<OrderDTO>
     */
    PageInfo<OrderDTO> toDtoList(PageInfo<OrderDO> orders);
}
