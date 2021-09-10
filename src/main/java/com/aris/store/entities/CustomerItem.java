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

    private Long stockId;

    private Long customerId;

    @Transient
    private List<Stock> stocks;

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

    public Long getStockId() {
        return stockId;
    }

    public CustomerItem setStockId(Long stockId) {
        this.stockId = stockId;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public CustomerItem setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public CustomerItem setStocks(List<Stock> stocks) {
        this.stocks = stocks;
        return this;
    }
}
