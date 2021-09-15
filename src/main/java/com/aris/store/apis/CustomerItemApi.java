package com.aris.store.apis;

import com.aris.store.daos.CustomerItemDao;
import com.aris.store.entities.CustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerItem")
public class CustomerItemApi {

    @Autowired
    CustomerItemDao customerItemDao;

    @PostMapping("/insert")
    public String insert(@RequestBody CustomerItem customerItem){
        return customerItemDao.insert(customerItem);
    }

    @GetMapping("/selectAll")
    public List<CustomerItem> customerItems(){
        return customerItemDao.selectAll();
    }

    @DeleteMapping("/delete/{customerItemId}")
    public void deleteCustomer(@PathVariable("customerItemId") Long customerItemId){
        customerItemDao.delete(customerItemId);
    }

    @PutMapping("/update")
    public CustomerItem update(@RequestBody CustomerItem customerItem){
        return customerItemDao.update(customerItem);
    }


//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("customerId", )
//    }

}
