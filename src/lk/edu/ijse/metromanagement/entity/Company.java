package lk.edu.ijse.metromanagement.entity;

public class Company {

    private String companyID;
    private String name;
    private String address;
    private String telephoneNo;

    public Company() {
    }

    public Company(String companyID, String name, String address, String telephoneNo) {
        this.companyID = companyID;
        this.name = name;
        this.address = address;
        this.telephoneNo = telephoneNo;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
}
