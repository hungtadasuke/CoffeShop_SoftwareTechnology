package BUS;

import DAO.SpotBillDAO;
import DTO.SpotBillDTO;
import java.util.Vector;

public class SpotBillBUS {
    //attribute
    private SpotBillDAO spotBillDAO;
    private Vector<SpotBillDTO> spotBillList;
    
    //constructor
    public SpotBillBUS() {
        this.spotBillDAO = new SpotBillDAO();
        this.spotBillList = this.spotBillDAO.readSpotBillListFromDB();
    }
    
    //setter and getter
    public SpotBillDAO getSpotBillDAO() {
        return spotBillDAO;
    }

    public void setSpotBillDAO(SpotBillDAO spotBillDAO) {
        this.spotBillDAO = spotBillDAO;
    }

    public Vector<SpotBillDTO> getSpotBillList() {
        return spotBillList;
    }

    public void setSpotBillList(Vector<SpotBillDTO> spotBillList) {
        this.spotBillList = spotBillList;
    }
    
    //method
    //reset
    public void reset() {
        this.setSpotBillList(this.getSpotBillDAO().readSpotBillListFromDB());
    }
    
}
