package com.aris.store.entities;

public class OrderRequest {

    private Customer customer;

    public OrderRequest() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderRequest setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
