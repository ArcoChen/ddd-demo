package org.ddd.demo.product.app.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ddd.demo.common.dto.ResultDTO;
import org.ddd.demo.product.client.ProductRpcService;
import org.ddd.demo.product.client.dto.ProductAddDTO;
import org.ddd.demo.product.client.dto.ProductModifyDTO;
import org.ddd.demo.product.client.dto.ProductRemoveDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 * @date 2023/8/8
 */
@RestController
@RequestMapping("/web/product")
@Api(value = "/web/product", tags = "web - 商品聚合")
public class ProductController {

    @Resource
    private ProductRpcService productRpcService;

    @ApiOperation("添加商品")
    @PostMapping("/product-add")
    public ResultDTO<Long> productAdd(@RequestBody @Validated ProductAddDTO dto) {
        return productRpcService.productAdd(dto);
    }

    @ApiOperation("修改商品")
    @PostMapping("/product-modify")
    public ResultDTO<Boolean> productModify(@RequestBody @Validated ProductModifyDTO dto) {
        return productRpcService.productModify(dto);
    }

    @ApiOperation("删除商品")
    @PostMapping("/product-remove")
    public ResultDTO<Boolean> productRemove(@RequestBody @Validated ProductRemoveDTO dto) {
        return productRpcService.productRemove(dto);
    }
}
