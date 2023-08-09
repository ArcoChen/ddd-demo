package org.ddd.demo.product.app;

import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.product.client.ProductRpcService;
import org.ddd.demo.product.client.dto.ProductAddDTO;
import org.ddd.demo.product.client.dto.ProductDTO;
import org.ddd.demo.product.client.dto.ProductModifyDTO;
import org.ddd.demo.product.client.dto.ProductRemoveDTO;
import org.ddd.demo.product.client.query.ProductQuery;
import org.springframework.stereotype.Service;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
@Service
public class ProductRpcServiceImpl implements ProductRpcService {
    @Override
    public ResultDTO<Long> productAdd(ProductAddDTO dto) {
        return null;
    }

    @Override
    public ResultDTO<Boolean> productModify(ProductModifyDTO dto) {
        return null;
    }

    @Override
    public ResultDTO<Boolean> productRemove(ProductRemoveDTO dto) {
        return null;
    }

    @Override
    public ResultDTO<ProductDTO> productQuery(ProductQuery query) {
        return null;
    }

    @Override
    public ResultDTO<Void> checkProductStatus(Long id) {
        return null;
    }
}
