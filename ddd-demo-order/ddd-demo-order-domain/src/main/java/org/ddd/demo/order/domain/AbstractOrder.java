package org.ddd.demo.order.domain;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import org.ddd.demo.order.client.dto.AddressDTO;
import org.ddd.demo.order.client.dto.ProductDTO;
import org.ddd.demo.order.client.enums.OrderStatusEnum;
import org.ddd.demo.order.domain.modify.OrderModifyCmd;

/**
 * @author huangjiachang
 */
@Data
public abstract class AbstractOrder {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 商品列表
     */
    List<ProductDTO> products;

    /**
     * 收件人地址
     */
    AddressDTO deliveryAddress;

    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;


    /**
     * 修改订单
     * @param cmd cmd
     */
    public abstract void modify(OrderModifyCmd cmd);

    /**
     * 取消订单
     */
    public abstract void cancel();


    /**
     * 订单类型校验
     */
    public abstract void validateStatus();
}
