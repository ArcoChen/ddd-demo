package org.ddd.demo.product.client;

import org.ddd.demo.common.dto.ResultDTO;

/**
 * 库存聚合  - RPC能力接口
 *
 * @author huangjiachang
 */
public interface InventoryRpcService {

    /**
     * 校验库存
     * @param productId 商品id
     */
    ResultDTO<Void> checkInventory(Long productId);
}
