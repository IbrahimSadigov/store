package com.aris.store.repositories;

import com.aris.store.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepo extends CrudRepository<Stock, Long> {
}
