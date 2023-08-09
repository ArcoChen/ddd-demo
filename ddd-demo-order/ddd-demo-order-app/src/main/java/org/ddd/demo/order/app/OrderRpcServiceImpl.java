package org.ddd.demo.order.app;

import org.ddd.demo.common.dto.PageResultDTO;
import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.order.app.assembler.OrderAddCmdDtoConvert;
import org.ddd.demo.order.app.assembler.OrderCancelCmdDtoConvert;
import org.ddd.demo.order.app.assembler.OrderModifyCmdDtoConvert;
import org.ddd.demo.order.app.view.OrderListQueryExe;
import org.ddd.demo.order.app.view.OrderQueryExe;
import org.ddd.demo.order.client.OrderRpcService;
import org.ddd.demo.order.domain.add.OrderAddCmd;
import org.ddd.demo.order.domain.add.OrderAddCmdHandler;
import org.ddd.demo.order.client.dto.OrderAddDTO;
import org.ddd.demo.order.client.dto.OrderCancelDTO;
import org.ddd.demo.order.client.dto.OrderDTO;
import org.ddd.demo.order.client.dto.OrderModifyDTO;
import org.ddd.demo.order.client.query.OrderListQuery;
import org.ddd.demo.order.client.query.OrderQuery;
import org.ddd.demo.order.domain.cancel.OrderCancelCmd;
import org.ddd.demo.order.domain.cancel.OrderCancelCmdHandler;
import org.ddd.demo.order.domain.modify.OrderModifyCmd;
import org.ddd.demo.order.domain.modify.OrderModifyCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangjiachang
 */
@Service
public class OrderRpcServiceImpl implements OrderRpcService {

    @Resource
    private OrderAddCmdHandler orderAddCmdHandler;

    @Resource
    private OrderModifyCmdHandler orderModifyCmdHandler;

    @Resource
    private OrderCancelCmdHandler orderCancelCmdHandler;

    @Resource
    private OrderQueryExe orderQueryExe;

    @Resource
    private OrderListQueryExe orderListQueryExe;

    @Override
    public ResultDTO<Long> orderAdd(OrderAddDTO dto) {
        OrderAddCmd orderAddCmd = OrderAddCmdDtoConvert.INSTANCE.dto2Do(dto);
        return ResultDTO.success(orderAddCmdHandler.handle(orderAddCmd));
    }

    @Override
    public ResultDTO<Boolean> orderModify(OrderModifyDTO dto) {
        OrderModifyCmd orderModifyCmd = OrderModifyCmdDtoConvert.INSTANCE.dto2Do(dto);
        return ResultDTO.success(orderModifyCmdHandler.handle(orderModifyCmd));
    }

    @Override
    public ResultDTO<Boolean> orderCancel(OrderCancelDTO dto) {
        OrderCancelCmd orderCancelCmd = OrderCancelCmdDtoConvert.INSTANCE.dto2Do(dto);
        return ResultDTO.success(orderCancelCmdHandler.handle(orderCancelCmd));
    }

    @Override
    public ResultDTO<OrderDTO> orderQuery(OrderQuery query) {
        return orderQueryExe.execute(query);
    }

    @Override
    public PageResultDTO<List<OrderDTO>> orderListQuery(OrderListQuery query) {
        return orderListQueryExe.execute(query);
    }
}
