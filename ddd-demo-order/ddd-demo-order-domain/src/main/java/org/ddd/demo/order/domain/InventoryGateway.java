package org.ddd.demo.order.domain;

import java.util.List;

/**
 * 库存防腐层
 *
 * @author huangjiachang
 */
public interface InventoryGateway {

    /**
     * 校验库存
     * @param productId 商品id
     */
    void checkInventory(Long productId);

    /**
     * 校验库存
     * @param productIds 商品id
     */
    void checkInventory(List<Long> productIds);
}
