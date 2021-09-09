package com.aris.store.apis;

import com.aris.store.daos.ItemDao;
import com.aris.store.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/item")
public class ItemApi {

    @Autowired
    ItemDao itemDao;

    @PostMapping("/add")
    public String add(@RequestBody Item item){
        return itemDao.add(item);
    }

//    @GetMapping("/allItems")
//    public List<Item> allItems(@RequestParam int limit, @RequestParam int page){
//        return itemDao.allItem();
//    }

    @GetMapping("/allItems")
    public List<Item> allItems(){
        return itemDao.allItem();
    }

    @DeleteMapping("/delete/{itemId}")
    public void delete(@PathVariable("itemId") Long itemId){
        itemDao.delete(itemId);
    }

    @PostMapping("/uptade/")
    public Item uptade(@RequestBody Item item){
        return itemDao.uptade(item);
    }

}
