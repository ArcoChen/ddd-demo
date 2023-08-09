package org.ddd.demo.common.event;

import org.ddd.demo.common.exception.DemoException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class DomainEventPublisher {
    private static DomainEventPublisher instance;

    @Resource
    private AbstractDomainEventSupport domainEventSupport;

    public DomainEventPublisher() {
    }

    public static DomainEventPublisher getInstance() {
        if (instance == null) {
            instance = (DomainEventPublisher)GlobalApplicationContext.getBean(DomainEventPublisher.class);
            if (instance == null) {
                throw new DemoException("DomainEventPublisher未实例化");
            }
        }

        return instance;
    }

    public void postSync(BaseDomainEvent event) {
        this.domainEventSupport.publish(event);
    }

}
