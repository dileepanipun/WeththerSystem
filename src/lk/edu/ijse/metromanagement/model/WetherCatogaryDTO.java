package lk.edu.ijse.metromanagement.model;

import java.util.Objects;

public class WetherCatogaryDTO {
    
    private String catogaryID;
    private String cTypes;

    public WetherCatogaryDTO() {
    }

    public WetherCatogaryDTO(String catogaryID, String cTypes) {
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

    @Override
    public String toString() {
        return cTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WetherCatogaryDTO that = (WetherCatogaryDTO) o;
        return Objects.equals(catogaryID, that.catogaryID);
    }

}
