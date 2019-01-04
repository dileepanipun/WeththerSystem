package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HumidityPaneController implements Initializable {

    @FXML
    private JFXTextField txtVaporPressure_Current;

    @FXML
    private JFXTextField txtVaporPressure_MaxTemps;

    @FXML
    private JFXTextField txtVaporPrressure_MinTemps;

    @FXML
    private JFXTextField txtRelativeHumidity_Current;

    @FXML
    private JFXTextField txtRelativeHumidity_MaxTemps;

    @FXML
    private JFXTextField txtRelativeHumidity_MinTemps;

    @FXML
    private JFXTextField txtVisibility;

    @FXML
    void relativeHumidity_Current_OnAction(ActionEvent event) {

    }

    @FXML
    void relativeHumidity_MaxTemps_OnAction(ActionEvent event) {

    }

    @FXML
    void relativeHumidity_MinTemps_OnAction(ActionEvent event) {

    }

    @FXML
    void vaporPressure_Current_OnAction(ActionEvent event) {

    }

    @FXML
    void vaporPressure_MInTemps_OnAction(ActionEvent event) {

    }

    @FXML
    void vaporPressure_MaxTemps_OnAction(ActionEvent event) {

    }

    @FXML
    void visibility_OnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

        }catch (Exception e){

        }
    }
}
