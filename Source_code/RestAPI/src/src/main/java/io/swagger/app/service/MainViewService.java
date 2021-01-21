package io.swagger.app.service;

import org.springframework.stereotype.Service;

import io.swagger.app.JavaFxApplication;
import io.swagger.app.controller.AccountPaneController;
import io.swagger.app.controller.LoginController;
import io.swagger.app.controller.MainViewController;
import io.swagger.app.controller.MyController;
import io.swagger.app.controller.NotImplementedController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxWeaver;

@Service
public class MainViewService {
    private MainViewController controller;

    public Pane getMainPane(String buttonId) {
        // System.out.println(buttonId);
        try {
            FxWeaver fxWeaver = JavaFxApplication.applicationContext.getBean(FxWeaver.class);
            Node node = fxWeaver.loadView(NotImplementedController.class);
            if(buttonId.equals("accountButton")){
                node = fxWeaver.loadView(AccountPaneController.class);
            } 
            return (Pane) node;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean isButtonValidForUserType(String buttonId) {
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

    public MainViewController getController() {
        return controller;
    }

    public void setController(MainViewController controller) {
        this.controller = controller;
    }
}