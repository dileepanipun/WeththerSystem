package lk.edu.ijse.metromanagement.validation;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.metromanagement.common.NotificationController;

public class LoginValidation {
    public static boolean validateUserDetails(JFXTextField txtUserName, JFXPasswordField pwPasword){
        if(ValidationController.isEmpety(txtUserName)){
            if (ValidationController.isEmpety(pwPasword)){
                return true;
            }else {
                return cheackUserName(txtUserName) || cheackPassword(pwPasword);
            }
        }else {
            return cheackPassword(pwPasword) || cheackUserName(txtUserName);
        }
    }

    public static boolean cheackUserName(JFXTextField txtUserName) {
        if(ValidationController.isEmpety(txtUserName)){
            return true;
        }else {
            NotificationController.createCustom("Incorrect UserName","User Name Cannot Be Empety","/lk/edu/ijse/metromanagement/assest/newError.png");
            return false;
        }

    }

    public static boolean cheackPassword(JFXPasswordField pwPassword) {
        if(ValidationController.isEmpety(pwPassword)){
            return true;
        }else {
            NotificationController.createCustom("Incorrect Password","Password Cannot Be Empety","/lk/edu/ijse/metromanagement/assest/password.png");
            return false;
        }

    }

}
