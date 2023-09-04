package com.gmaner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    @Qualifier("businessLogic2")
    private BusinessLogic businessLogic;

    @Override
    public void run(String... args) throws Exception {
        businessLogic.method();
        businessLogic.method2();
        Book book = new Book();
        book.getId();

        var thread = new Thread(() -> {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        thread.start();
        thread.join();
    }
}