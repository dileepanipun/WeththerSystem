package lk.edu.ijse.metromanagement.entity;

public class SeaState {

    private String seaStateID;
    private String seaCodeFigure;
    private String swellCodeFigure;
    private int wValue;
    private int w1Value;
    private int wwValue;
    private String wetherID;

    public SeaState() {
    }

    public SeaState(String seaStateID, String seaCodeFigure, String swellCodeFigure, int wValue, int w1Value, int wwValue, String wetherID) {
        this.seaStateID = seaStateID;
        this.seaCodeFigure = seaCodeFigure;
        this.swellCodeFigure = swellCodeFigure;
        this.wValue = wValue;
        this.w1Value = w1Value;
        this.wwValue = wwValue;
        this.wetherID = wetherID;
    }

    public String getSeaStateID() {
        return seaStateID;
    }

    public void setSeaStateID(String seaStateID) {
        this.seaStateID = seaStateID;
    }

    public String getSeaCodeFigure() {
        return seaCodeFigure;
    }

    public void setSeaCodeFigure(String seaCodeFigure) {
        this.seaCodeFigure = seaCodeFigure;
    }

    public String getSwellCodeFigure() {
        return swellCodeFigure;
    }

    public void setSwellCodeFigure(String swellCodeFigure) {
        this.swellCodeFigure = swellCodeFigure;
    }

    public int getwValue() {
        return wValue;
    }

    public void setwValue(int wValue) {
        this.wValue = wValue;
    }

    public int getW1Value() {
        return w1Value;
    }

    public void setW1Value(int w1Value) {
        this.w1Value = w1Value;
    }

    public int getWwValue() {
        return wwValue;
    }

    public void setWwValue(int wwValue) {
        this.wwValue = wwValue;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    @Override
    public String toString() {
        return "SeaState{" +
                "seaStateID='" + seaStateID + '\'' +
                ", seaCodeFigure='" + seaCodeFigure + '\'' +
                ", swellCodeFigure='" + swellCodeFigure + '\'' +
                ", wValue=" + wValue +
                ", w1Value=" + w1Value +
                ", wwValue=" + wwValue +
                ", wetherID='" + wetherID + '\'' +
                '}';
    }
}
