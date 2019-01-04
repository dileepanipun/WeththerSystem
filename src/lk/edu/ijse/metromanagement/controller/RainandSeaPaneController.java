package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.edu.ijse.metromanagement.common.NotificationController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RainandSeaPaneController implements Initializable {

    @FXML
    private JFXTextField txtRain_SinceLOB;

    @FXML
    private JFXTextField txtRain_LRO;

    @FXML
    private JFXTextField txtRain_PreHrs;

    @FXML
    private JFXTextField txtRain_FromJanuaray;

    @FXML
    private JFXTextField txtCodeFigure_Sea;

    @FXML
    private JFXTextField txtCodeFigure_Swell;

    @FXML
    private JFXTextField txtWetherRemarks_PSRO;

    @FXML
    private JFXTextField txtWetherRemarks_PObs;

    @FXML
    void onActionClose(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

        }catch (Exception e){
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(RainandSeaPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
