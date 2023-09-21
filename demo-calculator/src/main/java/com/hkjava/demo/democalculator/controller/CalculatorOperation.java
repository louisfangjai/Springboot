package com.hkjava.demo.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
 //http://localhost:8082/api/v1/strings
  @GetMapping(value="/strings")
  List<String> getStrings();

  // http://localhost:8082/api/v1/add?x=10&y=20 // x= 10, y= 20 input的野

  @GetMapping(value = "/add")// end point
    Integer add(@RequestParam(name="x") int salary ////return type唔好放primitive e.g int，放class，method入面就無所謂
    , @RequestParam(name ="y") int bonus
    , @RequestParam(name ="z",required = false, defaultValue = "100") String dividend
    , @RequestParam int k);  
      // required false, 唔一定要比
      // Required default本身true，唔洗特登寫required = true

  // http://localhost:8082/api/v1/substract/10/20
    @GetMapping(value={"/substract/{x}/{y}/{z}",//   入口，就一個String
    "/substract/{x}/{y}"})

    Integer substract(@PathVariable(name="x") int salary,//
      @PathVariable int y, // 佢對應到
      @PathVariable(required = false) String z);
      // PathVariable 是 String

      @GetMapping(value="/test")
      String test(@RequestParam String text);

      @GetMapping(value={"/test2/{a}/{y}"})
      String test2(@PathVariable String a, @PathVariable int y);
      

}
// 佢本身就係String why int都得?
// @RequestParam 多野要input用
// @PathVariable 隱藏field