package com.aris.store.apis;

import com.aris.store.daos.CustomerDao;
import com.aris.store.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    CustomerDao customerDao;

    @PostMapping("/insert")
    public String insert(@RequestBody Customer customer){
        return customerDao.insert(customer);
    }

    @GetMapping("/selectAll")
    public List<Customer> selectAll(){
        return customerDao.selectAll();
    }

    @GetMapping("/selectById/{customerId}")
    public Optional<Customer> selectById(@PathVariable("customerId") Long customerId){
        return customerDao.selectById(customerId);
    }

    @DeleteMapping("/delete/{customerId}")
    public String delete(@PathVariable("customerId") Long customerId){
        return customerDao.delete(customerId);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerDao.update(customer);
    }

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Customer> listProducts = customerDao.search(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "index";
    }

}
