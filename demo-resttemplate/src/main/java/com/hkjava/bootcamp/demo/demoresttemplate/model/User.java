package com.hkjava.bootcamp.demo.demoresttemplate.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// if Address唔 static, 要 new user->new address先可以get address(會多左object)

@Getter // Getter + No-args constructor
@AllArgsConstructor
@NoArgsConstructor // Jackson
public class User { // 因為 1個user要入咁多野
  private long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  
  @Getter
  public static class Address {
    private  String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    
  
    @Getter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
