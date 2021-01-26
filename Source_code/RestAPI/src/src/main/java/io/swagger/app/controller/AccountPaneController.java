package io.swagger.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private WeatherService weatherService;
    
    @FXML
    private Label weatherLabel;
    @FXML
    private BorderPane userDetailsPane;
    @FXML
    private BorderPane passwordPane;
    

    @Autowired
    public AccountPaneController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    
    @FXML
    public void initialize() {
        System.out.println("initialize");
        try {
            FxWeaver fxWeaver = JavaFxApplication.applicationContext.getBean(FxWeaver.class);
            Node node = fxWeaver.loadView(UserDetailsFormController.class);
            userDetailsPane.setCenter(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadWeatherForecast(ActionEvent actionEvent) {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }

}
