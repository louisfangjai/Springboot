package com.hkjava.bootcamp.springa.demospringb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hkjava.bootcamp.springa.demospringb.controller.HelloworldController;
import com.hkjava.bootcamp.springa.demospringb.service.HelloworldService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v3")
public class HelloworldControllerImpl implements HelloworldController {
  
  @Autowired
  HelloworldService helloworldService;

  @Override
  public String otherMethod(){
    // HelloworldServiceImpl helloworldServiceImpl = new HelloworldServiceImpl();
    return helloworldService.generate(1);
  }
}
// http://localhost:8081/api/v3/hello