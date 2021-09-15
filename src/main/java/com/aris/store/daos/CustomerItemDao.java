package com.aris.store.daos;


import com.aris.store.entities.CustomerItem;
import com.aris.store.repositories.CustomerItemRepo;
import com.aris.store.repositories.CustomerRepo;
import com.aris.store.repositories.ItemRepo;
import com.aris.store.repositories.ViewStoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerItemDao {

    @Autowired
    CustomerItemRepo customerItemRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ViewStoreRepo view_storeRepo;

    public String insert(CustomerItem customerItem){
        customerItemRepo.save(customerItem
                .setCustomer(customerRepo.findById(customerItem.getCustomer().getId()).orElse(null)).setItem(itemRepo.findById(customerItem.getItem().getId()).orElse(null)));
        return "Item inserted Customer List.";
    }

    public List<CustomerItem> selectAll(){
        return (List<CustomerItem>) customerItemRepo.findAll();
    }

    public String delete(Long customerItemId){
        if(!customerItemRepo.existsById(customerItemId)){
            throw new RuntimeException("Item you want to delete is not in List!");
        }
        customerItemRepo.deleteById(customerItemId);
        return "customerItem deleted successfully";
    }

    @Transactional
    public CustomerItem update(CustomerItem customerItem){
        Optional<CustomerItem> oldCustomerItem = customerItemRepo.findById(customerItem.getId());
        if (oldCustomerItem.isPresent()){
            oldCustomerItem.get().setQuantity(customerItem.getQuantity());
            return customerItemRepo.save(oldCustomerItem.get());
        }
        else throw new RuntimeException("There is no List");
    }

}
