package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

public interface CompanyService {

  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

  void updateById(Long id, Stock stock);

  List<Stock> findAll();

  List<Stock>findByCountry(String country);

  Stock save(Stock stock);

  void deleteById(Long id);

  void updateCompanyNameById(Long id, String companyName);

}
