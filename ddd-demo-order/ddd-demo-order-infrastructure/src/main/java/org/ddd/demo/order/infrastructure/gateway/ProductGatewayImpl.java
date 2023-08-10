package org.ddd.demo.order.infrastructure.gateway;

import java.util.List;
import org.ddd.demo.order.domain.ProductGateway;
import org.ddd.demo.product.client.ProductRpcService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class ProductGatewayImpl implements ProductGateway {

    @Resource
    private ProductRpcService productRpcService;

    @Override
    public void checkProductStatus(Long id) {
         productRpcService.checkProductStatus(id);
    }

    @Override
    public void checkProductStatus(List<Long> ids) {

    }
}
