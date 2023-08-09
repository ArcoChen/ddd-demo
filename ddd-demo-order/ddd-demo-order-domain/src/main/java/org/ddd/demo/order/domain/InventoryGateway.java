package org.ddd.demo.order.domain;

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
}
