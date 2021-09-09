package com.aris.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String barcode;

    private Float price;

    private Long stokeId;

    public Long getStokeId() {
        return stokeId;
    }

    public Item setStokeId(Long stokeId) {
        this.stokeId = stokeId;
        return this;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public Item setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Item setPrice(Float price) {
        this.price = price;
        return this;
    }
}
