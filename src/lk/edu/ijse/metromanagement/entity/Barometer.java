package lk.edu.ijse.metromanagement.entity;

import java.math.BigDecimal;

public class Barometer {

    private String barometerID;
    private double attdThermo;
    private double asReadInch;
    private double mbsLevel;
    private double nearstMbsLevel;
    private int baroTendancy;
    private String wetherID;

    public Barometer() {

    }

    public Barometer(String barometerID, double attdThermo, double asReadInch, double mbsLevel, double nearstMbsLevel, int baroTendancy, String wetherID) {
        this.barometerID = barometerID;
        this.attdThermo = attdThermo;
        this.asReadInch = asReadInch;
        this.mbsLevel = mbsLevel;
        this.nearstMbsLevel = nearstMbsLevel;
        this.baroTendancy = baroTendancy;
        this.wetherID = wetherID;
    }

    public String getBarometerID() {
        return barometerID;
    }

    public void setBarometerID(String barometerID) {
        this.barometerID = barometerID;
    }

    public double getAttdThermo() {
        return attdThermo;
    }

    public void setAttdThermo(double attdThermo) {
        this.attdThermo = attdThermo;
    }

    public double getAsReadInch() {
        return asReadInch;
    }

    public void setAsReadInch(double asReadInch) {
        this.asReadInch = asReadInch;
    }

    public double getMbsLevel() {
        return mbsLevel;
    }

    public void setMbsLevel(double mbsLevel) {
        this.mbsLevel = mbsLevel;
    }

    public double getNearstMbsLevel() {
        return nearstMbsLevel;
    }

    public void setNearstMbsLevel(double nearstMbsLevel) {
        this.nearstMbsLevel = nearstMbsLevel;
    }

    public int getBaroTendancy() {
        return baroTendancy;
    }

    public void setBaroTendancy(int baroTendancy) {
        this.baroTendancy = baroTendancy;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }
}
