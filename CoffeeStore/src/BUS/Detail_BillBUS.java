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
    
    //Tra ve so luong khi truyen vao chi tiet hoa don
    public int getQuantity(String detailBillId) {
        int num = 0;
        for(Detail_BillDTO detail: this.getDetailBillList()) {
            if(detail.getDetailBillId().trim().equalsIgnoreCase(detailBillId)) {
                return detail.getQuantity();
            }
        }
        return num;
    }
    
    //insert a detailBill
    public void insertDetailBill(Detail_BillDTO detail) {
        this.getDetailBillDAO().insertDetailBill(detail);
        this.resetList();
    }
    
    //get detail from detailBillId
    public Detail_BillDTO getDetailBillFromId(String detailBillId) {
        this.resetList();
        for(Detail_BillDTO detail: this.getDetailBillList()) {
            if(detail.getDetailBillId().trim().equalsIgnoreCase(detailBillId)) {
                return detail;
            }
        }
        return null;
    }
    
    //delete a detail bill
    public void deleteDetailBill(String detailBillId) {
        this.getDetailBillDAO().deleteDetailBill(detailBillId);
        this.resetList();
    }
    
    
    //main test
    public static void main(String[] args) {
        Detail_BillBUS detail = new Detail_BillBUS();
        System.out.println(detail.getDetailBillFromId("BL0041").getUnitPrice());
    }
}
