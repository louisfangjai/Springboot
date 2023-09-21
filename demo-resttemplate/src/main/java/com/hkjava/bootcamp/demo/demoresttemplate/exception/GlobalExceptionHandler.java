package com.hkjava.bootcamp.demo.demoresttemplate.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;

@RestControllerAdvice // @ResponseBody+@ControllerAdvice
public class GlobalExceptionHandler { // 全局攔截
  
  @ExceptionHandler(value = JPHException.class) // value的class
  public ResponseEntity<ApiResponse<Void>>jphExceptionHandler(){
      ApiResponse<Void> response = ApiResponse.<Void>builder()//
      .status(Code.JPH_NOTFOUND)//
      .data(null)//
      .build();
      return ResponseEntity.badRequest().body(response);
    
  }
}
// 全局