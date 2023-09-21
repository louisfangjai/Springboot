package com.hkjava.bootcamp.demo.demoresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
 @Bean 
  RestTemplate restTemplate(){
        return new RestTemplate(); 
    }
}
    // RestTemplate is A tool/ class(library) to invoke third party APIs.
    // restTemplate object can be with lots of states/Variables.
    // @return an object of RestTemplate
    // lots of states/variables


// transfer to java file from Json
//