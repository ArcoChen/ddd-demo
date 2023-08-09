package org.ddd.demo.product.app;

import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.product.client.InventoryRpcService;
import org.springframework.stereotype.Service;

/**
 * @author huangjiachang
 */
@Service
public class InventoryRpcServiceImpl implements InventoryRpcService {
    @Override
    public ResultDTO<Void> checkInventory(Long productId) {
        return null;
    }
}
