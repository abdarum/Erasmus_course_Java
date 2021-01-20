package io.swagger.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.app.service.LoginService;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;

/** Controls the login screen */
@Component
@FxmlView("login.fxml")
public class LoginController {
  private LoginService loginService;

  @FXML
  private TextField email;
  @FXML
  private PasswordField password;
  @FXML
  private Button loginButton;
  @FXML
  private Label statusLabel;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  public void logInAction(ActionEvent actionEvent) {
    statusLabel.setText(loginService.authorize(email.getText(), password.getText()));
    if (loginService.user != null) {
      System.out.println(loginService.user.toString());
      statusLabel.setTextFill(Color.GREEN);
    } else {
      statusLabel.setTextFill(Color.RED);
    }
  }
}
