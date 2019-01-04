package lk.edu.ijse.metromanagement.entity;

public class Thermometer {

    private String thermometerID;
    private int arCurrent;
    private int arMaxDry;
    private int arMaxWet;
    private int arMinDry;
    private int arMinWet;
    private int arMinOnGrass;
    private int sftRestMaxDry;
    private int sftRestMaxWet;
    private int icCurDry;
    private int icCurWet;
    private int icMaxDry;
    private int icMaxWet;
    private int icMinDry;
    private int icMinWet;
    private int icMinOnGrass;
    private int dpCurTemp;
    private int dpMaxTemps;
    private int dpMinTemps;
    private String wetherID;

    public Thermometer() {
    }

    public Thermometer(String thermometerID, int arCurrent, int arMaxDry, int arMaxWet, int arMinDry, int arMinWet, int arMinOnGrass, int sftRestMaxDry, int sftRestMaxWet, int icCurDry, int icCurWet, int icMaxDry, int icMaxWet, int icMinDry, int icMinWet, int icMinOnGrass, int dpCurTemp, int dpMaxTemps, int dpMinTemps, String wetherID) {
        this.thermometerID = thermometerID;
        this.arCurrent = arCurrent;
        this.arMaxDry = arMaxDry;
        this.arMaxWet = arMaxWet;
        this.arMinDry = arMinDry;
        this.arMinWet = arMinWet;
        this.arMinOnGrass = arMinOnGrass;
        this.sftRestMaxDry = sftRestMaxDry;
        this.sftRestMaxWet = sftRestMaxWet;
        this.icCurDry = icCurDry;
        this.icCurWet = icCurWet;
        this.icMaxDry = icMaxDry;
        this.icMaxWet = icMaxWet;
        this.icMinDry = icMinDry;
        this.icMinWet = icMinWet;
        this.icMinOnGrass = icMinOnGrass;
        this.dpCurTemp = dpCurTemp;
        this.dpMaxTemps = dpMaxTemps;
        this.dpMinTemps = dpMinTemps;
        this.wetherID = wetherID;
    }

    public String getThermometerID() {
        return thermometerID;
    }

    public void setThermometerID(String thermometerID) {
        this.thermometerID = thermometerID;
    }

    public int getArCurrent() {
        return arCurrent;
    }

    public void setArCurrent(int arCurrent) {
        this.arCurrent = arCurrent;
    }

    public int getArMaxDry() {
        return arMaxDry;
    }

    public void setArMaxDry(int arMaxDry) {
        this.arMaxDry = arMaxDry;
    }

    public int getArMaxWet() {
        return arMaxWet;
    }

    public void setArMaxWet(int arMaxWet) {
        this.arMaxWet = arMaxWet;
    }

    public int getArMinDry() {
        return arMinDry;
    }

    public void setArMinDry(int arMinDry) {
        this.arMinDry = arMinDry;
    }

    public int getArMinWet() {
        return arMinWet;
    }

    public void setArMinWet(int arMinWet) {
        this.arMinWet = arMinWet;
    }

    public int getArMinOnGrass() {
        return arMinOnGrass;
    }

    public void setArMinOnGrass(int arMinOnGrass) {
        this.arMinOnGrass = arMinOnGrass;
    }

    public int getSftRestMaxDry() {
        return sftRestMaxDry;
    }

    public void setSftRestMaxDry(int sftRestMaxDry) {
        this.sftRestMaxDry = sftRestMaxDry;
    }

    public int getSftRestMaxWet() {
        return sftRestMaxWet;
    }

    public void setSftRestMaxWet(int sftRestMaxWet) {
        this.sftRestMaxWet = sftRestMaxWet;
    }

    public int getIcCurDry() {
        return icCurDry;
    }

    public void setIcCurDry(int icCurDry) {
        this.icCurDry = icCurDry;
    }

    public int getIcCurWet() {
        return icCurWet;
    }

    public void setIcCurWet(int icCurWet) {
        this.icCurWet = icCurWet;
    }

    public int getIcMaxDry() {
        return icMaxDry;
    }

    public void setIcMaxDry(int icMaxDry) {
        this.icMaxDry = icMaxDry;
    }

    public int getIcMaxWet() {
        return icMaxWet;
    }

    public void setIcMaxWet(int icMaxWet) {
        this.icMaxWet = icMaxWet;
    }

    public int getIcMinDry() {
        return icMinDry;
    }

    public void setIcMinDry(int icMinDry) {
        this.icMinDry = icMinDry;
    }

    public int getIcMinWet() {
        return icMinWet;
    }

    public void setIcMinWet(int icMinWet) {
        this.icMinWet = icMinWet;
    }

    public int getIcMinOnGrass() {
        return icMinOnGrass;
    }

    public void setIcMinOnGrass(int icMinOnGrass) {
        this.icMinOnGrass = icMinOnGrass;
    }

    public int getDpCurTemp() {
        return dpCurTemp;
    }

    public void setDpCurTemp(int dpCurTemp) {
        this.dpCurTemp = dpCurTemp;
    }

    public int getDpMaxTemps() {
        return dpMaxTemps;
    }

    public void setDpMaxTemps(int dpMaxTemps) {
        this.dpMaxTemps = dpMaxTemps;
    }

    public int getDpMinTemps() {
        return dpMinTemps;
    }

    public void setDpMinTemps(int dpMinTemps) {
        this.dpMinTemps = dpMinTemps;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }
}
