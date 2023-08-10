package org.ddd.demo.order.client.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author huangjiachang
 */
@Data
public class OrderAddDTO implements Serializable {

  @ApiModelProperty("商品列表")
  List<ProductDTO> products;

  @ApiModelProperty("收件人地址")
  AddressDTO deliveryAddress;



}
