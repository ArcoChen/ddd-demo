package org.ddd.demo.product.client;

import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.product.client.dto.ProductAddDTO;
import org.ddd.demo.product.client.dto.ProductDTO;
import org.ddd.demo.product.client.dto.ProductModifyDTO;
import org.ddd.demo.product.client.dto.ProductRemoveDTO;
import org.ddd.demo.product.client.query.ProductQuery;

/**
 * 商品聚合  - RPC能力接口
 *
 * @author huangjiachang
 */
public interface ProductRpcService {

    /**
     * 商品添加
     *
     * @param dto dto
     * @return boolean
     */
    ResultDTO<Long> productAdd(ProductAddDTO dto);

    /**
     * 商品修改
     *
     * @param dto dto
     * @return boolean
     */
    ResultDTO<Boolean> productModify(ProductModifyDTO dto);

    /**
     * 商品删除
     *
     * @param dto dto
     * @return boolean
     */
    ResultDTO<Boolean> productRemove(ProductRemoveDTO dto);

    /**
     * 商品查询
     *
     * @param query query
     * @return
     */
    ResultDTO<ProductDTO> productQuery(ProductQuery query);

    /**
     * 校验商品状态
     *
     * @param id id
     * @return
     */
    ResultDTO<Void> checkProductStatus(Long id);
}
