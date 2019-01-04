package lk.edu.ijse.metromanagement.entity;

public class Wether {

    private String wetherID;
    private String wTime;
    private String wDate;
    private String regID;

    public Wether() {
    }

    public Wether(String wetherID, String wTime, String wDate, String regID) {
        this.wetherID = wetherID;
        this.wTime = wTime;
        this.wDate = wDate;
        this.regID = regID;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    public String getwTime() {
        return wTime;
    }

    public void setwTime(String wTime) {
        this.wTime = wTime;
    }

    public String getwDate() {
        return wDate;
    }

    public void setwDate(String wDate) {
        this.wDate = wDate;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }
}
