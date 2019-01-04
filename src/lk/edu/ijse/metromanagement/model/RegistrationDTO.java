package lk.edu.ijse.metromanagement.model;

import java.awt.*;

public class RegistrationDTO {

    private String registerID;
    private String regDate;
    private String userID;

    public RegistrationDTO(String registerID, String regDate, String userID) {
        this.registerID = registerID;
        this.regDate = regDate;
        this.userID = userID;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registerID='" + registerID + '\'' +
                ", regDate=" + regDate +
                ", userID='" + userID + '\'' +
                '}';
    }
}
