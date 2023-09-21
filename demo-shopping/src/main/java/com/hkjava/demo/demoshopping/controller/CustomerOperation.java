package com.hkjava.demo.demoshopping.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerOperation {

  //http://localhost:8084/api/v1/customers
  @GetMapping(value="/customers") //noun, no verb
  List<Customer> findAll();
  
  // "/customer"-> endpoint // 唔好寫customerget
  //http://localhost:8084/api/v1/customer?name=123&email=abc@gmail.com&dob=1925-02-18
  @PostMapping(value="/customer")// noun, No verb
  Customer create(@RequestParam String name, //
    @RequestParam String email,//
    @RequestParam LocalDate dob);
  
    // http://localhost:8084/api/v1/customer2   
    // ---->body-> raw->入json (id,order可入可不入)
    //網址點樣入?
  @PostMapping(value="/customer2") // noun, No verb
  Customer create(@RequestBody Customer customer);
// http://localhost:8084/api/v1/customer/1
 @GetMapping(value="/customer/{id}")// noun, No verb
  Customer find(@PathVariable(name="id")String customerId);
//// http://localhost:8084/api/v1/customer/1
  @DeleteMapping(value="/customer/{id}") // noun, No verb
  Customer remove(@PathVariable(name="id")String customerId);

  @PutMapping(value="/customer/{id}")// Put-> table PK (Primary key)// noun, No verb // putmapping 似mysql update，成個object replace
  Customer update(@PathVariable(name="id") String id,//
  @RequestBody Customer customer); // 成條recordreplace
  // Put-> table PK (Primary key)// putmapping是成個資源更新  
///////////////////////////////////////////////////////////////////////
// patch是更新一個field by ....
//http://localhost:8084/api/v1/customer/id/1/email/abc@gmail.com
  @PatchMapping(value = "/customer/id/{id}/email/{email}") // 加多個email先唔撞
  Customer patchEmail(@PathVariable(name="id") String id,// /customer/id/2/email/andy@gmail.com
    @PathVariable String email);
    //http://localhost:8084/api/v1/customer/id/1/name/louis
  @PatchMapping(value="/customer/id/{id}/name/{name}") // noun, No verb
  Customer patchName(@PathVariable(name="id") String id,//
    @PathVariable String name);

}
// URL 唔洗打get customer果D....淨係customer
