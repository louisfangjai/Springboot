package com.hkjava.demo.demospringbootexercise1.infra;

import lombok.ToString;

@ToString
public class ApiResponse<T> {
  
  private int code;
  private String message;
  private T data;

  public int getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

  public T getData(){
    return this.data;
  }

  public static<T> ApiResponseBuilder<T> builder(){
    return new ApiResponseBuilder<>();
  }
    private ApiResponse(ApiResponseBuilder<T> builder){
      this.code=builder.code;
      this.message=builder.message;
      this.data=builder.data;
    }

  public static class ApiResponseBuilder<T>{
    private int code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> status(Code code){
      this.code= code.getCode();
      this.message=code.getDesc();
      return this;
    }
    public ApiResponseBuilder<T> ok() { // setter
      this.code = Code.OK.getCode();
      this.message = Code.OK.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      if(this.code==0|| this.message==null) //code是0係無INPUT
        throw new RuntimeException();
      return new ApiResponse<>(this);
    }
  }

}
