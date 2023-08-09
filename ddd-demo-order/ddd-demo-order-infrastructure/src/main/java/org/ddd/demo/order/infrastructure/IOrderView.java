package org.ddd.demo.order.infrastructure;

import org.ddd.demo.order.infrastructure.OrderDO;

/**
 * @author huangjiachang
 */
public interface IOrderView {

    /**
     * id查询
     *
     * @param id id
     * @return OrderDO
     */
    OrderDO getById(Long id);

}
