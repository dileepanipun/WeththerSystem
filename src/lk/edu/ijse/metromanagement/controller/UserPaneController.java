package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.edu.ijse.metromanagement.business.custom.MetUserBO;
import lk.edu.ijse.metromanagement.business.custom.RegistrationBO;
import lk.edu.ijse.metromanagement.business.custom.impl.MetUserBOImpl;
import lk.edu.ijse.metromanagement.business.custom.impl.RegistrationBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.generator.IDGenerator;
import lk.edu.ijse.metromanagement.model.MetUserDTO;
import lk.edu.ijse.metromanagement.model.RegistrationDTO;
import lk.edu.ijse.metromanagement.validation.LoginValidation;
import lk.edu.ijse.metromanagement.validation.ValidationController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserPaneController implements Initializable {

    @FXML
    private JFXTextField txtUserID;

    @FXML
    private JFXTextField txtFirstName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtRegID;

    @FXML
    private JFXDatePicker dateRegDate;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtTelphoneNo;

    @FXML
    private JFXDatePicker dateDateOfBirth;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField pwPassword;

    @FXML
    private TableView<MetUserDTO> tblUser;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXRadioButton rbtnSynopCoder;

    @FXML
    private ToggleGroup userState;

    @FXML
    private JFXRadioButton rbtnEmployee;

    @FXML
    private ImageView imgFirstnameEmpty;

    @FXML
    private ImageView imgLastnameEmpety;

    @FXML
    private ImageView imgTelephoneNo;

    @FXML
    private ImageView imgNicEmpty;

    @FXML
    private ImageView imgUserState;

    @FXML
    private ImageView imgUserName;

    @FXML
    private ImageView ImgPassword;

    @FXML
    private ImageView imgDOB;

    @FXML
    private ImageView imgAddress;

    private static MetUserBO metUserBO = new MetUserBOImpl();

    private static RegistrationBO registrationBO = new RegistrationBOImpl();

    @FXML
    void activateLoginDetails(ActionEvent event) {
        txtUserName.setDisable(false);
        pwPassword.setDisable(false);
    }

    @FXML
    void deactivateLoginDetails(ActionEvent event) {
        txtUserName.setDisable(true);
        pwPassword.setDisable(true);
        txtUserName.setText("");
        pwPassword.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        if (NotificationController.createConfigAlert() == ButtonType.OK) {
            boolean isDeleted = metUserBO.deleteUser(tblUser.getSelectionModel().getSelectedItem().getUserID());
            if (isDeleted) {
                setTableDetails();
                setDefaultValues();
                NotificationController.createSuccesful("Complete", "Succefully Deleted");
            } else {
                NotificationController.createError("Error", "Something went worng try again");
            }
        }
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws Exception {
        setDefaultValues();
        setTableDetails();
        setDefaultValues();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        String userID = txtUserID.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String dob = dateDateOfBirth.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nicNo = txtNIC.getText();
        String telehoneNo = txtTelphoneNo.getText();
        String userName = txtUserName.getText();
        String userState = this.userState.getSelectedToggle().getUserData().toString();
        String email = txtEmail.getText();
        String password = pwPassword.getText();
        String registerID = txtRegID.getText();
        String regDate = dateRegDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if(ValidationController.name(txtFirstName)){
            if (ValidationController.name(txtLastName)){
                if (ValidationController.name(txtAddress)){
                    if (ValidationController.date(dob)){
                        if (ValidationController.nicValidation(txtNIC)){
                            if (ValidationController.phoneNumber(txtTelphoneNo)){
                                boolean saved = metUserBO.addUser(new MetUserDTO(
                                        userID,
                                        firstName,
                                        lastName,
                                        address,
                                        dob,
                                        nicNo,
                                        telehoneNo,
                                        userName,
                                        userState,
                                        email,
                                        password,
                                        new RegistrationDTO(
                                                registerID,
                                                userID,
                                                regDate
                                        )
                                ));

                                if (saved) {
                                    setTableDetails();
                                    setDefaultValues();
                                    NotificationController.createSuccesful("Completed", "Successfully add the user");
                                } else {
                                    NotificationController.createError("Error", "Something went Wrong try again later");
                                }
                            }else {
                                NotificationController.createError("Error","Invalid Email");
                                txtTelphoneNo.requestFocus();
                            }
                        }else {
                            NotificationController.createError("Error","Invalid NIC");
                            txtNIC.requestFocus();
                        }
                    }else {
                        NotificationController.createError("Error","Invalid Date");
                        dateDateOfBirth.requestFocus();
                    }
                }else {
                    NotificationController.createError("Error","Invalid Address");
                    txtAddress.requestFocus();
                }
            }else {
                NotificationController.createError("Error","Invalid Last Name");
                txtLastName.requestFocus();
            }
        }else {
            NotificationController.createError("Error","Invalid First Name");
            txtFirstName.requestFocus();
        }
    }

    @FXML
    void btnUpdateOnAvtion(ActionEvent event) throws Exception {
        if (NotificationController.createConfigAlert() == ButtonType.OK){
            boolean isUpdated = metUserBO.updateUser(new MetUserDTO(
                    txtUserID.getText(),
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    txtAddress.getText(),
                    dateDateOfBirth.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    txtNIC.getText(),
                    txtTelphoneNo.getText(),
                    txtUserName.getText(),
                    userState.getSelectedToggle().getUserData().toString(),
                    txtEmail.getText(),
                    pwPassword.getText(),
                    new RegistrationDTO(
                            txtRegID.getText(),
                            txtUserID.getText(),
                            dateRegDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    )
            ));
            if (isUpdated) {
                setDefaultValues();
                setTableDetails();
                setDefaultValues();
                NotificationController.createSuccesful("Complete", "User succesfully updated");
            } else {
                NotificationController.createError("Error", "Something went wrong try again later");
            }
        }

    }

    @FXML
    void selectUser(MouseEvent event) throws Exception {
        MetUserDTO selectedItem = tblUser.getSelectionModel().getSelectedItem();
        RegistrationDTO searchResult = registrationBO.searchRegistration(selectedItem.getUserID());

        txtUserID.setText(selectedItem.getUserID());
        txtFirstName.setText(selectedItem.getFirstName());
        txtLastName.setText(selectedItem.getLastName());
        txtAddress.setText(selectedItem.getAddress());
        dateDateOfBirth.setValue(LocalDate.parse(selectedItem.getDob()));
        txtNIC.setText(selectedItem.getNicNo());
        txtEmail.setText(selectedItem.getEmail());
        txtTelphoneNo.setText(selectedItem.getTelephone());
        if (selectedItem.getUserState().equalsIgnoreCase("SynopCoder")){
            userState.selectToggle(rbtnSynopCoder);
            txtUserName.setDisable(false);
            pwPassword.setDisable(false);
        }else {
            userState.selectToggle(rbtnEmployee);
            txtUserName.setDisable(true);
            pwPassword.setDisable(true);
            txtUserName.setText("");
            pwPassword.setText("");
        }
        txtUserName.setText(selectedItem.getUserName());
        pwPassword.setText(selectedItem.getPassword());
        txtRegID.setText(searchResult.getRegisterID());
        dateRegDate.setValue(LocalDate.parse(searchResult.getRegDate()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setDefaultValues();
            setTableDetails();
            setRadioButtonValues();
        } catch (Exception e) {
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(UserPaneController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setRadioButtonValues() {
        rbtnEmployee.setUserData("Employee");
        rbtnSynopCoder.setUserData("SynopCoder");
    }

    private void setTableDetails() throws Exception {
        ArrayList<MetUserDTO> users = metUserBO.getAllUsers();
        ObservableList<MetUserDTO> userList = FXCollections.observableArrayList(users);
        tblUser.setItems(userList);
        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("userID"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblUser.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        tblUser.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tblUser.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblUser.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("userState"));
    }

    private void setDefaultValues() throws Exception {
        txtUserID.setText(IDGenerator.getNewID("metuser", "userid", "MTU"));
        txtRegID.setText(IDGenerator.getNewID("registration", "registerID", "REG"));
        dateRegDate.setValue(LocalDate.now());
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtNIC.setText("");
        txtEmail.setText("");
        dateDateOfBirth.setValue(LocalDate.now());
        txtTelphoneNo.setText("");
        userState.selectToggle(rbtnSynopCoder);
        if (rbtnSynopCoder.isSelected()){
            txtUserName.setDisable(false);
            pwPassword.setDisable(false);
        }else {
            txtUserName.setDisable(true);
            pwPassword.setDisable(true);
            txtUserName.setText("");
            pwPassword.setText("");
        }
        txtUserName.setText("");
        pwPassword.setText("");
        txtFirstName.requestFocus();
    }
}
