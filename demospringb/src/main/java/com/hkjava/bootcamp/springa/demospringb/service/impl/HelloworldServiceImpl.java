package com.hkjava.bootcamp.springa.demospringb.service.impl;

import org.springframework.stereotype.Service;
import com.hkjava.bootcamp.springa.demospringb.service.HelloworldService;

@Service //service在CLASS到而不是interface，佢放左佢先搵到你
public class HelloworldServiceImpl implements HelloworldService{
  
  @Override
  public String generate(int x){
    if(x>100)
      return "hello world";
    return "ABC";
  }
}
