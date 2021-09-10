package com.aris.store.daos;

import com.aris.store.entities.Customer;
import com.aris.store.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDao {

    @Autowired
    CustomerRepo customerRepo;

    public String add(Customer customer){
        customerRepo.save(customer);
        return "Customer added successfully";
    }

    public List<Customer> allCustomers(){
        return (List<Customer>) customerRepo.findAll();
    }

    public void delete(Long customerID){
        if (!customerRepo.existsById(customerID)){
            throw new RuntimeException("ID you want to delete does not exist");
        }
        customerRepo.deleteById(customerID);
    }

    @Transactional
    public Customer update(Customer customer){
        Optional<Customer> oldCustomer = customerRepo.findById(customer.getCustomer_id());
        if (oldCustomer.isPresent()){
            oldCustomer.get().setName(customer.getName()).setSurname(customer.getSurname()).setEmail(customer.getEmail()).setCustomerItems(customer.getCustomerItems());
            return customerRepo.save(oldCustomer.get());
        }
        else throw new RuntimeException("There is no Customer like "+ customer.getName()+ "!");
    }

}
