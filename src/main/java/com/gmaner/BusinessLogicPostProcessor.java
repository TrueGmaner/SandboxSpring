package com.gmaner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogicPostProcessor implements BeanPostProcessor, TestInterface {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("businessLogic")) {
            System.out.println("Bean post processor before init");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("businessLogic")) {
            System.out.println("Bean post processor after init");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}