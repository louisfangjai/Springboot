package com.hkjava.bootcamp.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//Hamcrest -> Matchers
//Junit5-> jupiter -> @Mock, @InjectMock,Mockito(when)
// Spring Test Framework-> @WebMvcTest
// What is @SpringBootTest?

// I am going to test the Server Start Process, with dependency checking
@SpringBootTest // With a complete context
// mvn test -> Simulate App Server Start & Bean Injection on Context
// mvn clean test果下都會 試start server (Error find caused by)
class ApplicationTests {

	@Test
	void contextLoads() { // Test Server Start
	}

}
