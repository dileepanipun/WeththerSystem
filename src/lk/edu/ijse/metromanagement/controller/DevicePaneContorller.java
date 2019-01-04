package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.edu.ijse.metromanagement.business.custom.CompanyBO;
import lk.edu.ijse.metromanagement.business.custom.DeviceBO;
import lk.edu.ijse.metromanagement.business.custom.WetherCatogaryBO;
import lk.edu.ijse.metromanagement.business.custom.impl.CompanyBOImpl;
import lk.edu.ijse.metromanagement.business.custom.impl.DeviceBOImpl;
import lk.edu.ijse.metromanagement.business.custom.impl.WetherCatogaryBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.generator.IDGenerator;
import lk.edu.ijse.metromanagement.model.CompanyDTO;
import lk.edu.ijse.metromanagement.model.DeviceDTO;
import lk.edu.ijse.metromanagement.model.WetherCatogaryDTO;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DevicePaneContorller implements Initializable {

    @FXML
    private TableView<DeviceDTO> tableDevice;

    @FXML
    private JFXTextField txtDeviceID;

    @FXML
    private JFXTextField txtDeviceName;

    @FXML
    private JFXTextField txtWarentyPerioud;

    @FXML
    private JFXTextField txtRepairPerioud;

    @FXML
    private JFXDatePicker datePicRegDate;

    @FXML
    private JFXComboBox<CompanyDTO> comboCompanies;

    @FXML
    private JFXComboBox<WetherCatogaryDTO> comboCatogary;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    private static CompanyBO companyBO = new CompanyBOImpl();

    private static WetherCatogaryBO catogaryBO = new WetherCatogaryBOImpl();

    private static DeviceBO deviceBO = new DeviceBOImpl();

    @FXML
    void DeviceIDOnAction(ActionEvent event) {

    }

    @FXML
    void NameOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        if (NotificationController.createConfigAlert() == ButtonType.OK){
            boolean isDeleted = deviceBO.deleteDevice(tableDevice.getSelectionModel().getSelectedItem().getDeviceID());
            if (isDeleted){
                setDefault();
                loadAllDevices();
                NotificationController.createSuccesful("Successful","Device is deleted");
            }else {
                NotificationController.createError("Error","Something went wrong");
            }
        }
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws Exception {
        setDefault();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        DeviceDTO deviceDTO = new DeviceDTO(
                txtDeviceID.getText(),
                txtDeviceName.getText(),
                Integer.parseInt(txtWarentyPerioud.getText()),
                Integer.parseInt(txtRepairPerioud.getText()),
                datePicRegDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                comboCatogary.getSelectionModel().getSelectedItem().getCatogaryID(),
                comboCompanies.getSelectionModel().getSelectedItem().getCompanyID()
        );
        if (NotificationController.createConfigAlert() == ButtonType.OK){
            if (deviceBO.updateDevice(deviceDTO)){
                setDefault();
                loadAllDevices();
                NotificationController.createSuccesful("Successful","Device, "+deviceDTO.getDeviceID()+" updated");
            }else {
                NotificationController.createError("Error","Something went wrong");
            }
        }
    }

    @FXML
    void companyEditOnAction(ActionEvent event) throws Exception {
        Parent companyPane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/CompanyPane.fxml"));

        Scene scene = new Scene(companyPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onActionSave(ActionEvent event) throws Exception {
        String getRegisterDate = datePicRegDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WetherCatogaryDTO catogary = comboCatogary.getSelectionModel().getSelectedItem();
        DeviceDTO deviceDTO = new DeviceDTO(
                txtDeviceID.getText(),
                txtDeviceName.getText(),
                Integer.parseInt(txtWarentyPerioud.getText()),
                Integer.parseInt(txtRepairPerioud.getText()),
                getRegisterDate,
                catogary.getCatogaryID(),
                comboCompanies.getSelectionModel().getSelectedItem().getCompanyID()
        );
        boolean isAdded = deviceBO.addDevice(deviceDTO);
        if (isAdded) {
            setDefault();
            loadAllDevices();
            NotificationController.createSuccesful("Succesful", "Device is updated");
        } else {
            NotificationController.createSuccesful("Error", "Something went wrong. Plz try again later");
        }
    }

    @FXML
    void repairPerioudOnAction(ActionEvent event) {

    }

    @FXML
    void warrentyPeriouudOnAction(ActionEvent event) {

    }

    @FXML
    void onClickedDeviceTable(MouseEvent event) throws Exception {
        try {
            DeviceDTO selectedItem = tableDevice.getSelectionModel().getSelectedItem();
            comboCatogary.getSelectionModel().select(selectedItem.getWetherCatogaryDTO());
            comboCompanies.getSelectionModel().select(selectedItem.getCompanyDTO());
            txtDeviceID.setText(selectedItem.getDeviceID());
            txtDeviceName.setText(selectedItem.getName());
            txtWarentyPerioud.setText("" + selectedItem.getWarrentyPer());
            txtRepairPerioud.setText("" + selectedItem.getRepiredPer());
            datePicRegDate.setValue(LocalDate.parse(selectedItem.getRegisterDate()));
        }catch (NullPointerException ignore){
            NotificationController.createError("Error","Not selected");
        }
    }

    @FXML
    void searchByDateOnAction(ActionEvent event) throws Exception {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadAllDevices();
            loadCompanyId();
            loadCatIds();
            setDefault();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(DevicePaneContorller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadAllDevices() throws Exception {
        ArrayList<DeviceDTO> devices = deviceBO.getAllDevices();
        ObservableList<DeviceDTO> deviceList = FXCollections.observableArrayList(devices);
        tableDevice.setItems(deviceList);
        tableDevice.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("deviceID"));
        tableDevice.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableDevice.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("wetherCatogaryDTO"));
        tableDevice.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("companyDTO"));
        tableDevice.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("warrentyPer"));
        tableDevice.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("repiredPer"));
        tableDevice.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("registerDate"));
    }

    public void loadCompanyId() throws Exception {
        comboCompanies.getItems().setAll(companyBO.getAllCompanyIds());
    }

    public void loadCatIds() throws Exception {
        comboCatogary.getItems().setAll(catogaryBO.getAllWetherCatogary());
    }

    private void setDefault() throws Exception {
        txtDeviceID.setText(IDGenerator.getNewID("device","deviceID","DVI"));
        txtDeviceName.setText("");
        comboCatogary.getSelectionModel().selectFirst();
        comboCompanies.getSelectionModel().selectFirst();
        txtWarentyPerioud.setText("0");
        txtRepairPerioud.setText("0");
        datePicRegDate.setValue(LocalDate.now());
        txtDeviceName.requestFocus();
    }
}
