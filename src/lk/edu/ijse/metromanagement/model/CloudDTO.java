package lk.edu.ijse.metromanagement.model;

public class CloudDTO {

    private String cloudID;
    private int lcAmount;
    private String lcFrom;
    private int lcDirection;
    private int mcAmount;
    private String mcFrom;
    private int mcDirection;
    private int hcAmount;
    private String hcFrom;
    private int hcDirection;
    private int sgAmount;
    private int sgForm;
    private int sgHeight;
    private int totalAmount;
    private String wetherID;

    public CloudDTO() {
    }

    public CloudDTO(String cloudID, int lcAmount, String lcFrom, int lcDirection, int mcAmount, String mcFrom, int mcDirection, int hcAmount, String hcFrom, int hcDirection, int sgAmount, int sgForm, int sgHeight, int totalAmount, String wetherID) {
        this.cloudID = cloudID;
        this.lcAmount = lcAmount;
        this.lcFrom = lcFrom;
        this.lcDirection = lcDirection;
        this.mcAmount = mcAmount;
        this.mcFrom = mcFrom;
        this.mcDirection = mcDirection;
        this.hcAmount = hcAmount;
        this.hcFrom = hcFrom;
        this.hcDirection = hcDirection;
        this.sgAmount = sgAmount;
        this.sgForm = sgForm;
        this.sgHeight = sgHeight;
        this.totalAmount = totalAmount;
        this.wetherID = wetherID;
    }

    public String getCloudID() {
        return cloudID;
    }

    public void setCloudID(String cloudID) {
        this.cloudID = cloudID;
    }

    public int getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(int lcAmount) {
        this.lcAmount = lcAmount;
    }

    public String getLcFrom() {
        return lcFrom;
    }

    public void setLcFrom(String lcFrom) {
        this.lcFrom = lcFrom;
    }

    public int getLcDirection() {
        return lcDirection;
    }

    public void setLcDirection(int lcDirection) {
        this.lcDirection = lcDirection;
    }

    public int getMcAmount() {
        return mcAmount;
    }

    public void setMcAmount(int mcAmount) {
        this.mcAmount = mcAmount;
    }

    public String getMcFrom() {
        return mcFrom;
    }

    public void setMcFrom(String mcFrom) {
        this.mcFrom = mcFrom;
    }

    public int getMcDirection() {
        return mcDirection;
    }

    public void setMcDirection(int mcDirection) {
        this.mcDirection = mcDirection;
    }

    public int getHcAmount() {
        return hcAmount;
    }

    public void setHcAmount(int hcAmount) {
        this.hcAmount = hcAmount;
    }

    public String getHcFrom() {
        return hcFrom;
    }

    public void setHcFrom(String hcFrom) {
        this.hcFrom = hcFrom;
    }

    public int getHcDirection() {
        return hcDirection;
    }

    public void setHcDirection(int hcDirection) {
        this.hcDirection = hcDirection;
    }

    public int getSgAmount() {
        return sgAmount;
    }

    public void setSgAmount(int sgAmount) {
        this.sgAmount = sgAmount;
    }

    public int getSgForm() {
        return sgForm;
    }

    public void setSgForm(int sgForm) {
        this.sgForm = sgForm;
    }

    public int getSgHeight() {
        return sgHeight;
    }

    public void setSgHeight(int sgHeight) {
        this.sgHeight = sgHeight;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    @Override
    public String toString() {
        return "CloudDTO{" +
                "cloudID='" + cloudID + '\'' +
                ", lcAmount=" + lcAmount +
                ", lcFrom='" + lcFrom + '\'' +
                ", lcDirection=" + lcDirection +
                ", mcAmount=" + mcAmount +
                ", mcFrom='" + mcFrom + '\'' +
                ", mcDirection=" + mcDirection +
                ", hcAmount=" + hcAmount +
                ", hcFrom='" + hcFrom + '\'' +
                ", hcDirection=" + hcDirection +
                ", sgAmount=" + sgAmount +
                ", sgForm=" + sgForm +
                ", sgHeight=" + sgHeight +
                ", totalAmount=" + totalAmount +
                ", wetherID='" + wetherID + '\'' +
                '}';
    }
}
