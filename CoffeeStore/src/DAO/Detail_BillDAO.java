package DAO;

import DTO.Detail_BillDTO;
import java.sql.*;
import java.util.Vector;

public class Detail_BillDAO {
    //constructor
    public Detail_BillDAO() {
    }
    
    //method
    //lay danh sach detail_bill tu database
    public Vector<Detail_BillDTO> readDetailBillListFromDatabase() {
        Vector<Detail_BillDTO> detailBillList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_DETAIL_BILL_LIST()}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    Detail_BillDTO detail = new Detail_BillDTO(rs.getString("DETAIL_BILL_ID"), rs.getString("BILL_ID"), rs.getString("PRODUCT_ID"), rs.getInt("ORDINAL_NUMBER"), rs.getString("PRODUCT_SIZE"), rs.getString("PRODUCT_STATUS"), rs.getInt("QUANTITY"), rs.getDouble("UNIT_PRICE"));
                    detailBillList.add(detail);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readDetailBillListFromDatabase method from Detail_BillDAO class!");
            System.err.println(e);
        }
        return detailBillList;
    }
    
    public static void main(String[] args) {
        Detail_BillDAO o = new Detail_BillDAO();
        Vector<Detail_BillDTO> list = o.readDetailBillListFromDatabase();
        for(Detail_BillDTO x: list) {
            System.out.println(x.getBillId() + "--" + x.getDetailBillId().trim() + "--" + x.getOrdinalNumber()+ "--" + x.getProductSize()+ "--" + x.getProducStatus()+ "--" + x.getQuantity() + "--" + x.getUnitPrice());
        }
    }
    
    
}
