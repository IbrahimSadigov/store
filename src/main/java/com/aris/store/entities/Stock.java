package com.aris.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
