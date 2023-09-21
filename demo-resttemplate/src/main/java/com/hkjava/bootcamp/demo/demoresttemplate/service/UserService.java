package com.hkjava.bootcamp.demo.demoresttemplate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;

@Service
public interface UserService {
  
  List<User> findAllUsers() throws BusinessException;
  // List<User> findUser();
}
