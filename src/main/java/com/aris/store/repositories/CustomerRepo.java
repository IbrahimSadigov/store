package com.aris.store.repositories;

import com.aris.store.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Optional<Customer> findByName(String s);
}
