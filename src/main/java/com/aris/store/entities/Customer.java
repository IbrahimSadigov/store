package com.aris.store.entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    @OneToMany(targetEntity = CustomerItem.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerItem> customerItems;

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

    public List<CustomerItem> getCustomerItems() {
        return customerItems;
    }

    public Customer setCustomerItems(List<CustomerItem> customerItems) {
        this.customerItems = customerItems;
        return this;
    }
}
