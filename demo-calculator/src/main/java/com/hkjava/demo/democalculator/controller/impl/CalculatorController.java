package com.hkjava.demo.democalculator.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.democalculator.controller.CalculatorOperation;
import com.hkjava.demo.democalculator.service.CalculatorService;

@Controller // 放係class度先可以new
@ResponseBody
@RestController// @Controller+@ResponseBody ( 一樣會搵到佢)
@RequestMapping(value = "/api/v1") //似setter> set左位置
public class CalculatorController implements CalculatorOperation{
  
  @Autowired //成部機得一1粒object>全局唯一(你指示佢拎野出黎，拎唔到就自殺), 幾多人用都係同一個
  CalculatorService calculatorService; // object
  //若無@Autowired，就唔識生成object去.method // 無new到object就用唔到....
  // List<String> list; (空指針)

  @Override
  public List<String> getStrings(){
      return calculatorService.getStrings();
  }

  @Override
  public Integer add(int salary, int bonus,String dividend,int k){
    int d =0;
    try{
      d=Integer.valueOf(dividend);//
    } catch (NumberFormatException e){
      d=0;
    }
    // return new CalculatorService.add(salary+bonus,d+k);
    return calculatorService.add(salary+ bonus,d+k); // object , method--> instance method
  }
  
  @Override
  public Integer substract(int x, int y,String z){
    return calculatorService.substract(x-y,0);
  }

  @Override
  public String test(String text){
    return calculatorService.test(text);
  }

  @Override
  public String test2(String a, int y){ //要同CalculatorOperation一樣先得
    return calculatorService.test2(y);
  }
}
