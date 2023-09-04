package com.gmaner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gmaner")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}