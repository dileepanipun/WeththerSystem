package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.db.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportsPaneController implements Initializable {

    @FXML
    private JFXButton btnLastWReprot;

    @FXML
    private JFXButton btnWeekReport;

    @FXML
    void allCompany(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/AllCompanies.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(ReportsPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void allMachines(ActionEvent event) {

    }

    @FXML
    void allMemebers(ActionEvent event) {

    }

    @FXML
    void barometerMachines(ActionEvent event) {

    }

    @FXML
    void lastWetherReport(ActionEvent event) {

    }

    @FXML
    void rainMeterMachines(ActionEvent event) {

    }

    @FXML
    void seaStateMachines(ActionEvent event) {

    }

    @FXML
    void thermometerMachines(ActionEvent event) {

    }

    @FXML
    void todayBarometer(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/BarometerDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todayCloud(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/CloudDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todayHumidity(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/HumdityDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todayRain(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/RainDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todaySea(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/SeaStateDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todayThermometer(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/TodayThermometer.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void todayWind(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/lk/edu/ijse/metromanagement/report/WindDetails.jasper");
        HashMap hashMap = new HashMap();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream,hashMap,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void weekReport(ActionEvent event) {

    }

    @FXML
    void windMeterMachines(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
