package io.swagger.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.app.service.WeatherService;

@Component
@FxmlView("accountPane.fxml")
public class AccountPaneController {
    private WeatherService weatherService;
    
    @FXML
    private Label weatherLabel;

    @Autowired
    public AccountPaneController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    
    public void loadWeatherForecast(ActionEvent actionEvent) {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }

}
