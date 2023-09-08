package com.gmaner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void run(String... args) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        person.setId(1L);

        Phone phone = new Phone();
        phone.setId(1L);
        phone.setNumber("8 800 555 35 35");
        phone.setPerson(person);
        person.getPhoneList().add(phone);

        session.persist(person);
        //session.persist(phone);

        transaction.commit();
        session.close();


        System.out.println("Doing doSelect");
        for (int i = 0; i < 5; i++) {
            doSelect(sessionFactory.openSession());
            long queryCacheHitCount = sessionFactory.getStatistics().getSecondLevelCacheHitCount();
            System.out.println("L2 Cache Hit Count: " + queryCacheHitCount);
        }

        System.out.println("Doing doSelectQuery");
        for (int i = 0; i < 5; i++) {
            doSelectQuery(sessionFactory.openSession());
            long queryCacheHitCount = sessionFactory.getStatistics().getQueryCacheHitCount();
            System.out.println("Second Cache Hit Count: " + queryCacheHitCount);
        }
        sessionFactory.close();
    }

    public void doSelectQuery(Session session) {
        var transaction = session.beginTransaction();
        session.createQuery("select p from Person p where p.id = 1")
                .setCacheable(true)
                .setCacheRegion("person2")
                .getSingleResult();
        transaction.commit();
        session.close();
    }

    public void doSelect(Session session) {
        var tx = session.beginTransaction();
        Person p = session.get(Person.class, 1L);
        tx.commit();
    }
}
