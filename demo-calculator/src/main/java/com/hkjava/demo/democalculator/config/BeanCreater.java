package com.hkjava.demo.democalculator.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

  @Configuration// Member of @Component
  public class BeanCreater {
  
  @Bean(name = "arraylist")
  public List<String> createArrayList(){
     List<String> strings = new ArrayList<>(); // empty arraylist
     strings.add("abc");
     strings.add("ijk");
     strings.add("xyz");
     return strings;
  }

  // @Bean ...

  @Bean(name = "linkedList")
  List<String> createLinkedList(){
    return new LinkedList<>();
  }
}
