package org.ddd.demo.order.client;

import org.ddd.demo.common.dto.PageResultDTO;
import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.order.client.dto.OrderAddDTO;
import org.ddd.demo.order.client.dto.OrderCancelDTO;
import org.ddd.demo.order.client.dto.OrderDTO;
import org.ddd.demo.order.client.dto.OrderModifyDTO;
import org.ddd.demo.order.client.query.OrderQuery;
import org.ddd.demo.order.client.query.OrderListQuery;

import java.util.List;

/**
 * 商订单聚合 - 聚合根 - RPC能力接口
 *
 * @author huangjiachang
 */
public interface OrderRpcService {
    /**
     * 订单添加
     *
     * @param dto dto
     * @return Long
     */
    ResultDTO<Long> orderAdd(OrderAddDTO dto);

    /**
     * 订单修改
     *
     * @param dto dto
     * @return boolean
     */
    ResultDTO<Boolean> orderModify(OrderModifyDTO dto);

    /**
     * 订单取消
     *
     * @param dto dto
     * @return boolean
     */
    ResultDTO<Boolean> orderCancel(OrderCancelDTO dto);

    /**
     * 订单查询
     *
     * @param query query
     * @return ResultDTO<OrderDTO>
     */
    ResultDTO<OrderDTO> orderQuery(OrderQuery query);

    /**
     * 订单列表查询
     *
     * @param query query
     * @return PageResultDTO<List < OrderDTO>>
     */
    PageResultDTO<List<OrderDTO>> orderListQuery(OrderListQuery query);
}
