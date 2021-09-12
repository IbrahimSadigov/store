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

    @PostMapping("/insert")
    public String insert(@RequestBody Item item){
        return itemDao.insert(item);
    }

//    @GetMapping("/allItems")
//    public List<Item> allItems(@RequestParam int limit, @RequestParam int page){
//        return itemDao.allItem();
//    }

    @GetMapping("/selectAll")
    public List<Item> selectAll(){
        return itemDao.selectAll();
    }

    @DeleteMapping("/delete/{itemId}")
    public void delete(@PathVariable("itemId") Long itemId){
        itemDao.delete(itemId);
    }

    @PostMapping("/update/")
    public Item update(@RequestBody Item item){
        return itemDao.update(item);
    }

}
