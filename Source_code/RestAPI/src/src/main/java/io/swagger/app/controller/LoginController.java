package io.swagger.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import io.swagger.app.service.LoginService;
import io.swagger.model.User;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;

/** Controls the login screen */
@Component
@FxmlView("login.fxml")
public class LoginController {
  private LoginService loginService;
  private static User user = null;

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
    if (email.getText() == "" && password.getText() == "") {
      // email.setText("admin@lib.com");
      // password.setText("admin");
      email.setText("librarian@lib.com");
      password.setText("librarian");
      // email.setText("reader@lib.com");
      // password.setText("reader");
    }
    String loginResult = loginService.authorize(email.getText(), password.getText());
    if (user != null) {
      statusLabel.setTextFill(Color.GREEN);
    } else {
      statusLabel.setText(loginResult);
      statusLabel.setTextFill(Color.RED);
    }
  }

  public static User getUser() {
    return user;
  }

  public static void setUser(User user) {
    LoginController.user = user;
  }

  public static Boolean isAdmin() {
    return user != null && user.getUserTypeId() == Long.valueOf(1);
  }

  public static Boolean isLibrarian() {
    return user != null && user.getUserTypeId() == Long.valueOf(2);
  }

  public static Boolean isReader() {
    return user != null && user.getUserTypeId() == Long.valueOf(3);
  }
}
