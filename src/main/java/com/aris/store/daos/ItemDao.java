package com.aris.store.daos;

import com.aris.store.entities.Item;
import com.aris.store.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDao {

    @Autowired
    ItemRepo itemRepo;

    public String add(Item item) {
        itemRepo.save(item);
        return "Item successfully added.";
    }

    public List<Item> allItem() {
        return (List<Item>) itemRepo.findAll();
    }

    public void delete(Long itemID){
        if (!itemRepo.existsById(itemID)){
            throw new RuntimeException("ID you want to delete does not exist");
        }
        itemRepo.deleteById(itemID);
    }

//    public List<Item> selectAllBy() {
//        int page = 5;
//        int limit = 30;
//
//        Pageable pageable = PageRequest.of(page, limit);
//
//        Page<Item> dataList = itemRepo.findAll(pageable);
//
//        return dataList.getContent();
//    }


    public Item uptade(Item item){
        Optional<Item> uptadedItem = itemRepo.findById(item.getId());
        if (uptadedItem.isPresent()){
            uptadedItem.get().setName(item.getName()).setBarcode(item.getBarcode()).setPrice(item.getPrice());
            return itemRepo.save(uptadedItem.get());
        }
        else throw new RuntimeException("There is no Customer like "+ item.getName()+ "!");

    }



}
