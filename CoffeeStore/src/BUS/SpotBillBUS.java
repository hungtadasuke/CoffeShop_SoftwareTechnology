package BUS;

import DAO.SpotBillDAO;
import DTO.SpotBillDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class SpotBillBUS implements ICoffeeShop{
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

    /**
     *
     */
    @Override
    public void resetList() {
        this.setSpotBillList(this.getSpotBillDAO().readSpotBillListFromDB());
    }
    
    //insert a spot bill
    public void insertSpotBill(SpotBillDTO spotBill) {
        this.getSpotBillDAO().insetSpotBill(spotBill);
        this.resetList();
    }
    
    //get spot bill from id
    public SpotBillDTO getSpotBillFromId(String billId) {
        this.resetList();
        for(SpotBillDTO spotBill: this.getSpotBillList()) {
            if(spotBill.getBillId().equalsIgnoreCase(billId)) {
                return spotBill;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        SpotBillBUS o = new SpotBillBUS();
        o.insertSpotBill(new SpotBillDTO("BL001", "TB001"));
    }
}
