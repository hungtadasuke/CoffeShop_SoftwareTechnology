package DTO;


public class AccountDTO {
    //attribute
    private String username;
    private String password;
    private String staffId;
    private String permission;
    
    //constructor
    public AccountDTO(String username, String password, String staffId, String permission) {
        this.username = username;
        this.password = password;
        this.staffId = staffId;
        this.permission = permission;
    }
    
    //setter and getter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getAccountUsername() {
        return null;
    }

    public String getAccountPassword() {
        return null;
    }

    public String getAccountStaffID() {
        return null;
    }

    public String getAccountPermissions() {
        return null;
    }
 

    
}
