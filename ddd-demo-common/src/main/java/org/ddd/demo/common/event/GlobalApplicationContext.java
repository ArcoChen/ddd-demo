package org.ddd.demo.common.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author huangjiachang
 */
@Component
public class GlobalApplicationContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public GlobalApplicationContext() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (GlobalApplicationContext.applicationContext == null) {
            GlobalApplicationContext.applicationContext = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        ApplicationContext applicationContext = getApplicationContext();
        return applicationContext == null ? null : applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        ApplicationContext applicationContext = getApplicationContext();
        return applicationContext == null ? null : applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        ApplicationContext applicationContext = getApplicationContext();
        return applicationContext == null ? null : applicationContext.getBean(name, clazz);
    }
}
