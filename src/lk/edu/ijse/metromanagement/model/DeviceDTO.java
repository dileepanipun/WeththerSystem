package lk.edu.ijse.metromanagement.model;

public class DeviceDTO {

    private String deviceID;
    private String name;
    private int warrentyPer;
    private int repiredPer;
    private String registerDate;
    private String catogaryID;
    private String companyID;
    private CompanyDTO companyDTO;
    private WetherCatogaryDTO wetherCatogaryDTO;

    public DeviceDTO() {
    }

    public DeviceDTO(String deviceID, String name, int warrentyPer, int repiredPer, String registerDate, String catogaryID, String companyID) {
        this.deviceID = deviceID;
        this.name = name;
        this.warrentyPer = warrentyPer;
        this.repiredPer = repiredPer;
        this.registerDate = registerDate;
        this.catogaryID = catogaryID;
        this.companyID = companyID;
    }

    public DeviceDTO(String deviceID, String name, int warrentyPer, int repiredPer, String registerDate, String catogaryID, String companyID, CompanyDTO companyDTO, WetherCatogaryDTO wetherCatogaryDTO) {
        this.deviceID = deviceID;
        this.name = name;
        this.warrentyPer = warrentyPer;
        this.repiredPer = repiredPer;
        this.registerDate = registerDate;
        this.catogaryID = catogaryID;
        this.companyID = companyID;
        this.companyDTO = companyDTO;
        this.wetherCatogaryDTO = wetherCatogaryDTO;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWarrentyPer() {
        return warrentyPer;
    }

    public void setWarrentyPer(int warrentyPer) {
        this.warrentyPer = warrentyPer;
    }

    public int getRepiredPer() {
        return repiredPer;
    }

    public void setRepiredPer(int repiredPer) {
        this.repiredPer = repiredPer;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getCatogaryID() {
        return catogaryID;
    }

    public void setCatogaryID(String catogaryID) {
        this.catogaryID = catogaryID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public WetherCatogaryDTO getWetherCatogaryDTO() {
        return wetherCatogaryDTO;
    }

    public void setWetherCatogaryDTO(WetherCatogaryDTO wetherCatogaryDTO) {
        this.wetherCatogaryDTO = wetherCatogaryDTO;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "deviceID='" + deviceID + '\'' +
                ", name='" + name + '\'' +
                ", warrentyPer=" + warrentyPer +
                ", repiredPer=" + repiredPer +
                ", registerDate='" + registerDate + '\'' +
                ", catogaryID='" + catogaryID + '\'' +
                ", companyID='" + companyID + '\'' +
                ", companyDTO=" + companyDTO +
                ", wetherCatogaryDTO=" + wetherCatogaryDTO +
                '}';
    }
}
