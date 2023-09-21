package com.hkjava.bootcamp.demo.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.bootcamp.demo.demoresttemplate.controller.UserOperation;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.mapper.UserMapper;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

@RestController // Controller+ReesponseBody
@RequestMapping(value="/api/v1")
public class UserController implements UserOperation{
  
  @Autowired
  private UserService userService; //真OBJ
  // @Override
  // public ApiResponse<List<User>> findAllUsers(){ //唔洗改service
  //   return ApiResponse.<List<User>>builder()//
  //     .status(Code.OK)//
  //     .data(userService.findAllUsers())//
  //     .build();
  // }
  // controller 寫5個flow Exercise> global 
  // Caller call service, service return 有欄節
  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>>findAllUsers() throws Exception{
    List<User> users = userService.findAllUsers();
      // no need to handle unhappy flow here
        // because springboot already tickle the throw new BusinessException at UserServiceImpl and handled in the GlobalExceptionHandler
        // if (users == null) {
        //     ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
        //             .status(Code.JPH_NOTFOUND) //
        //             .data(null) //
        //             .build();
        //     return ResponseEntity.badRequest().body(response);
        // }
    // Conversion logic from User-> UserDTO
    //Conversion(user->userDTO)
    List<UserDTO> userDTOS = users.stream()// Nullpointer
      .map(user-> UserMapper.map(user))//
      .collect(Collectors.toList());

    ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder()//
          .ok()//
          .data(userDTOS)//
          .build();
      return ResponseEntity.ok().body(response);
  }
}
