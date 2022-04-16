package DAO;

import DTO.BillDetail_ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class DetailBill_ToppingDAO {
    //constructor
    public DetailBill_ToppingDAO() {
    }
    
    //method
    //get detai_bill_topping list from database
    public Vector<BillDetail_ToppingDTO> readDetailBillToppingListFromDB() {
        Vector<BillDetail_ToppingDTO> detailBillToppingList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            try{
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_DETAILBILL_TOPPING_LIST()}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    BillDetail_ToppingDTO o = new BillDetail_ToppingDTO(rs.getString("DETAIL_BILL_ID"), rs.getString("TOPPING_ID"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"));
                    detailBillToppingList.add(o);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readDetailBillToppingListFromDB method from DetailBill_ToppingDAO class!");
            System.err.println(e);
        }
        return detailBillToppingList;
    }
    
    public static void main(String[] args) {
        DetailBill_ToppingDAO o = new DetailBill_ToppingDAO();
        Vector<BillDetail_ToppingDTO> list = o.readDetailBillToppingListFromDB();
        for(BillDetail_ToppingDTO x: list) {
            System.out.println(x.getDetailBillId().trim() + "---" + x.getToppingId() + "---" + x.getQuantity() + "---" + x.getPrice());
        }
    }
}
