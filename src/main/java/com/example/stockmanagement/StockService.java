package com.example.stockmanagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class StockService {

    public HashMap<String , Stock> stockHashMap = new HashMap<>();
    private Stock errorStock = new Stock("<This is an error object>");

    public Stock addItem(String item)
    {
        Stock stock = new Stock(item);
        if(stockHashMap.containsKey(item))
        {
            System.out.println("Item already exists!");
            return errorStock;
        }
        stockHashMap.put(item,stock);
        return stock;
    }

    public Stock setStock(String item , int stockLevel)
    {
       Stock stock = stockHashMap.get(item);
       if(!stockHashMap.containsKey(item))
       {
           System.out.println("Item does not exist in the stock...");
           return errorStock;
       }
       stock.setLevel(stockLevel);
       return stock;
    }

    public Stock addStock(String item , int numItem)
    {
        Stock stock = stockHashMap.get(item);
        if(!stockHashMap.containsKey(item))
        {
            System.out.println("Item does not exist in the stock...");
            return errorStock;
        }
        int newAmount = stock.getStockAmount() + numItem;
        stock.setStockAmount(newAmount);
        return stock;
    }

    public Stock removeStock(String item , int numItem)
    {
        Stock stock = stockHashMap.get(item);
        if(!stockHashMap.containsKey(item))
           {
            System.out.println("Item does not exist in the stock...");
            return errorStock;
           }
        else if(stock.getStockAmount()-numItem >=0)
            {
               int newAmount = stock.getStockAmount()-numItem;
               stock.setStockAmount(newAmount);
               return stock;
            }
        else
        {
            System.out.println("Number of items cannot become negative...");
            return errorStock;
        }
    }

    public HashMap<String, Stock> listStock()
    {
        /*ArrayList<String> itemList = new ArrayList<>();
        for(Map.Entry<String,Stock> entry : stockHashMap.entrySet())
        {
            String item = entry.getKey();
            itemList.add(item);
        }
        return itemList;*/
        return stockHashMap;
    }
}
