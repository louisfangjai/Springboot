package com.hkjava.bootcamp.demo.demoresttemplate.infra;


import lombok.ToString;

// get,setter,toString 放左先(之後再改，if builder work->setter唔洗)
//唔洗setter，理論上controller只可以做一次
// @Builder // TBC ->自己寫 底層program share比public用，唔想依賴depandency

// NO@ bulder 1. 底層野唔想depends on 人(lombok
//2 .封裝
@ToString
public class ApiResponse<T> { // extends?  1.>唔想比人new個class -->builder
  // attribute name same as JSON field name after serialziation, 唔會改
  private int code;
  private String message;
  private T data; // 你唔知個data係咩 --> T (任何野)
  // libirary > no state

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }
  // public 被人call
  public static <T> ApiResponseBuilder<T> builder() { // static method要比range
    return new ApiResponseBuilder<>();
  }
  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class ApiResponseBuilder<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> status(Code code) { // setter
      this.code = code.getCode();
      this.message = code.getDesc();
      return this;
    } //封裝一定要入個Code
    //     public ApiResponseBuilder<T> setCode(int code) { // setter
    //   this.code = code;
    //   return this;
    // }
    //     public ApiResponseBuilder<T> setDesc(String message) { // setter
    //   this.message = message;
    //   return this;
    // }
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

// {
// "code":200
// "message":"OK",
// "data":[

// ],
// "error":[
// "",""
// ],
// }
