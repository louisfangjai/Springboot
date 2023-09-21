package com.hkjava.demo.democalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // 自己Configuration->Bean // 有呢個就會做component scan
public class DemoCalculatorApplication {

	private static ConfigurableApplicationContext context;// static variable //belong to class
	private static String[] beans;

	public String[] getBeans(){
		return beans;
	}
	public static void main(String[] args) {
		// SpringApplication.run(DemoCalculatorApplication.class, args);

		context = SpringApplication.run(DemoCalculatorApplication.class,args);
		beans = context.getBeanDefinitionNames(); //start up serve的事
	}

}
// springcontext有一堆豆做緊野
// call api return野
// 最出面 去run
// step 2 行完出黎放落個 string[]
