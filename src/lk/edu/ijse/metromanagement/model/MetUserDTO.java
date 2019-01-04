package lk.edu.ijse.metromanagement.model;

public class MetUserDTO {

    private String userID;
    private String firstName;
    private String lastName;
    private String address;
    private String dob;
    private String nicNo;
    private String telephone;
    private String userState;
    private String userName;
    private String email;
    private String password;
    private RegistrationDTO registrationDTO;

    public MetUserDTO() {
    }

    public MetUserDTO(String userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public MetUserDTO(String userID, String firstName, String lastName, String address, String dob, String nicNo, String telephone, String userState, String userName, String email, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.nicNo = nicNo;
        this.telephone = telephone;
        this.userState = userState;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public MetUserDTO(String userID, String firstName, String lastName, String address, String dob, String nicNo, String telephone, String userState, String userName, String email, String password, RegistrationDTO registrationDTO) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.nicNo = nicNo;
        this.telephone = telephone;
        this.userState = userState;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDTO = registrationDTO;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationDTO getRegistrationDTO() {
        return registrationDTO;
    }

    public void setRegistrationDTO(RegistrationDTO registrationDTO) {
        this.registrationDTO = registrationDTO;
    }

    @Override
    public String toString() {
        return "MetUserDTO{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", nicNo='" + nicNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userState='" + userState + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDTO=" + registrationDTO +
                '}';
    }
}
