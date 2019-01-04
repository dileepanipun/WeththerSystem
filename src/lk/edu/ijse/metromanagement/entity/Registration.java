package lk.edu.ijse.metromanagement.entity;

public class Registration {

    private String registerID;
    private String regDate;
    private String userID;

    public Registration() {
    }

    public Registration(String registerID, String regDate, String userID) {
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
}
