package DAO;

import DTO.SpotBillDTO;
import java.util.Vector;
import java.sql.*;

public class SpotBillDAO {
    //constructor
    public SpotBillDAO() {
    }
    
    //method
    //get spot bill list from database
    public Vector<SpotBillDTO> readSpotBillListFromDB() {
        Vector<SpotBillDTO> spotBillList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM SPOT_BILL";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                SpotBillDTO spotBill = new SpotBillDTO(rs.getString("BILL_ID"), rs.getString("TABLE_ID"));
                spotBillList.add(spotBill);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readBillListFromDatabase method from BillDAO class!");
            System.err.println(e);
        }
        return spotBillList;
    }
    
    public static void main(String[] args) {
        SpotBillDAO o = new SpotBillDAO();
        Vector<SpotBillDTO> list = o.readSpotBillListFromDB();
        for(SpotBillDTO sB: list) {
            System.out.println(sB.getBillId() + "--" + sB.getTableId());
        }
    }
   
    
}
