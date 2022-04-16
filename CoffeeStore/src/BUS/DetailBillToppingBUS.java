package BUS;

import DAO.DetailBill_ToppingDAO;
import DTO.BillDetail_ToppingDTO;
import java.util.Vector;

public class DetailBillToppingBUS {
    //attribute
    private DetailBill_ToppingDAO detailBillToppingDAO;
    private Vector<BillDetail_ToppingDTO> detailBillToppingList;
    
    //constructor
    public DetailBillToppingBUS() {
        this.detailBillToppingDAO = new DetailBill_ToppingDAO();
        this.detailBillToppingList = this.detailBillToppingDAO.readDetailBillToppingListFromDB();
    }
    
    //setter and getter
    public DetailBill_ToppingDAO getDetailBillToppingDAO() {
        return detailBillToppingDAO;
    }

    public void setDetailBillToppingDAO(DetailBill_ToppingDAO detailBillToppingDAO) {
        this.detailBillToppingDAO = detailBillToppingDAO;
    }

    public Vector<BillDetail_ToppingDTO> getDetailBillToppingList() {
        return detailBillToppingList;
    }

    public void setDetailBillToppingList(Vector<BillDetail_ToppingDTO> detailBillToppingList) {
        this.detailBillToppingList = detailBillToppingList;
    }
    
    //method
    //reset list
    public void reset() {
        this.setDetailBillToppingList(this.getDetailBillToppingDAO().readDetailBillToppingListFromDB());
    }
    
    
}
