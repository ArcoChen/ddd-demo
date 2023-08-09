package org.ddd.demo.order.adapter.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.order.client.OrderRpcService;
import org.ddd.demo.order.client.dto.OrderAddDTO;
import org.ddd.demo.order.client.dto.OrderCancelDTO;
import org.ddd.demo.order.client.dto.OrderModifyDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@RestController
@RequestMapping("/web/order")
@Api(value = "/web/order", tags = "web - 订单聚合")
public class OrderController {

    @Resource
    private OrderRpcService orderRpcService;

    @ApiOperation("创建订单")
    @PostMapping("/order-add")
    public ResultDTO<Long> orderAdd(@RequestBody @Validated OrderAddDTO dto) {
        return orderRpcService.orderAdd(dto);
    }

    @ApiOperation("修改订单")
    @PostMapping("/order-modify")
    public ResultDTO<Boolean> orderModify(@RequestBody @Validated OrderModifyDTO dto) {
        return orderRpcService.orderModify(dto);
    }

    @ApiOperation("修改订单")
    @PostMapping("/order-cancel")
    public ResultDTO<Boolean> orderCancel(@RequestBody @Validated OrderCancelDTO dto) {
        return orderRpcService.orderCancel(dto);
    }
}
