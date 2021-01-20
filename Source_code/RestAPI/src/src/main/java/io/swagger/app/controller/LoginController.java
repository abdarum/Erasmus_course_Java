package io.swagger.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.app.service.LoginService;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;

/** Controls the login screen */
@Component
@FxmlView("login.fxml")
public class LoginController {
  private LoginService loginService;

  @FXML
  private TextField user;
  @FXML
  private TextField password;
  @FXML
  private Button loginButton;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  public void logInAction(ActionEvent actionEvent) {
    System.out.print(loginService.authorize(user.getText(), password.getText()));
  }
}
