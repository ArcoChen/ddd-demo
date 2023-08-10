package org.ddd.demo.order.client.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductDTO implements Serializable {

  @ApiModelProperty("id")
  private Long id;

  @ApiModelProperty("商品名称")
  private String productName;

  @ApiModelProperty("商品描述")
  private String productDescription;

  @ApiModelProperty("单价")
  private BigDecimal univalent;

  @ApiModelProperty("商品数量")
  private Integer productNum;

}
