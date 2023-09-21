package com.hkjava.bootcamp.springa.demospringb.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface HelloworldController {
  
  @GetMapping(value = "/hello")
  String otherMethod();
}
