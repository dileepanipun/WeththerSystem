package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.edu.ijse.metromanagement.common.NotificationController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThermometerPaneController implements Initializable {

    @FXML
    private JFXTextField txtAsRead_CurrentDry;

    @FXML
    private JFXTextField txtAsRead_CurrentWet;

    @FXML
    private JFXTextField txtAsRead_MaxDry;

    @FXML
    private JFXTextField txtAsRead_MaxWet;

    @FXML
    private JFXTextField txtAsRead_MinDry;

    @FXML
    private JFXTextField txtAsRead_MinWet;

    @FXML
    private JFXTextField txtAsRead_MinOnGrass;

    @FXML
    private JFXTextField txtAfterReseting_CurrentDry;

    @FXML
    private JFXTextField txtAfterReseting_CurrentWet;

    @FXML
    private JFXTextField txtIndexCorr_CurDry;

    @FXML
    private JFXTextField txtIndexCorr_CurrentWet;

    @FXML
    private JFXTextField txtIndexCorr_MaxDry;

    @FXML
    private JFXTextField txtIndexCorr_MaxWet;

    @FXML
    private JFXTextField txtIndexCorr_MinDry;

    @FXML
    private JFXTextField txtIndexCorr_MinWet;

    @FXML
    private JFXTextField txtIndexCorr_MinOnGrass;

    @FXML
    private JFXTextField txtDewPoint_CurrDry;

    @FXML
    private JFXTextField txtDewPoint_MaxTemp;

    @FXML
    private JFXTextField txtDewPoint_MinTemp;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnUpdate;

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
            Logger.getLogger(ThermometerPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
