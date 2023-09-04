package com.gmaner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import javax.annotation.Priority;

@Configuration
public class BeanConfiguration {
    @Bean(name = "businessLogic")
    @Scope(scopeName = "singleton")
    public BusinessLogic getBusinessLogic() {
        return new BusinessLogic(1L, "German Kostya");
    }

    @Bean(name = "businessLogic2")
    @Scope(scopeName = "singleton")
    //@Primary
    public BusinessLogic getBusinessLogic2() {
        return new BusinessLogic(2L, "Ivan Ivanov");
    }
}