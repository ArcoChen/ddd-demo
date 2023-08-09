package org.ddd.demo.order.domain;

/**
 * @author huangjiachang
 */
public interface OrderRepository {
    /**
     * 保存
     *
     * @param order order
     * @return Order
     */
    Order save(Order order);

    /**
     * update
     *
     * @param order order
     * @return Order
     */
    Order update(Order order);

    /**
     * 根据id获取订单
     * @param id id
     */
    Order getOrderById(Long id);

}
