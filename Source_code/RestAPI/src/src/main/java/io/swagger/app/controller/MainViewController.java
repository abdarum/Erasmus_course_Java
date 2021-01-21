package io.swagger.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.app.service.MainViewService;

@Component
@FxmlView("mainView.fxml")
public class MainViewController {
    private MainViewService mainViewService;

    @FXML
    private Button findBooksButton;
    @FXML
    private Button ordersButton;
    @FXML
    private Button manageBooksButton;
    @FXML
    private Button manageOrdersButton;
    @FXML
    private Button allUsersButton;
    @FXML
    private Button readersButton;
    @FXML
    private Button reportsButton;
    @FXML
    private Button accountButton;
    @FXML
    private VBox buttonsVBox;
    @FXML
    private Label buttonsHeadLabel;

    @Autowired
    public MainViewController(MainViewService mainViewService) {
        this.mainViewService = mainViewService;
    }

    @FXML
    public void initialize() {
        System.out.println("initialize");
        removeNotValidButtons();
    }

    private void removeNotValidButtons() {
        if (buttonsVBox != null) {
            ObservableList<Node> nodes = FXCollections.observableArrayList(buttonsVBox.getChildren());
            for (Node node : nodes) {
                if (!isButtonValidForUserType(node.idProperty().get())) {
                    buttonsVBox.getChildren().remove(node);
                }
            }
        }
    }

    private Boolean isButtonValidForUserType(String buttonId) {
        if (LoginController.getUser() != null) {
            if (buttonId.equals("findBooksButton")) {
                return LoginController.isReader() || LoginController.isLibrarian();
            }
            if (buttonId.equals("ordersButton")) {
                return LoginController.isReader();
            }
            if (buttonId.equals("manageBooksButton")) {
                return LoginController.isLibrarian();
            }
            if (buttonId.equals("manageOrdersButton")) {
                return LoginController.isLibrarian();
            }
            if (buttonId.equals("allUsersButton")) {
                return LoginController.isAdmin();
            }
            if (buttonId.equals("readersButton")) {
                return LoginController.isAdmin() || LoginController.isLibrarian();
            }
            if (buttonId.equals("reportsButton")) {
                return LoginController.isAdmin();
            }
            if (buttonId.equals("accountButton")) {
                return true;
            }
        }
        return false;
    }

    public void findBooksAction(ActionEvent actionEvent) {
        System.out.println("findBooksAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void ordersAction(ActionEvent actionEvent) {
        System.out.println("ordersAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void manageBooksAction(ActionEvent actionEvent) {
        System.out.println("manageBooksAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void manageOrdersAction(ActionEvent actionEvent) {
        System.out.println("manageOrdersAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void allUsersAction(ActionEvent actionEvent) {
        System.out.println("allUsersAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void readersAction(ActionEvent actionEvent) {
        System.out.println("readersAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void reportsAction(ActionEvent actionEvent) {
        System.out.println("reportsAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    public void accountAction(ActionEvent actionEvent) {
        System.out.println("accountAction");
        setLastChoosedButtonAs(((Button) actionEvent.getSource()).getText());
    }

    private void setLastChoosedButtonAs(String buttonText) {
        buttonsHeadLabel.setText("Current selected: " + buttonText);
    }

}
