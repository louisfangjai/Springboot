package com.hkjava.demo.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hkjava.demo.demofinnhub.entity.Stock;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

  // select * from table where company_name = "";
  List<Stock> findByCompanyName(String companyName); 


  // select * from table where country_name = "";
  List<Stock> findByCountryName(String countryName);

  

}
