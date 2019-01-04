package lk.edu.ijse.metromanagement.model;

public class WetherDTO {

    private String wetherID;
    private String wTime;
    private String wDate;
    private String regID;
    private BarometerDTO barometerDTO;
    private ThermometerDTO thermometerDTO;
    private HumidityDTO humidityDTO;
    private CloudDTO cloudDTO;
    private WindDTO windDTO;
    private RainDTO rainDTO;
    private SeaStateDTO seaStateDTO;

    public WetherDTO() {
    }

    public WetherDTO(String wetherID, String wTime, String wDate, String regID) {
        this.wetherID = wetherID;
        this.wTime = wTime;
        this.wDate = wDate;
        this.regID = regID;
    }

    public WetherDTO(String wetherID, String wTime, String wDate, String regID, BarometerDTO barometerDTO) {
        this.wetherID = wetherID;
        this.wTime = wTime;
        this.wDate = wDate;
        this.regID = regID;
        this.barometerDTO = barometerDTO;
    }

    public WetherDTO(String wetherID, String wTime, String wDate, String regID, BarometerDTO barometerDTO, ThermometerDTO thermometerDTO, HumidityDTO humidityDTO, CloudDTO cloudDTO, WindDTO windDTO, RainDTO rainDTO, SeaStateDTO seaStateDTO) {
        this.wetherID = wetherID;
        this.wTime = wTime;
        this.wDate = wDate;
        this.regID = regID;
        this.barometerDTO = barometerDTO;
        this.thermometerDTO = thermometerDTO;
        this.humidityDTO = humidityDTO;
        this.cloudDTO = cloudDTO;
        this.windDTO = windDTO;
        this.rainDTO = rainDTO;
        this.seaStateDTO = seaStateDTO;
    }

    public String getWetherID() {
        return wetherID;
    }

    public void setWetherID(String wetherID) {
        this.wetherID = wetherID;
    }

    public String getwTime() {
        return wTime;
    }

    public void setwTime(String wTime) {
        this.wTime = wTime;
    }

    public String getwDate() {
        return wDate;
    }

    public void setwDate(String wDate) {
        this.wDate = wDate;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public BarometerDTO getBarometerDTO() {
        return barometerDTO;
    }

    public void setBarometerDTO(BarometerDTO barometerDTO) {
        this.barometerDTO = barometerDTO;
    }

    public ThermometerDTO getThermometerDTO() {
        return thermometerDTO;
    }

    public void setThermometerDTO(ThermometerDTO thermometerDTO) {
        this.thermometerDTO = thermometerDTO;
    }

    public HumidityDTO getHumidityDTO() {
        return humidityDTO;
    }

    public void setHumidityDTO(HumidityDTO humidityDTO) {
        this.humidityDTO = humidityDTO;
    }

    public CloudDTO getCloudDTO() {
        return cloudDTO;
    }

    public void setCloudDTO(CloudDTO cloudDTO) {
        this.cloudDTO = cloudDTO;
    }

    public WindDTO getWindDTO() {
        return windDTO;
    }

    public void setWindDTO(WindDTO windDTO) {
        this.windDTO = windDTO;
    }

    public RainDTO getRainDTO() {
        return rainDTO;
    }

    public void setRainDTO(RainDTO rainDTO) {
        this.rainDTO = rainDTO;
    }

    public SeaStateDTO getSeaStateDTO() {
        return seaStateDTO;
    }

    public void setSeaStateDTO(SeaStateDTO seaStateDTO) {
        this.seaStateDTO = seaStateDTO;
    }

    @Override
    public String toString() {
        return "WetherDTO{" +
                "wetherID='" + wetherID + '\'' +
                ", wTime='" + wTime + '\'' +
                ", wDate='" + wDate + '\'' +
                ", regID='" + regID + '\'' +
                ", barometerDTO=" + barometerDTO +
                ", thermometerDTO=" + thermometerDTO +
                ", humidityDTO=" + humidityDTO +
                ", cloudDTO=" + cloudDTO +
                ", windDTO=" + windDTO +
                ", rainDTO=" + rainDTO +
                ", seaStateDTO=" + seaStateDTO +
                '}';
    }
}
