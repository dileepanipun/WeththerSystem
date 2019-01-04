package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.main.Main;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePaneController implements Initializable {

    @FXML
    private Label txtDate;

    @FXML
    private Label txtTime;

    @FXML
    private AnchorPane panelLoader;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnMinimize;

    private Timeline timeline;

    @FXML
    void btnCloserOnAction(ActionEvent event) {
        ButtonType result = NotificationController.createConfigAlert();
        if(result == ButtonType.OK){
            System.exit(0);
        }
    }

    @FXML
    void btnDeviceOnAction(ActionEvent event) throws Exception {
        AnchorPane devicePane =  FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/DevicePane.fxml"));
        panelLoader.getChildren().setAll(devicePane);
    }

    @FXML
    void btnInfoOnAction(ActionEvent event) throws Exception{
        AnchorPane infoPane =  FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/InfoPane.fxml"));
        panelLoader.getChildren().setAll(infoPane);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws Exception{
        ButtonType result = NotificationController.createConfigAlert();
        if(result == ButtonType.OK){
            AnchorPane loginPane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/Login.fxml"));
            Scene scene = new Scene(loginPane);
            Stage stage = (Stage) this.btnLogout.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else {
            NotificationController.createError("Error","Something went wrong");
        }
    }

    @FXML
    void btnMinimizeOnAction(ActionEvent event) {
        Stage stage = (Stage) btnMinimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws Exception {
        AnchorPane reportsPane =  FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/ReportsPane.fxml"));
        panelLoader.getChildren().setAll(reportsPane);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception{
        AnchorPane searchPane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/SearchPane.fxml"));
        panelLoader.getChildren().setAll(searchPane);
    }

    @FXML
    void btnSynopOnAction(ActionEvent event) throws Exception {
        AnchorPane synopPane =  FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/SynopData.fxml"));
        panelLoader.getChildren().setAll(synopPane);
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws Exception {
        loadDashBoard();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadDashBoard();
            setTimeAndDate();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(HomePaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTimeAndDate() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txtTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadDashBoard() throws Exception{
        AnchorPane forcastPane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/DashBord.fxml"));
        panelLoader.getChildren().setAll(forcastPane);
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws Exception {
        AnchorPane userPane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/UserPane.fxml"));
        panelLoader.getChildren().setAll(userPane);
    }
}
