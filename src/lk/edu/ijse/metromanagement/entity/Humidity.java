package lk.edu.ijse.metromanagement.entity;

public class Humidity {

    private String humidityID;
    private int vpCurrent;
    private int vpMaxTemps;
    private int vpMinTemps;
    private int rhCurrent;
    private int rhMaxTemps;
    private int rhMinTemps;
    private String visibility;
    private String wetherID;

    public Humidity(String humidityID, int vpCurrent, int vpMaxTemps, int vpMinTemps, int rhCurrent, int rhMaxTemps, int rhMinTemps, String visibility, String wetherID) {
        this.humidityID = humidityID;
        this.vpCurrent = vpCurrent;
        this.vpMaxTemps = vpMaxTemps;
        this.vpMinTemps = vpMinTemps;
        this.rhCurrent = rhCurrent;
        this.rhMaxTemps = rhMaxTemps;
        this.rhMinTemps = rhMinTemps;
        this.visibility = visibility;
        this.wetherID = wetherID;
    }

    public String getHumidityID() {
        return humidityID;
    }

    public void setHumidityID(String humidityID) {
        this.humidityID = humidityID;
    }

    public int getVpCurrent() {
        return vpCurrent;
    }

    public void setVpCurrent(int vpCurrent) {
        this.vpCurrent = vpCurrent;
    }

    public int getVpMaxTemps() {
        return vpMaxTemps;
    }

    public void setVpMaxTemps(int vpMaxTemps) {
        this.vpMaxTemps = vpMaxTemps;
    }

    public int getVpMinTemps() {
        return vpMinTemps;
    }

    public void setVpMinTemps(int vpMinTemps) {
        this.vpMinTemps = vpMinTemps;
    }

    public int getRhCurrent() {
        return rhCurrent;
    }

    public void setRhCurrent(int rhCurrent) {
        this.rhCurrent = rhCurrent;
    }

    public int getRhMaxTemps() {
        return rhMaxTemps;
    }

    public void setRhMaxTemps(int rhMaxTemps) {
        this.rhMaxTemps = rhMaxTemps;
    }

    public int getRhMinTemps() {
        return rhMinTemps;
    }

    public void setRhMinTemps(int rhMinTemps) {
        this.rhMinTemps = rhMinTemps;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }
}
