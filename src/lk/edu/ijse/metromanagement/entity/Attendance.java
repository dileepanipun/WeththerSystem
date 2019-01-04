package lk.edu.ijse.metromanagement.entity;

public class Attendance {

    private String attendanceID;
    private String attDate;
    private String attTime;
    private String registerID;

    public Attendance() {
    }

    public Attendance(String attendanceID, String attDate, String attTime, String registerID) {
        this.attendanceID = attendanceID;
        this.attDate = attDate;
        this.attTime = attTime;
        this.registerID = registerID;
    }

    public String getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(String attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }
}
