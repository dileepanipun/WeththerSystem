package lk.edu.ijse.metromanagement.entity;

public class WetherCatogary {

    private String catogaryID;
    private String cTypes;

    public WetherCatogary() {
    }

    public WetherCatogary(String catogaryID, String cTypes) {
        this.catogaryID = catogaryID;
        this.cTypes = cTypes;
    }

    public String getCatogaryID() {
        return catogaryID;
    }

    public void setCatogaryID(String catogaryID) {
        this.catogaryID = catogaryID;
    }

    public String getcTypes() {
        return cTypes;
    }

    public void setcTypes(String cTypes) {
        this.cTypes = cTypes;
    }
}
