package com.hkjava.demo.demoshopping.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import com.hkjava.demo.demoshopping.model.Customer;

//用database扮第三者
public class CustomerDatabase { // step1
  public static List<Customer> customers = new ArrayList<>(); // static variable
   // static 公家用，比人add delete

  public static List<Customer> findAll(){
    return customers;
  }

  public static void add(Customer customer){
    customers.add(customer);
  }


  public static Optional<Customer> find(long id){ //
    return customers.stream()//
      .filter(customer->customer.getId()==id)//
      .findFirst();
  }

  public static Customer remove(long id){
    Optional<Customer> customer = find(id);
    if(!customer.isPresent())
      return null; // 可以throw野
    CustomerDatabase.customers.remove(customer.get());
    return customer.get(); //拆盒-->睇你處理
  }

  public static Customer update(long id, Customer newCustomer){
    // Optional<Customer> oldCustomer = find(id);
    // if (!oldCustomer.isPresent())
    // return null;
    // int index = customers.indexOf(oldCustomer.get());
    // customers.set(index,newCustomer());
    // return oldCustomer.get();
    //咁寫會被人入侵，Index 會不斷郁，變化緊，有機會產生bug, static varaible 共用
    if(!find(id).isPresent())
      return null;
    customers.stream()// 原子性，無法入侵
      .filter(customer->customer.getId()==id)//
      .forEach(e->{
        e.setDob(newCustomer.getDob());
        e.setEmail(newCustomer.getEmail());
        e.setName(newCustomer.getName());
      });
    return newCustomer;
  }

  public static Customer patchEmail(long id, String email){
    Optional<Customer> customer = find(id);
    if(!customer.isPresent())
      return null;
    customers.stream()//
      .filter(c->c.getId()==id)//
      .forEach(c->{
        c.setEmail(email);;
      });
    customer.get().setEmail(email);
    return customer.get();
  }

  public static Customer patchName(long id, String name){
    Optional<Customer> customer = find(id);
    if (!customer.isPresent())
      return null;
    customers.stream() //
        .filter(c -> c.getId() == id) //
        .forEach(c -> {
          c.setName(name);
        });
    customer.get().setName(name);
    return customer.get();    
  }
}
