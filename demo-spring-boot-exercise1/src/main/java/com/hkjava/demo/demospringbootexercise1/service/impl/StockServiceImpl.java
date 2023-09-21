package com.hkjava.demo.demospringbootexercise1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demospringbootexercise1.infra.Protocol;
import com.hkjava.demo.demospringbootexercise1.model.Company;
import com.hkjava.demo.demospringbootexercise1.model.Quote;
import com.hkjava.demo.demospringbootexercise1.service.StockService;

@Service
public class StockServiceImpl implements StockService{
  
  @Autowired
  RestTemplate restTemplate;

  
  @Value(value="${api.finnhub.domain}")
  private String finDomain;
  
  @Value(value="${api.finnhub.basepath}")
  private String finBasepath;

  @Value(value="${api.finnhub.endpoints.company}")
  private String companyEndpoint; // from yml)

  @Value(value="${api.finnhub.endpoints.quote}")
  private String quoteEndpoint;

  @Value(value="${api.finnhub.token}")
  private String token;

  @Override
  public Company findCompany(String symbol){
    String url1 = UriComponentsBuilder.newInstance()//
    .scheme(Protocol.HTTPS.name()) // 
    .host(finDomain)//
    .path(finBasepath)
    .path(companyEndpoint)
    .queryParam("symbol",symbol)
    .queryParam("token", token)
    .toUriString();
      System.out.println("url= "+url1);
    Company company = restTemplate.getForObject(url1, Company.class);
    return company;
}

    @Override
    public Quote findQuote(String symbol){
      String url2 = UriComponentsBuilder.newInstance() //
       .scheme(Protocol.HTTPS.name())
       .host(finDomain)
      .path(finBasepath)
       .path(quoteEndpoint)
      .queryParam("symbol",symbol)
      .queryParam("token", token)
       .toUriString();

    System.out.println("url=" +url2);
    Quote q1 = restTemplate.getForObject(url2,Quote.class);
    return q1;
  }


}