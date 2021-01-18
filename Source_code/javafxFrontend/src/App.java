import java.io.Console;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import login.LoginManager;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new StackPane());
        
        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();
    
        stage.setScene(scene);
        stage.show();
    }
}
