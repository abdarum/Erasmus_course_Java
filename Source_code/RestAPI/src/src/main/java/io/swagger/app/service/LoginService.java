package io.swagger.app.service;

import io.swagger.service.UserService;
import javafx.scene.Parent;
import javafx.scene.Scene;
import net.rgielen.fxweaver.core.FxWeaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.app.JavaFxApplication;
import io.swagger.app.controller.LoginController;
import io.swagger.app.controller.MainViewController;
import io.swagger.model.User;

@Service
public class LoginService {
  @Autowired
  UserService  userService;

  public String authorize(String email, String password) {
    User user = userService.loginUser(email, password);
    LoginController.setUser(user);
    if(user != null){
      FxWeaver fxWeaver = JavaFxApplication.applicationContext.getBean(FxWeaver.class);
      Parent root = fxWeaver.loadView(MainViewController.class);
      Scene scene = new Scene(root);
      JavaFxApplication.stage.setScene(scene);
      return "Logged in correctly";
    }
    return "Sorry, user data does not mach";
  }

}
