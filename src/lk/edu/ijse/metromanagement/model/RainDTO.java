package lk.edu.ijse.metromanagement.model;

public class RainDTO {

    private String rainID;
    private double lastObs;
    private double lastRoute;
    private double per8Hrs;
    private double janFirst;
    private String wetherID;

    public RainDTO() {
    }

    public RainDTO(String rainID, double lastObs, double lastRoute, double per8Hrs, double janFirst, String wetherID) {
        this.rainID = rainID;
        this.lastObs = lastObs;
        this.lastRoute = lastRoute;
        this.per8Hrs = per8Hrs;
        this.janFirst = janFirst;
        this.wetherID = wetherID;
    }

    public String getRainID() {
        return rainID;
    }

    public void setRainID(String rainID) {
        this.rainID = rainID;
    }

    public double getLastObs() {
        return lastObs;
    }

    public void setLastObs(double lastObs) {
        this.lastObs = lastObs;
    }

    public double getLastRoute() {
        return lastRoute;
    }

    public void setLastRoute(double lastRoute) {
        this.lastRoute = lastRoute;
    }

    public double getPer8Hrs() {
        return per8Hrs;
    }

    public void setPer8Hrs(double per8Hrs) {
        this.per8Hrs = per8Hrs;
    }

    public double getJanFirst() {
        return janFirst;
    }

    public void setJanFirst(double janFirst) {
        this.janFirst = janFirst;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    @Override
    public String toString() {
        return "RainDTO{" +
                "rainID='" + rainID + '\'' +
                ", lastObs=" + lastObs +
                ", lastRoute=" + lastRoute +
                ", per8Hrs=" + per8Hrs +
                ", janFirst=" + janFirst +
                ", wetherID='" + wetherID + '\'' +
                '}';
    }
}
