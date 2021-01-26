package io.swagger.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
import io.swagger.model.User.StatusEnum;
import io.swagger.service.UserTypeService;

@Component
@FxmlView("userDetailsForm.fxml")
public class UserDetailsFormController {
    @Autowired
    private UserTypeService userTypeService;
    
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
    @FXML
    private ChoiceBox<String> statusChoiceBox;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private ChoiceBox<String> userTypeChoiceBox;

    @FXML
    public void initialize() {
    }

    public User getDataFromForm() {
        User user = new User();
        user.setFirstName(firstNameTextField.getText());
        user.setLastName(lastNameTextField.getText());
        user.setPhone(phoneTextField.getText());
        user.setEmail(emailTextField.getText());
        user.setPassword(passwordTextField.getText());
        user.setAdress(adressTextField.getText());
        user.setCity(cityTextField.getText());
        if (birthdayDatePicker.getValue() != null) {
            OffsetDateTime birthdate = OffsetDateTime
                    .parse(birthdayDatePicker.getValue().toString() + "T00:00:00+00:00");
            user.setBirthdate(birthdate);
        }
        // https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        if(statusChoiceBox.getValue() != null){
            user.setStatus(StatusEnum.fromValue(statusChoiceBox.getValue()));
        }
        if(genderChoiceBox.getValue() != null){
            user.setGender(genderChoiceBox.getValue());
        }
        if(userTypeChoiceBox.getValue() != null){
            user.setUserTypeId(userTypeService.getUserTypeIdByName(userTypeChoiceBox.getValue()));
        }
        return user;
    }

    public void setFormFromData(User user){
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        phoneTextField.setText(user.getPhone());
        emailTextField.setText(user.getEmail());
        // passwordTextField.setText(user.getPassword());
        adressTextField.setText(user.getAdress());
        cityTextField.setText(user.getCity());
        birthdayDatePicker.setValue(LocalDate.of(user.getBirthdate().getYear(), user.getBirthdate().getMonthValue(), user.getBirthdate().getDayOfMonth()));
        statusChoiceBox.setValue(user.getStatus().name());
        statusChoiceBox.setValue(user.getGender());
        userTypeChoiceBox.setValue(userTypeService.getUserTypeNameById(user.getUserTypeId()));
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        // getDataFromForm();
        System.out.println(getDataFromForm().toString());
    }

}
