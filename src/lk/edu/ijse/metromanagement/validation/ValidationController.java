package lk.edu.ijse.metromanagement.validation;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public class ValidationController {

    public static boolean isEmpety(JFXTextField textFild){
        if(textFild.getText().trim() != null && !textFild.getText().trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isEmpety(JFXPasswordField textFild){
        if(textFild.getText().trim() != null && !textFild.getText().trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean phoneNumber(JFXTextField textFild) {
        String txt = textFild.getText().trim();
        if (txt.matches("^[0-9]{10}$")) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean priceText(JFXTextField textField) {
        String text = textField.getText().trim();
        if (text.matches("[0-9]+[.]?[0-9]{0,2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean nicValidation(JFXTextField nicTextField) {
        String text = nicTextField.getText().trim();
        if (text.matches("[0-9]{9}[vV]")) {
            return true;
        } else {

            return false;
        }

    }

    public static boolean dobValidation(JFXTextField dobTextField) {
        String text = dobTextField.getText().trim();
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOnly(JFXTextField textField) {
        String text = textField.getText().trim();
        if (text.matches("^[\\d]*")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean name(JFXTextField textFild) {
        String text = textFild.getText();
        if (textFild.getText().trim() != null && !textFild.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean date(String text) {
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean time(JFXTextField textFild) {
        String text = textFild.getText().trim();
        if (text.matches("^\\d\\d:\\d\\d$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validationEmail(JFXTextField textField) {
        String text = textField.getText().trim();
        if (text.matches("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$")) {
            return true;
        }else{
            return false;
        }
    }
}
