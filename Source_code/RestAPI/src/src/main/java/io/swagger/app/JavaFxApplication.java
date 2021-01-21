package io.swagger.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.Swagger2SpringBoot;
import io.swagger.app.controller.LoginController;
import io.swagger.app.controller.MyController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;


public class JavaFxApplication extends Application {

    static public ConfigurableApplicationContext applicationContext;
    static public Stage stage;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(Swagger2SpringBoot.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage startStage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        stage = startStage;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}