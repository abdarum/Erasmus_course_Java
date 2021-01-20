package com.library.app.pages.account;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.logging.*;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AccountManager {
    private Scene scene;

    public AccountManager(Scene scene) {
        this.scene = scene;
    }

    public void showAccountScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
            scene.setRoot((Parent) loader.load());
            // LoginController controller =
            // loader.<LoginController>getController();
            // controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
