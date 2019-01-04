package lk.edu.ijse.metromanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeObject;
import lk.edu.ijse.metromanagement.business.custom.MetUserBO;
import lk.edu.ijse.metromanagement.business.custom.impl.MetUserBOImpl;
import lk.edu.ijse.metromanagement.common.NotificationController;
import lk.edu.ijse.metromanagement.model.MetUserDTO;
import lk.edu.ijse.metromanagement.validation.LoginValidation;
import lk.edu.ijse.metromanagement.validation.ValidationController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField userNameText;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXButton btnLogin;

    private MetUserBO metUserBO = new MetUserBOImpl();

    @FXML
    void loginHandleOnAction(ActionEvent event) throws Exception {
        MetUserDTO metUserDTO = metUserBO.searchUserByID(userNameText.getText().trim());
        if (ValidationController.name(userNameText)) {
            if (ValidationController.isEmpety(passwordText)) {
                if (userNameText.getText().equals(metUserDTO.getUserName())) {
                    if (passwordText.getText().equals(metUserDTO.getPassword())) {
                        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/metromanagement/view/HomePane.fxml"));
                        Scene scene = new Scene(load);
                        Stage stage = (Stage) this.btnLogin.getScene().getWindow();
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                    } else {
                        NotificationController.createError("Error", "Password is incorrect");
                    }
                } else {
                    NotificationController.createError("Error", "User name is incorrect");
                }
            }else {
                NotificationController.createError("Error","Password Cannot be empety");
            }
        }else {
            NotificationController.createError("Error", "User name cannot be empety");
            userNameText.requestFocus();
        }
    }

    @FXML
    void userNamehandleOnAction(ActionEvent event) {
        if(LoginValidation.cheackUserName(userNameText)){
            passwordText.requestFocus();
        }else {
            userNameText.selectAll();
        }
    }

    @FXML
    void passwordhandleOnAction(ActionEvent event) {
        if(LoginValidation.cheackPassword(passwordText)){
            passwordText.requestFocus();
        }else {
            passwordText.selectAll();
        }
    }

    public void cancel_OnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void setToolTips() {
        Tooltip tooltip = new Tooltip();
        tooltip.setFont(new Font(11));
        tooltip.setText("Login btn");
        btnLogin.setTooltip(tooltip);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setToolTips();
        }catch (Exception e){
            NotificationController.createError("Error", "Something Went Wrong "+ e.getMessage());
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
