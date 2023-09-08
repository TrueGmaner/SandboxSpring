package com.gmaner;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(region = "person", usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Phone {
    @Id
    private Long id;

    @Column(name = "number")
    private String number;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

    public Phone() {

    }

    public Phone(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}