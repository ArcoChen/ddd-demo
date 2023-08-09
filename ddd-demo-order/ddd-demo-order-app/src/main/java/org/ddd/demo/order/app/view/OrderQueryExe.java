package org.ddd.demo.order.app.view;

import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.order.client.dto.OrderDTO;
import org.ddd.demo.order.client.query.OrderQuery;
import org.ddd.demo.order.infrastructure.IOrderView;
import org.ddd.demo.order.infrastructure.assembler.OrderDo2DtoConvert;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class OrderQueryExe {

    @Resource
    private IOrderView iOrderView;

    public ResultDTO<OrderDTO> execute(OrderQuery query) {
        OrderDTO orderDTO = OrderDo2DtoConvert.INSTANCE.toDto(iOrderView.getById(query.getId()));
        return ResultDTO.success(orderDTO);
    }
}
