package com.aris.store.daos;


import com.aris.store.entities.CustomerItem;
import com.aris.store.repositories.CustomerItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerItemDao {

    @Autowired
    CustomerItemRepo customerItemRepo;

    public String insert(CustomerItem customerItem){
        customerItemRepo.save(customerItem);
        return "Item inserted Customer List.";
    }

    public List<CustomerItem> selectAll(){
        return (List<CustomerItem>) customerItemRepo.findAll();
    }

    public void delete(Long customerItemId){
        if(!customerItemRepo.existsById(customerItemId)){
            throw new RuntimeException("Item you want to delete is not in List!");
        }
        customerItemRepo.deleteById(customerItemId);
    }

    @Transactional
    public CustomerItem update(CustomerItem customerItem){
        Optional<CustomerItem> oldCustomerItem = customerItemRepo.findById(customerItem.getId());
        if (oldCustomerItem.isPresent()){
            oldCustomerItem.get().setTotalPrice(customerItem.getTotalPrice()).setItems(customerItem.getItems());
            return customerItemRepo.save(oldCustomerItem.get());
        }
        else throw new RuntimeException("There is no List");
    }

}
