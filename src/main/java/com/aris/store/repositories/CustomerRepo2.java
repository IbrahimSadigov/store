package com.aris.store.repositories;

import com.aris.store.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo2 extends JpaRepository<Customer, Long> {
    List<Customer> search(String keyword);
}
