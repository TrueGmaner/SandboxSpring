package com.gmaner;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cacheable
@org.hibernate.annotations.Cache(region = "person", usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Person {
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person")
    private List<Phone> phoneList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}