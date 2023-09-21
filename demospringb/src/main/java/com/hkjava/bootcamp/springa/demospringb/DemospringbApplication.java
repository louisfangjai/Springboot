package com.hkjava.bootcamp.springa.demospringb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Configuration
// EnableAutoConfiguration
// ComponentScan (Most Important)(全局search,搵到component)
// ComponentScan is to scan @Controller,@Service, @Repository,@Configuration
// if yes, create an object of those classes
// and put that object into SpringContext(儲住一直的)
public class DemospringbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringbApplication.class, args);
	}

}
