package com.aris.store.apis;

import com.aris.store.daos.CustomerItemDao;
import com.aris.store.entities.CustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerItem")
public class CustomerItemApi {

    @Autowired
    CustomerItemDao customerItemDao;

    @PostMapping("/add")
    public String add(@RequestBody CustomerItem customerItem){
        return customerItemDao.add(customerItem);
    }

    @GetMapping("/allList")
    public List<CustomerItem> customerItems(){
        return customerItemDao.allList();
    }

    @DeleteMapping("/delete/{customerItemId}")
    public void deleteCustomer(@PathVariable("customerItemId") Long customerItemId){
        customerItemDao.delete(customerItemId);
    }

    @PutMapping("/uptade")
    public CustomerItem uptade(@RequestBody CustomerItem customerItem){
        return customerItemDao.uptade(customerItem);
    }

}
