package com.aris.store.repositories;

import com.aris.store.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {

    List<Item> findAll();
    Page<Item> findAll(Pageable pageable);

}
