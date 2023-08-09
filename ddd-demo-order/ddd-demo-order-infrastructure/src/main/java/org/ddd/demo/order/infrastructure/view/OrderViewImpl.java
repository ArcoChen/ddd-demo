package org.ddd.demo.order.infrastructure.view;

import org.ddd.demo.common.baseDao.AbstractDao;
import org.ddd.demo.order.infrastructure.IOrderView;
import org.ddd.demo.order.infrastructure.OrderDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class OrderViewImpl  extends AbstractDao<OrderViewMapper, OrderDO> implements IOrderView {

    @Resource
    private OrderViewMapper orderViewMapper;

    @Override
    public OrderDO getById(Long id) {
        return orderViewMapper.selectById(id);
    }
}
