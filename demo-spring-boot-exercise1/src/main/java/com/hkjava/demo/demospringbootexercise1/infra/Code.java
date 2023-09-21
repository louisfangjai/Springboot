package com.hkjava.demo.demospringbootexercise1.infra;

import lombok.Getter;


@Getter
public enum Code {
  OK(20000,"OK"), //http signal 無20000，比人知你handle
  // 40000-49999: error
  NOTFOUND(40000,"Resource NOT FOUND"),
  JPH_NOTFOUND(40001,"JsonPlaceHolder RestClientException"),
  // Server
  SERVER_TIMEOUT(50000,"Server Timeout")
  ;
  private int code;
  private String desc;

  private Code(int code,String desc){ // enum all-args不可以public
    this.code=code;
    this.desc=desc;
  }
}

