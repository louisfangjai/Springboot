package com.hkjava.demo.demospringbootexercise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demospringbootexercise1.model.Stock;

public interface StockOperation {
@GetMapping(value="/stock")
 Stock findStock(@RequestParam(name="symbol")String symbol);
}
