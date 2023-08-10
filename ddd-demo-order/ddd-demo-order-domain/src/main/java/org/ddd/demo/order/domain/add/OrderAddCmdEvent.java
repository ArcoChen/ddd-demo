package org.ddd.demo.order.domain.add;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ddd.demo.common.event.BaseDomainEvent;
import org.ddd.demo.order.client.dto.AddressDTO;
import org.ddd.demo.order.client.dto.ProductDTO;

/**
 * @author huangjiachang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderAddCmdEvent extends BaseDomainEvent {
  @ApiModelProperty("商品列表")
  List<ProductDTO> products;

  @ApiModelProperty("收件人地址")
  AddressDTO deliveryAddress;
}
