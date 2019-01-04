package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import lk.edu.ijse.metromanagement.common.NotificationController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarometerPaneController implements Initializable {

    @FXML
    private JFXTextField txtAttdThermo;

    @FXML
    private JFXTextField txtAsReadInInches;

    @FXML
    private JFXTextField txtLevelMbs;

    @FXML
    private JFXTextField txtGMLevelMBS;

    @FXML
    private JFXTextField txtBaroTendancy;

    @FXML
    private JFXCheckBox rbtnNegetive;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClose;

    @FXML
    void asReadOnAction(ActionEvent event) {

    }

    @FXML
    void attdThermoOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void gmLevelMBSOnAction(ActionEvent event) {

    }

    @FXML
    void levelMBSOnAction(ActionEvent event) {

    }

    @FXML
    void onActionClose(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void tendencyOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

        }catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(BarometerPaneController  .class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
