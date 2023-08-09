package org.ddd.demo.common.event;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangjiachang
 */
@Component
public class KafkaDomainEventSupportImpl extends AbstractDomainEventSupport{

    public KafkaDomainEventSupportImpl() {
    }

    @Override
    public void publish(BaseDomainEvent event) {
        //todo
    }

}
