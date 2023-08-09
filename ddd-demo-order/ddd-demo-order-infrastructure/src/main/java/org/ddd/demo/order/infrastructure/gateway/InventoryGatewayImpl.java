package org.ddd.demo.order.infrastructure.gateway;

import org.ddd.demo.order.domain.InventoryGateway;
import org.ddd.demo.product.client.InventoryRpcService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */

@Component
public class InventoryGatewayImpl implements InventoryGateway {

    @Resource
    private InventoryRpcService inventoryRpcService;

    @Override
    public void checkInventory(Long productId) {

    }
}
