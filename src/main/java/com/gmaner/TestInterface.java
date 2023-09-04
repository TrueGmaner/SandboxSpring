package com.gmaner;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

public interface TestInterface {
    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestInteface");
        return bean;
    }

    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestInteface");
        return bean;
    }
}