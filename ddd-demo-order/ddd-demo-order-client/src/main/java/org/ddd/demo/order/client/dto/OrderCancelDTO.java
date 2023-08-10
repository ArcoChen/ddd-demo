package org.ddd.demo.order.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangjiachang
 */
@Data
public class OrderCancelDTO {

  @ApiModelProperty("id")
  private Long id;
}
