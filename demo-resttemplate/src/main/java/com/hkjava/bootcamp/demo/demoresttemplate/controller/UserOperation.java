package com.hkjava.bootcamp.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;

public interface UserOperation {
  
  // @GetMapping(value="/user")
  // List<User> findUserById(
  //   @PathVariable(name="id") String id);
  @GetMapping(value="/users")
  ResponseEntity<ApiResponse<List<UserDTO>>>findAllUsers() throws Exception; //define左T

  //ApiResponse->整頁面
}
