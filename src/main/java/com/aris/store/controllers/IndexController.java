package com.aris.store.controllers;

import com.aris.store.entities.Customer;
import com.aris.store.entities.CustomerItem;
import com.aris.store.repositories.CustomerItemRepo;
import com.aris.store.repositories.CustomerRepo;
import com.aris.store.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerItemRepo customerItemRepo;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("items", itemRepo.findAll());
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("customerItem", customerItemRepo.findAll());
        return "index";
    }

//    @GetMapping("/delete")
//    public String delete(@RequestParam long id){
//
//        System.out.println(id);
//        itemRepo.deleteById(id);
//        return "index";
//    }
}
