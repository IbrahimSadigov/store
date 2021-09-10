package com.aris.store.apis;

import com.aris.store.entities.Customer;
import com.aris.store.entities.OrderRequest;
import com.aris.store.repositories.CustomerItemRepo;
import com.aris.store.repositories.CustomerRepo;
import com.aris.store.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRequestApi {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerItemRepo customerItemRepo;

    @Autowired
    ItemRepo itemRepo;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepo.save(orderRequest.getCustomer());
    }

    @GetMapping("/allOrders")
    public List<Customer> allOrders(){
        return (List<Customer>) customerRepo.findAll();
    }

}
