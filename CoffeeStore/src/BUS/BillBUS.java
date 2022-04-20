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
    //reset list
    public void resetList() {
        this.setBillList(this.billDAO.readBillListFromDatabase());
    }
    
    //them mot bill moi
    public void insertBill(BillDTO bill) {
        this.getBillDAO().insertBill(bill);
        this.setBillList(this.getBillDAO().readBillListFromDatabase());
    }
    
    public boolean checkExists(String billId) {
        this.resetList();
        for(BillDTO bill: this.getBillList()) {
            if(bill.getBillId().equalsIgnoreCase(billId)) {
                return false;
            }
        }
        return true;
    }
    
    //return ve gia cua mot bill khi truyen vao mabill
    public Double getPriceOfBill(String billId) {
        this.resetList();
        for(BillDTO bill: this.getBillList()) {
            if(bill.getBillId().equalsIgnoreCase(billId)) {
                return bill.getTotal();
            }
        }
        return 0.0;
    }
    
    public static void main(String[] args) {
        BillBUS o = new BillBUS();
        System.out.println(o.checkExists("BL003"));
    }
    
    
}
