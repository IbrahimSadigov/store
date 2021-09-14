package com.aris.store.daos;

import com.aris.store.entities.Stock;
import com.aris.store.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockDao {

    @Autowired
    StockRepo stockRepo;

    public String insert(Stock stock){
        stockRepo.save(stock);
        return "Stock successfully inserted.";
    }

    public List<Stock> selectAll(){
        return (List<Stock>) stockRepo.findAll();
    }

    public String delete(Long stockId){
        if (stockRepo.existsById(stockId)){
            stockRepo.deleteById(stockId);
        }
        else throw new RuntimeException("Stock you want to delete does not exist!");
        return "Stock id deleted";
    }

    public Stock update(Stock stock){
        Optional<Stock> oldStock = stockRepo.findById(stock.getId());
        if (oldStock.isPresent()){
            oldStock.get().setItemQuantity(stock.getItemQuantity()).setItems(stock.getItems());
            return stockRepo.save(oldStock.get());
        }
        else throw new RuntimeException("There is no stock");
    }

}
