package com.aris.store.entities;

import javax.persistence.Transient;
import java.util.List;

public class Stock {

    private Long id;

    private Long itemQuantity;

    @Transient
    private List<Item> items;

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public Stock setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public Stock setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public Stock setItems(List<Item> items) {
        this.items = items;
        return this;
    }
}
