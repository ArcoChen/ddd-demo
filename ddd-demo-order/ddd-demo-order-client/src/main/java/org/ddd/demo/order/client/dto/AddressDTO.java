package org.ddd.demo.order.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressDTO {
  @ApiModelProperty("省份")
  private String province;

  @ApiModelProperty("城市")
  private String city;

  @ApiModelProperty("地区")
  private String region;

  @ApiModelProperty("详细地址")
  private String detailAddress;
}
