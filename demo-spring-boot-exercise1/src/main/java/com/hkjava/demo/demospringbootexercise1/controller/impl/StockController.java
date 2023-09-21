package com.hkjava.demo.demospringbootexercise1.controller.impl;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demospringbootexercise1.controller.StockOperation;
import com.hkjava.demo.demospringbootexercise1.mapper.StockMapper;
import com.hkjava.demo.demospringbootexercise1.model.Company;
import com.hkjava.demo.demospringbootexercise1.model.Quote;
import com.hkjava.demo.demospringbootexercise1.model.Stock;
import com.hkjava.demo.demospringbootexercise1.service.StockService;

@RestController
@RequestMapping(value = "/api/v1")
public class StockController implements StockOperation{
  
  @Autowired
  StockService stockService;
  
  @Override
  public Stock findStock(String symbol){
        Company company =stockService.findCompany(symbol);
        Quote quote = stockService.findQuote(symbol);

        Stock stock =  StockMapper.map(company,quote);//

    return stock;
  }

}
