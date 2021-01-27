package io.swagger.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.app.JavaFxApplication;
import io.swagger.app.service.WeatherService;

@Component
@FxmlView("accountPane.fxml")
public class AccountPaneController {
    @FXML
    private BorderPane userDetailsPane;
    @FXML
    private BorderPane passwordPane;
    
    @FXML
    public void initialize() {
        System.out.println("AccountPaneController initialize");
        try {
            UserDetailsFormController userController = new UserDetailsFormController();
            userController.setInitialUser(LoginController.getUser());
            FxWeaver fxWeaver = JavaFxApplication.applicationContext.getBean(FxWeaver.class);
            Node node = fxWeaver.loadView(userController.getClass());
            userDetailsPane.setCenter(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
