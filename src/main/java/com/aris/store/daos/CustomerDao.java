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

    public String insert(Customer customer){
        customerRepo.save(customer);
        return "Customer inserted successfully";
    }

    public List<Customer> selectAll(){
        return (List<Customer>) customerRepo.findAll();
    }

    public Optional<Customer> selectById(Long customerId){
        if (!customerRepo.existsById(customerId)){
            throw new RuntimeException("ID you want to select does not exist");
        }
        return customerRepo.findById(customerId);
    }

    public Customer selectByName(Customer customer){
        Optional<Customer> selectedName = customerRepo.findByName("%" + customer.getName() + "%");
        if (!selectedName.isPresent()){
            throw new RuntimeException("There is no customer like " + customer.getName());
        }
        return selectedName.get();
    }

    public List<Customer> search(String keyword){
        if (keyword != null) {
            return customerRepo.search(keyword);
        }
        return (List<Customer>) customerRepo.findAll();
    }

    public String delete(Long customerID){
        if (!customerRepo.existsById(customerID)){
            throw new RuntimeException("ID you want to delete does not exist");
        }
        customerRepo.deleteById(customerID);
        return "Customer deleted";
    }

    @Transactional
    public Customer update(Customer customer){
        Optional<Customer> oldCustomer = customerRepo.findById(customer.getId());
        if (oldCustomer.isPresent()){
            oldCustomer.get().setName(customer.getName()).setSurname(customer.getSurname()).setEmail(customer.getEmail()).setCustomerItems(customer.getCustomerItems());
            return customerRepo.save(oldCustomer.get());
        }
        else throw new RuntimeException("There is no Customer like "+ customer.getName()+ "!");
    }

}
