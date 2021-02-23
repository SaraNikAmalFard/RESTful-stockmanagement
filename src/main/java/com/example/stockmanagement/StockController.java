package com.example.stockmanagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class StockController {
    public StockService stockService = new StockService();

    @PostMapping("/stock/addItem")
    public Stock addItem(@RequestParam(value = "item" , defaultValue = "Apple")String item)
    {return  stockService.addItem(item);}

    @PutMapping("/stock/setStock")
    public Stock setStock(@RequestParam(value = "item" , defaultValue = "Apple")String item , @RequestParam(value = "stockLevel",defaultValue = "1") int stockLevel)
    {return stockService.setStock(item , stockLevel);}

    @PutMapping("/stock/addStock")
    public Stock addStock(@RequestParam(value = "item",defaultValue = "Apple")String item , @RequestParam(value = "numItem",defaultValue = "1") int numIem)
    {return  stockService.addStock(item , numIem);}

    @PutMapping("/stock/removeStock")
    public Stock removeStock(@RequestParam(value = "item", defaultValue ="Apple" )String item , @RequestParam(value = "numItem", defaultValue = "1") int numItem)
    {return stockService.removeStock(item , numItem);}

    @GetMapping("/stock/listStock")
    public HashMap<String, Stock> listStock()
    { return stockService.listStock();}

}
