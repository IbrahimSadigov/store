package com.aris.store.repositories;

import com.aris.store.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
