package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.edu.ijse.metromanagement.business.custom.WetherBO;
import lk.edu.ijse.metromanagement.business.custom.impl.WetherBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.model.WetherDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchPaneController implements Initializable {

    @FXML
    private TableView<WetherDTO> tableWether;

    @FXML
    private JFXTextField txtWetherID;

    @FXML
    private JFXDatePicker dateWetherDate;

    @FXML
    private JFXComboBox<WetherDTO> comboTimeZone;

    private static WetherBO wetherBO = new WetherBOImpl();

    @FXML
    void selectWether(MouseEvent event) {

    }

    @FXML
    void showBarometer(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/BarometerPane.fxml");
    }

    @FXML
    void showCloud(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/");
    }

    @FXML
    void showHumidity(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/Humidity.fxml");
    }

    @FXML
    void showRainSea(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/RainandSeaPane.fxml");
    }

    @FXML
    void showThermometer(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/ThermometerPane.fxml");
    }

    @FXML
    void showWind(ActionEvent event) throws Exception {
        showPanel("/lk/edu/ijse/metromanagement/view/WindPane.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //setAllWetherData();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(SearchPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setAllWetherData() throws Exception {
        ArrayList<WetherDTO> dtos = wetherBO.getAllWether();
        ObservableList<WetherDTO> deviceList = FXCollections.observableArrayList(dtos);
        tableWether.setItems(deviceList);
        tableWether.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("wetherId"));
        tableWether.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("wTime"));
        tableWether.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("wDate"));
        tableWether.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("regID"));
    }

    private void showPanel(String url) throws Exception {
        AnchorPane barometerPane = FXMLLoader.load(this.getClass().getResource(url));

        Scene scene = new Scene(barometerPane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.show();
    }
}
