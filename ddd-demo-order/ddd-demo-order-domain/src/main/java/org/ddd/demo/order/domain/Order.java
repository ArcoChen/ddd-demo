package org.ddd.demo.order.domain;

import org.ddd.demo.order.client.enums.OrderStatusEnum;
import org.ddd.demo.order.domain.modify.OrderModifyCmd;

/**
 * @author huangjiachang
 */
public class Order extends AbstractOrder {

    @Override
    public void modify(OrderModifyCmd cmd) {

    }

    @Override
    public void cancel() {
        this.setOrderStatus(OrderStatusEnum.CANCEL);
    }



    @Override
    public void validateStatus() {

    }
}
