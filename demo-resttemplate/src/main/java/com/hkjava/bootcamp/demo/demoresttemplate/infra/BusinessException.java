package com.hkjava.bootcamp.demo.demoresttemplate.infra;

public class BusinessException extends Exception{ // 要check exception, 所以extends佢

  private int code;

  public BusinessException(Code code){ //放enum super description
    super(code.getDesc());
    this.code=code.getCode();
  } 
}
