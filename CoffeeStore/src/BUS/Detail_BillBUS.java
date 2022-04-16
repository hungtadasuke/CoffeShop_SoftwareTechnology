package BUS;

import DAO.Detail_BillDAO;
import DTO.Detail_BillDTO;
import java.util.Vector;

public class Detail_BillBUS {
    //attribute
    private Detail_BillDAO detailBillDAO;
    private Vector<Detail_BillDTO> detailBillList;
    
    //constructor
    public Detail_BillBUS() {
        this.detailBillDAO = new Detail_BillDAO();
        this.detailBillList = this.detailBillDAO.readDetailBillListFromDatabase();
    }
    
    //settter and getter
    public Detail_BillDAO getDetailBillDAO() {
        return detailBillDAO;
    }

    public void setDetailBillDAO(Detail_BillDAO detailBillDAO) {
        this.detailBillDAO = detailBillDAO;
    }

    public Vector<Detail_BillDTO> getDetailBillList() {
        return detailBillList;
    }

    public void setDetailBillList(Vector<Detail_BillDTO> detailBillList) {
        this.detailBillList = detailBillList;
    }
    
    //reset list
    public void resetList() {
        this.setDetailBillList(this.getDetailBillDAO().readDetailBillListFromDatabase());
    }
    
    
}
