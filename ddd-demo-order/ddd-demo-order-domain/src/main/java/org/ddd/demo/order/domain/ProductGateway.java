package org.ddd.demo.order.domain;

/**
 * 商品防腐层
 *
 * @author huangjiachang
 * @date 2023/8/9
 */
public interface ProductGateway {

    /**
     * 校验商品状态
     * @param id 商品id
     */
    void checkProductStatus(Long id);
}
