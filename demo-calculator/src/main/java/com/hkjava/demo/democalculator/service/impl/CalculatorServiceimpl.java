package com.hkjava.demo.democalculator.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.hkjava.demo.democalculator.service.CalculatorService;

@Service // 放在class 上面只可以new佢
public class CalculatorServiceimpl implements CalculatorService{

  @Autowired
  @Qualifier(value = "arraylist")
  private List<String>strings;

  @Override
  public List<String> getStrings(){
    ///////// 若放係呢度會累積
      return this.strings;
  }

  @Override
  public int add(int x, int y){
    return x+y;
  }
  
  @Override
  public int substract(int x, int y){
    return x-y;
  }

  @Override
  public String test(String text){
    return text+text+text+"test";
  }

  @Override
  public String test2( int a3){
    return "test2"+" "+a3*3;
  }
}
