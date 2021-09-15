package com.aris.store.entities;


import org.hibernate.annotations.Where;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
@Where(clause = "deleted = false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;


    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public Customer setId(Long customer_id) {
        this.id = customer_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }


}
