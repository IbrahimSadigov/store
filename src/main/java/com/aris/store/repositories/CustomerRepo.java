package com.aris.store.repositories;

import com.aris.store.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Optional<Customer> findByName(String s);

    @Query("SELECT c FROM Customer c WHERE CONCAT(c.name, c.surname, c.email) LIKE %?1%")
    public List<Customer> search(String keyword);
}
