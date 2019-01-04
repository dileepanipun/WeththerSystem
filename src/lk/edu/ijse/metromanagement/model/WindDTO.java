package lk.edu.ijse.metromanagement.model;

public class WindDTO {

    private String windID;
    private String windDirection;
    private String firstRead;
    private String secondRead;
    private int frceInKmh;
    private int frceInKnots;
    private String mileagePer;
    private String wetherID;

    public WindDTO() {
    }

    public WindDTO(String windID, String windDirection, String firstRead, String secondRead, int frceInKmh, int frceInKnots, String mileagePer, String wetherID) {
        this.windID = windID;
        this.windDirection = windDirection;
        this.firstRead = firstRead;
        this.secondRead = secondRead;
        this.frceInKmh = frceInKmh;
        this.frceInKnots = frceInKnots;
        this.mileagePer = mileagePer;
        this.wetherID = wetherID;
    }

    public String getWindID() {
        return windID;
    }

    public void setWindID(String windID) {
        this.windID = windID;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getFirstRead() {
        return firstRead;
    }

    public void setFirstRead(String firstRead) {
        this.firstRead = firstRead;
    }

    public String getSecondRead() {
        return secondRead;
    }

    public void setSecondRead(String secondRead) {
        this.secondRead = secondRead;
    }

    public int getFrceInKmh() {
        return frceInKmh;
    }

    public void setFrceInKmh(int frceInKmh) {
        this.frceInKmh = frceInKmh;
    }

    public int getFrceInKnots() {
        return frceInKnots;
    }

    public void setFrceInKnots(int frceInKnots) {
        this.frceInKnots = frceInKnots;
    }

    public String getMileagePer() {
        return mileagePer;
    }

    public void setMileagePer(String mileagePer) {
        this.mileagePer = mileagePer;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    @Override
    public String toString() {
        return "WindDTO{" +
                "windID='" + windID + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", firstRead='" + firstRead + '\'' +
                ", secondRead='" + secondRead + '\'' +
                ", frceInKmh=" + frceInKmh +
                ", frceInKnots=" + frceInKnots +
                ", mileagePer='" + mileagePer + '\'' +
                ", wetherID='" + wetherID + '\'' +
                '}';
    }
}
