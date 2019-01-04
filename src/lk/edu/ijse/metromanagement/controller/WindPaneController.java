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

public class WindPaneController implements Initializable {

    @FXML
    private JFXTextField windDrectionTxt;

    @FXML
    private JFXTextField meterFirstReadTxt;

    @FXML
    private JFXTextField meterSecReadTxt;

    @FXML
    private JFXTextField forceInKmhTxt;

    @FXML
    private JFXTextField forceInKnotsTxt;

    @FXML
    private JFXTextField milagePreTxt;

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void onActionClose(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

        }catch (Exception e){
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(WindPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
