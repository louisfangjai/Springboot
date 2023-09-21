package com.hkjava.demo.demospringbootexercise1.mapper;

import com.hkjava.demo.demospringbootexercise1.model.Company;
import com.hkjava.demo.demospringbootexercise1.model.CompanyProfile;
import com.hkjava.demo.demospringbootexercise1.model.Quote;
import com.hkjava.demo.demospringbootexercise1.model.Stock;

public class StockMapper {
  
 public static Stock map(Company company,Quote quote){
  return Stock.builder()//
    .companyProfile(CompanyProfile.builder() //
      .country(company.getCountry())
      .name(company.getName())
      .ipo(company.getIpo())
      .logo(company.getLogo())
      .marketCapitalization(company.getMarketCapitalization())
      .currency(company.getCurrency())
      .build()
)
        .c(quote.getC())
        .h(quote.getH())
        .l(quote.getL())
        .o(quote.getO())
        .pc(quote.getPc())
        .build();
 } 
}
