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
    
    //Tra ve so luong cua chi tiet bill_topping khi truyen vao id chi tiet bill + id topping
    public int getQuantity(String detailBillId, String toppingId) {
        for(BillDetail_ToppingDTO o: this.getDetailBillToppingList()) {
            if(o.getDetailBillId().trim().equalsIgnoreCase(detailBillId) && o.getToppingId().equalsIgnoreCase(toppingId)) {
                return o.getQuantity();
            }
        }
        return 0;
    }
    
    //Tra ve tong gia cua cac chi tiet topping khi truyen vao id chi tiet bill
    public Double getToTal(String detailBillId) {
        double total = 0;
        for(BillDetail_ToppingDTO o: this.getDetailBillToppingList()) {
            if(o.getDetailBillId().trim().equalsIgnoreCase(detailBillId)) {
                total += o.getPrice();
            }
        }
        return total;
    }
}
