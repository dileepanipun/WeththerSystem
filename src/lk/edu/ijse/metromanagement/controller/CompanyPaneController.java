package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.edu.ijse.metromanagement.business.custom.CompanyBO;
import lk.edu.ijse.metromanagement.business.custom.impl.CompanyBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.generator.IDGenerator;
import lk.edu.ijse.metromanagement.model.CompanyDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompanyPaneController implements Initializable {

    @FXML
    private JFXTextField txtCompaynID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtTelephoneNo;

    @FXML
    private JFXButton btnNew;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnClose;

    @FXML
    private TableView<CompanyDTO> tableComapny;

    private static CompanyBO companyBO = new CompanyBOImpl();

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        CompanyDTO selectedItem = tableComapny.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem.getCompanyID());
        boolean isDeleted = companyBO.deleteCompany(selectedItem.getCompanyID());
        if (isDeleted){
            getAllCompanies();
            setNewCompayDetails();
            NotificationController.createSuccesful("Successfull","Successfully deleted "+selectedItem.getName() + " Company");
        }
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws Exception {
        getAllCompanies();
        setNewCompayDetails();
    }

    private void setNewCompayDetails()  {
        try {
            txtCompaynID.setText(IDGenerator.getNewID("company", "companyID", "CMP"));
            txtName.setText("");
            txtAddress.setText("");
            txtTelephoneNo.setText("");
            txtName.requestFocus();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        boolean isUpdated = companyBO.updateCompany(new CompanyDTO(
                txtCompaynID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtTelephoneNo.getText()
        ));
        if (isUpdated){
            getAllCompanies();
            setNewCompayDetails();
            NotificationController.createSuccesful("Successfull","Successfully udated Company");
        }else {
            NotificationController.createError("Error","Something went Wrong");
        }
    }

    @FXML
    void onActionAddress(ActionEvent event) {
        txtTelephoneNo.requestFocus();
        txtTelephoneNo.selectAll();
    }

    @FXML
    void onActionCompanyID(ActionEvent event) throws Exception {
        CompanyDTO searchCompany = companyBO.searchCompany(txtCompaynID.getText());
        txtName.setText(searchCompany.getName());
        txtAddress.setText(searchCompany.getAddress());
        txtTelephoneNo.setText(searchCompany.getTelephoneNo());
    }

    @FXML
    void onActionName(ActionEvent event) {
        txtAddress.requestFocus();
        txtAddress.selectAll();
    }

    @FXML
    void onActionSave(ActionEvent event) throws Exception {
        boolean isAdded = companyBO.addCompany(new CompanyDTO(
                txtCompaynID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtTelephoneNo.getText()
        ));
        if (isAdded){
            getAllCompanies();
            setNewCompayDetails();
            NotificationController.createSuccesful("Successfull","Successfully added a new company");
        }else {
            NotificationController.createSuccesful("Attention","Something Went Wrong");
        }
    }

    @FXML
    void onActionTelephoneNumber(ActionEvent event) {
        btnSave.requestFocus();
    }

    @FXML
    void onActionClose(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void getRowDetail(MouseEvent event) {
        CompanyDTO selectedItem = tableComapny.getSelectionModel().getSelectedItem();

        txtCompaynID.setText(selectedItem.getCompanyID());
        txtName.setText(selectedItem.getName());
        txtAddress.setText(selectedItem.getAddress());
        txtTelephoneNo.setText(selectedItem.getTelephoneNo());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setNewCompayDetails();
            getAllCompanies();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(CompanyPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void getAllCompanies() throws Exception {
        ArrayList<CompanyDTO> companyList;
        try {
            companyList = companyBO.getAllCompany();
            ObservableList<CompanyDTO> companies = FXCollections.observableArrayList(companyList);
            tableComapny.setItems(companies);
            tableComapny.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("companyID"));
            tableComapny.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            tableComapny.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            tableComapny.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("telephoneNo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
