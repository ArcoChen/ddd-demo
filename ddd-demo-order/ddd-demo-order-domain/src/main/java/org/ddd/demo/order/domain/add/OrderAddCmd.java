package org.ddd.demo.order.domain.add;

import lombok.Data;

/**
 * @author huangjiachang
 */
@Data
public class OrderAddCmd {

    private Long id;

    private Long productId;
}
