package DTO;

public class StaffDTO {
    //attribute
    private String staffId;
    private String staffName;
    private String staffBirthday;
    private String staffAddress;
    private String numberPhone;
    private String position;
    
    //constructor
    public StaffDTO(String staffId, String staffName, String staffBirthday, String staffAddress, String numberPhone, String position) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffBirthday = staffBirthday;
        this.staffAddress = staffAddress;
        this.numberPhone = numberPhone;
        this.position = position;
    }
    
    //setter and getter
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(String staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
