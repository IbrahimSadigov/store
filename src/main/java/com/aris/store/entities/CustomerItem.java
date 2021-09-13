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

    private Float totalPrice;

//    @OneToMany(targetEntity = Item.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_item_id_fk", referencedColumnName = "id")
//    private List<Item> items;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Customer customer;

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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public CustomerItem setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }


}
