package org.ddd.demo.common.event;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public abstract class AbstractDomainEventSupport {
    public AbstractDomainEventSupport() {
    }

    public abstract void publish(BaseDomainEvent var1);

}
