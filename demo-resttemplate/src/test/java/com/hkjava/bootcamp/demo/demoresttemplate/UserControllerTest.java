package com.hkjava.bootcamp.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

// This is another Testing Environment
// which may not require a full context (唔需要service layer(真實))
// 拎部份功能便OK
@WebMvcTest // @AutoConfigureMockMvc
public class UserControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean // @Mock--->mock普通class
  private UserService userService; // 呢個情況不可寫@Autowired
// Controller需要一個bean去起controller

  @Test
  void testGetUser() throws Exception{
    User user1 = new User(1,"John","johnlau","john@gmail.com",null,null,
    null,null);
    User user2 = new User(2,"Mary","MaryHO","maryho@gmail.com",null,"90123",
    "123",null);
    User user3 = new User(3,"Andy","andylau","andy@gmail.com",null,null,
    null,null);
    Mockito.when(userService.findAllUsers()).thenReturn(List.of(user1,user2,user3));
        // Mockito.verify(null, null)
    //  ResultActions mvcResult =
    //  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"));  // endpoint
    mockMvc.perform(get("/api/v1/users"))// 出緊JSOON，DTO，skip service，就test controller if then else
        .andExpect(status().isOk()) // HTTP 200
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.code").value(20000))
        .andExpect(jsonPath("$.message").value("OK"))
        .andExpect(jsonPath("$.data[0].id").value(1))
        .andExpect(jsonPath("$.data[0].name").value("John"))
        .andExpect(jsonPath("$.data[1].id").value(2))
       .andExpect(jsonPath("$.data[1].name").value("Mary"))
      //  .andExpect(jsonPath("$.data[2].name").value("Andy"))
       // .andExpect(jsonPath("$.data[2].id").value(3))
        .andExpect(jsonPath("$.data[1].phone").value("90123"))
        .andExpect(jsonPath("$.data[1].website").value("123"))
        //.andExpect(jsonPath("$.data[2].em).value("88"))

        .andDo(MockMvcResultHandlers.print());
  }

    // @Test
    // void testEmptyUser()throws Exception{
    //   Mockito.when(userService.findAllUsers()).thenReturn(null);
    //   //
    //   mockMvc.perform(get("/api/v1/users"))//
    //     .andExpect(status().isBadRequest())// HTTP 400
    //     .andExpect(content().contentType(MediaType.APPLICATION_JSON))//
    //     .andExpect(jsonPath("$.code").value(40001))
    //     .andExpect(
    //         jsonPath("$.message").value("JsonPlaceHolder RestClientException"))
    //     .andExpect(jsonPath("$.data").doesNotExist())
    //     .andDo(MockMvcResultHandlers.print());
    // }
}
