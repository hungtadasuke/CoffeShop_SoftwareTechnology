package BUS;

import DAO.BillDAO;
import DTO.BillDTO;
import java.util.Vector;

public class BillBUS {
    //attribute
    private BillDAO billDAO;
    private Vector<BillDTO> billList;
    
    //constructor
    public BillBUS() {
        this.billDAO = new BillDAO();
        this.billList = this.billDAO.readBillListFromDatabase();
    }
    
    //setter and getter
    public BillDAO getBillDAO() {
        return billDAO;
    }

    public void setBillDAO(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    public Vector<BillDTO> getBillList() {
        return billList;
    }

    public void setBillList(Vector<BillDTO> billList) {
        this.billList = billList;
    }
    
    //method
    public void reset() {
        this.setBillList(this.billDAO.readBillListFromDatabase());
    }
    
    
}
