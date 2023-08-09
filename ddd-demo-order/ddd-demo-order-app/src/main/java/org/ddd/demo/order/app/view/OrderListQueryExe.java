package org.ddd.demo.order.app.view;

import org.ddd.demo.common.dto.PageResultDTO;
import org.ddd.demo.order.client.dto.OrderDTO;
import org.ddd.demo.order.client.query.OrderListQuery;
import org.ddd.demo.order.infrastructure.IOrderView;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjiachang
 */
@Component
public class OrderListQueryExe {

    @Resource
    private IOrderView iOrderView;

    public PageResultDTO<List<OrderDTO>> execute(OrderListQuery query) {
        // todo
        return PageResultDTO.success(new ArrayList());
    }
}
