package com.hkjava.demo.demospringbootexercise1.service;

import com.hkjava.demo.demospringbootexercise1.model.Company;
import com.hkjava.demo.demospringbootexercise1.model.Quote;

public interface StockService {
  
  Company findCompany(String symbol);
  Quote findQuote(String symbol);
}
