package io.swagger.app.service;

import io.swagger.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.app.controller.LoginController;
import io.swagger.model.User;

@Service
public class LoginService {
  @Autowired
  UserService  userService;

  public User user;

  public String authorize(String email, String password) {
    this.user = userService.loginUser(email, password);
    if(user != null){
      return "Logged in correctly";
    }
    return "Sorry, user data does not mach";
  }

}
