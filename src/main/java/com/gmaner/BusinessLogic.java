package com.gmaner;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope(scopeName = "prototype")
public class BusinessLogic {
    private final long id;
    private final String name;
    public BusinessLogic(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public void method() {
        System.out.println("Method1 " + id + " " + name);
    }

    public void method2() {
        System.out.println("Method2 " + id + " " + name);
    }

    @PostConstruct
    public void iAmPostConstructMethod() {
        System.out.println("Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }
}