package lk.edu.ijse.metromanagement.main;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.edu.ijse.metromanagement.controller.DevicePaneContorller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            try {
                Logger errorLogger = Logger.getLogger("");
                FileHandler fileHandler = new FileHandler("log/error.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                errorLogger.addHandler(fileHandler);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/Login.fxml"));
            Scene scene = new Scene(root);

            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setNode(root);
            fadeTransition.setDuration(new Duration(2000));
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            primaryStage.setTitle("Meto System v1.0");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            primaryStage.getIcons().add(new Image("/lk/edu/ijse/metromanagement/assest/LogoIconFinal.png"));
        }catch (Exception e){

        }
    }

    public static void main(String args[]){
        launch(args);
    }
}