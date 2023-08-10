package org.ddd.demo.order.domain.cancel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ddd.demo.common.event.BaseDomainEvent;

/**
 * @author huangjiachang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCancelCmdEvent extends BaseDomainEvent {

}
