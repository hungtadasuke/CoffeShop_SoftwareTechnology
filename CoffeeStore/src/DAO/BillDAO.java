package DAO;

import ApplicationHelper.MyDate;
import DTO.BillDTO;
import java.util.Vector;
import java.sql.*;

public class BillDAO {
    //constructor
    public BillDAO() {
    }
    
    //method
    //lay danh sach bill tu database
    public Vector<BillDTO> readBillListFromDatabase() {
        Vector<BillDTO> billList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM BILL";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
               String[] text = rs.getString("BILL_DATE").split("\\s");
               MyDate date = new MyDate(text[0]);
               BillDTO bill = new BillDTO(rs.getString("BILL_ID"), date, rs.getDouble("BILL_TOTAL"), rs.getDouble("RECEIVED_MONEY"), rs.getDouble("EXCESS_MONEY"), rs.getBoolean("BILL_STATUS"), rs.getString("STAFF_ID"));
               billList.add(bill);
            }

        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readBillListFromDatabase method from BillDAO class!");
            System.err.println(e);
        }
        return billList;
    }
    
    public static void main(String[] args) {
        BillDAO o = new BillDAO();
        Vector<BillDTO> list = o.readBillListFromDatabase();
        for(BillDTO x: list) {
            System.out.println(x.getBillId() + "---" + x.getStaffId() + "--" + x.getDate().toString() + "--" + x.getTotal() + "---" + x.getReceivedMoney() + "--" + x.getExcessMoney());
        }
    }
}
