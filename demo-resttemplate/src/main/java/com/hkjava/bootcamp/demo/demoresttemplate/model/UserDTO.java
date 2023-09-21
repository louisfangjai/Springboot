package com.hkjava.bootcamp.demo.demoresttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO { //client不用這麼多field // Data transfer Object
  private long id;
  private String name;
  @JsonProperty("x")
  private String username;
  private String phone;
  private String website;
  private Address address;

}

// user, user DTO