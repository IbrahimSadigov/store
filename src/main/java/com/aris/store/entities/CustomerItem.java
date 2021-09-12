package com.aris.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_item")
public class CustomerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float totalPrice;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_item_id_fk", referencedColumnName = "id")
    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public CustomerItem setItems(List<Item> items) {
        this.items = items;
        return this;
    }
}
