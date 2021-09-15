package com.aris.store.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_item")
public class CustomerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float quantity;

    @ManyToOne(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Item item;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Customer customer;

    public Item getItem() {
        return item;
    }

    public CustomerItem setItem(Item item) {
        this.item = item;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerItem setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CustomerItem() {
    }

    public Long getId() {
        return id;
    }

    public CustomerItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getQuantity() {
        return quantity;
    }

    public CustomerItem setQuantity(Float quantity) {
        this.quantity = quantity;
        return this;
    }


}
