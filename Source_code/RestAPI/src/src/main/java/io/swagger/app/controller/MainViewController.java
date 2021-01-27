package io.swagger.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
    @FXML
    private BorderPane mainPane;

    @Autowired
    public MainViewController(MainViewService mainViewService) {
        this.mainViewService = mainViewService;
        this.mainViewService.setController(this);
    }

    @FXML
    public void initialize() {
        System.out.println("MainViewController initialize");
        removeNotValidButtons();
    }

    private void removeNotValidButtons() {
        if (buttonsVBox != null) {
            ObservableList<Node> nodes = FXCollections.observableArrayList(buttonsVBox.getChildren());
            for (Node node : nodes) {
                if (!this.mainViewService.isButtonValidForUserType(node.idProperty().get())) {
                    buttonsVBox.getChildren().remove(node);
                }
            }
        }
    }

    public void sideBarButtonAction(ActionEvent actionEvent) {
        updateMainPane(actionEvent);
    }

    private void setLastChoseButtonAs(String buttonText) {
        buttonsHeadLabel.setText("Current selected: " + buttonText);
    }

    public void updateMainPane(ActionEvent actionEvent) {
        String buttonId = ((Button) actionEvent.getSource()).getId();
        String buttonName = ((Button) actionEvent.getSource()).getText();
        setLastChoseButtonAs(buttonName);
        // System.out.println("buttonId: " + buttonId + " buttonName: " + buttonName);
        mainPane.setCenter(mainViewService.getMainPane(buttonId));
    }
}
