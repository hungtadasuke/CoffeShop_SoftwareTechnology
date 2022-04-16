package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.Vector;

public class StaffBUS {
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
    
}
