package com.hkjava.bootcamp.demo.demoresttemplate.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.bootcamp.demo.demoresttemplate.exception.JPHException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Protocol;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService { // Bean
  // .class ---> array
  // 過3關，而家係startup time,唔需要final
  // 搵唔到就startup唔到
  // static---> belongs to class
  // 唔static -> check埋depandency
  // static, final-->compile time,
  // 而家係server start time...manage depandency
  // get for object User[].class-->return type
  @Autowired // 搵唔搵到個bean
  private RestTemplate restTemplate; // tool no state, from context

  @Value(value = "${api.jsonplacefolder.domain}") // 對返domain path
  private String jphDomain; // From yml

  @Value(value = "${api.jsonplacefolder.endpoints.user}")
  private String userEndpoint; // from yml

  @Override
  public List<User> findAllUsers() throws BusinessException {
    String url = UriComponentsBuilder.newInstance()// create url
        .scheme(Protocol.HTTPS.name())//
        .host(jphDomain)//
        .path(userEndpoint)//
        .toUriString();

    System.out.println("url=" + url);
    // Invoke API+ Deserialization (JSON->Object) line 41
    try {
      User[] users = restTemplate.getForObject(url, User[].class); // call 出面世界，call唔到throws exception
      return Arrays.asList(users); // getForObject throw restClientException
    } catch (RestClientException e) {
      throw new JPHException(Code.JPH_NOTFOUND); // null代表有事
   }
    // return new ArrayList<>(Arrays.asList(users));
  }
}

