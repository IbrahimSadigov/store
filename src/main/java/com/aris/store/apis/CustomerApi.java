package com.aris.store.apis;

import com.aris.store.daos.CustomerDao;
import com.aris.store.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    CustomerDao customerDao;

    @PostMapping("/add")
    public String add(@RequestBody Customer customer){
        return customerDao.add(customer);
    }

    @GetMapping("/allCustomers")
    public List<Customer> allCustomers(){
        return customerDao.allCustomers();
    }

    @DeleteMapping("/delete/{customerID}")
    public void delete(@PathVariable("customerID") Long customerID){
        customerDao.delete(customerID);
    }

    @PutMapping("/uptade")
    public Customer uptade(@RequestBody Customer customer) {
        return customerDao.update(customer);
    }

}
