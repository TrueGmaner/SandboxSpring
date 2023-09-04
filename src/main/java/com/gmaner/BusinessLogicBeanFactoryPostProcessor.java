package com.gmaner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogicBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition businessLogic = configurableListableBeanFactory.getBeanDefinition("businessLogic2");
        System.out.println("I am BFPP");
        System.out.println(businessLogic.getScope());
        businessLogic.setScope("singleton");
        System.out.println(businessLogic.getScope());
    }
}