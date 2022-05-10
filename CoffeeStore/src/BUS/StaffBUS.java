package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class StaffBUS implements ICoffeeShop{
    //attribute
    private StaffDAO staffDAO;
    private Vector<StaffDTO> staffList;
    
    //constructor
    public StaffBUS() {
        this.staffDAO = new StaffDAO();
        this.staffList = this.staffDAO.readStaffListFromDatabase();
    }
    
    //setter and getter
    public StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public void setStaffDAO(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public Vector<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(Vector<StaffDTO> staffList) {
        this.staffList = staffList;
    }
    
    //method
    //get staff from id
    public StaffDTO getStaffFromId(String staffId) {
        for (StaffDTO staff: this.getStaffList()) {
            if(staff.getStaffId().equalsIgnoreCase(staffId)) {
                return staff;
            }
        }
        return null;
    }
    
    //reset
    @Override
    public void resetList() {
        this.setStaffList(this.getStaffDAO().readStaffListFromDatabase());
    }
    
    public boolean checkPosition(String staffID) {
        this.resetList();
        for(StaffDTO staff: this.getStaffList()) {
            if(staff.getStaffId().equalsIgnoreCase(staffID) && staff.getPosition().equalsIgnoreCase("Manager")) {
                return true;
            }
        }
        return false;
    }
    
}
