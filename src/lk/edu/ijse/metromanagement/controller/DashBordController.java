package lk.edu.ijse.metromanagement.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import lk.edu.ijse.metromanagement.business.custom.*;
import lk.edu.ijse.metromanagement.business.custom.impl.*;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.model.ThermometerDTO;
import lk.edu.ijse.metromanagement.model.WetherDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashBordController implements Initializable {

    @FXML
    private Label lblCLDtemp;

    @FXML
    private Label lblWind;

    @FXML
    private Label lblCloud;

    @FXML
    private Label lblTemperature;

    @FXML
    private Label txtBarometerMax;

    @FXML
    private Label lblBarometerMIn;

    @FXML
    private Label lblBarometer;

    @FXML
    private Label lblRain;

    @FXML
    private ProgressIndicator prIComfirtLevel;

    @FXML
    private Label lblHumidity;

    private static WetherBO wetherBO = new WetherBOImpl();

    private static BarometerBO barometerBO = new BarometerBOImpl();

    private static ThermometerBO thermometerBO = new ThermometerBOImpl();

    private static HumidityBO humidityBO = new HumidityBOImpl();

    private static CloudBO cloudBO = new CloudBOImpl();

    private static RainBO rainBO = new RainBOImpl();

    private static WindBO windBO = new WindBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setValues();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(DashBordController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setValues() throws Exception {
        String wetherID = wetherBO.searchLastWether().getWetherID();
        ThermometerDTO thermometerDTO = thermometerBO.searchThermometer("WET010");
        lblTemperature.setText(thermometerDTO.toString());
    }
}
