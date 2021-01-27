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
import javafx.scene.layout.VBox;
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
import io.swagger.service.UserService;
import io.swagger.service.UserTypeService;

@Component
@FxmlView("userDetailsForm.fxml")
public class UserDetailsFormController {
    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private UserService userService;
    
    private User initialUser = null;

    @FXML
    private VBox mainVBox;
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
        if(initialUser != null){
            setFormFromData(initialUser);
        }
    }

    public User getDataFromForm() {
        User user = new User();
        if (getInitialUser() != null ) user = new User(getInitialUser());
        if(!firstNameTextField.getText().isEmpty()) user.setFirstName(firstNameTextField.getText());
        if(!lastNameTextField.getText().isEmpty()) user.setLastName(lastNameTextField.getText());
        if(!phoneTextField.getText().isEmpty()) user.setPhone(phoneTextField.getText());
        if(!emailTextField.getText().isEmpty()) user.setEmail(emailTextField.getText());
        if(!emailTextField.getText().isEmpty()) user.setEmail(emailTextField.getText());
        if(!passwordTextField.getText().isEmpty()) user.setPassword(passwordTextField.getText());
        if(!adressTextField.getText().isEmpty()) user.setAdress(adressTextField.getText());
        if(!cityTextField.getText().isEmpty()) user.setCity(cityTextField.getText());
        if (birthdayDatePicker.getValue() != null) {
            OffsetDateTime birthdate = OffsetDateTime
                    .parse(birthdayDatePicker.getValue().toString() + "T00:00:00+00:00");
            user.setBirthdate(birthdate);
        }
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
        statusChoiceBox.setValue(user.getStatus().toString());
        genderChoiceBox.setValue(user.getGender());
        userTypeChoiceBox.setValue(userTypeService.getUserTypeNameById(user.getUserTypeId()));
        registratedLabel.setText(user.getRegistrated().toString());
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        System.out.println(getDataFromForm().toString());
        userService.updateUserById(getInitialUser().getId(), getDataFromForm());
    }

    public void loadButtonOnAction(ActionEvent actionEvent) {
        setInitialUser(LoginController.getUser());
        setFormFromData(getInitialUser());
    }

    public User getInitialUser() {
        return initialUser;
    }

    public void setInitialUser(User initialUser) {
        this.initialUser = initialUser;
    }

}
