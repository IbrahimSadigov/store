package com.aris.store.entities;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "view_store")
public class ViewStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    private Long id_customer;

    private String customer_name;

    private String customer_surname;

    private Float quantity;

    private Long id_item;

    private String item_name;

    private Long item_price;


    public ViewStore() {
    }

    public Long getId() {
        return id;
    }

    public ViewStore setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public ViewStore setId_customer(Long id_customer) {
        this.id_customer = id_customer;
        return this;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public ViewStore setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
        return this;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public ViewStore setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
        return this;
    }

    public Float getQuantity() {
        return quantity;
    }

    public ViewStore setQuantity(Float quantity) {
        this.quantity = quantity;
        return this;
    }

    public Long getId_item() {
        return id_item;
    }

    public ViewStore setId_item(Long id_item) {
        this.id_item = id_item;
        return this;
    }

    public String getItem_name() {
        return item_name;
    }

    public ViewStore setItem_name(String item_name) {
        this.item_name = item_name;
        return this;
    }

    public Long getItem_price() {
        return item_price;
    }

    public ViewStore setItem_price(Long item_price) {
        this.item_price = item_price;
        return this;
    }
}
