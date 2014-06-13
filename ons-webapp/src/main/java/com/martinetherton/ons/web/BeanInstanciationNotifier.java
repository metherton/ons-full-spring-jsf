package com.martinetherton.ons.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BeanInstanciationNotifier implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        // TODO Auto-generated method stub
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("Bean: " + beanName + " created: " + bean.toString());
        return bean;
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

}
