package io.swagger.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import net.rgielen.fxweaver.core.FxmlView;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

import io.swagger.app.service.WeatherService;
import io.swagger.model.User;

@Component
@FxmlView("userDetailsForm.fxml")
public class UserDetailsFormController {
    private WeatherService weatherService;
    
    @FXML
    private Label weatherLabel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField adressTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private Label registratedLabel;
    // @FXML
    // private ToggleGroup genderRadioGroup;

    @Autowired
    public UserDetailsFormController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    
    public void loadWeatherForecast(ActionEvent actionEvent) {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }

    public User getDataFromForm(){
        User user = new User();
        user.setFirstName(firstNameTextField.getText());
        user.setLastName(lastNameTextField.getText());
        user.setPhone(phoneTextField.getText());
        user.setEmail(emailTextField.getText());
        user.setPassword(passwordTextField.getText());
        user.setAdress(adressTextField.getText());
        user.setCity(cityTextField.getText());
        if(birthdayDatePicker.getValue() != null){
            OffsetDateTime birthdate = OffsetDateTime.parse(birthdayDatePicker.getValue().toString()+"T00:00:00+00:00" );
            user.setBirthdate(birthdate);
        }
        // https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        // System.out.println(genderRadioGroup.getToggles());
        return user;
    }

    private org.threeten.bp.ZoneOffset ZoneOffset(int i) {
        return null;
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        getDataFromForm();
        System.out.println(getDataFromForm().toString());
    }

}
