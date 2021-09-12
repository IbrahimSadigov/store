package com.aris.store.apis;

import com.aris.store.daos.StockDao;
import com.aris.store.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockApi {

    @Autowired
    StockDao stockDao;

    @PostMapping("/insert")
    public String insert(@RequestBody Stock stock){
        return stockDao.insert(stock);
    }

    @GetMapping("/selectAll")
    public List<Stock> selectAll(){
        return stockDao.selectAll();
    }

    @DeleteMapping("/delete/{stockId}")
    public void delete(@PathVariable("stockId") Long stockId){
        stockDao.delete(stockId);
    }

    @PutMapping("/update")
    public Stock update(@RequestBody Stock stock){
        return stockDao.update(stock);
    }

}
