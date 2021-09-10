package com.aris.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerItem")
public class CustomerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalQuantity;

    private Float totalPrice;

    @Transient
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerItem_id_fk", referencedColumnName = "id")
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

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public CustomerItem setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
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
