package com.aris.store.repositories;

import com.aris.store.entities.CustomerItem;
import org.springframework.data.repository.CrudRepository;

public interface CustomerItemRepo extends CrudRepository<CustomerItem, Long> {
}
