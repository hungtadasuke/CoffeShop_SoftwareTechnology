package DAO;

import ApplicationHelper.MyDate;
import DTO.StaffDTO;
import java.util.Vector;
import java.sql.*;

public class StaffDAO {
    //constructor
    public StaffDAO() {
    }
    
    //method
     //get product list from database
    public Vector<StaffDTO> readStaffListFromDatabase() {
        Vector<StaffDTO> staffList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM STAFF";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String text[] = rs.getString("STAFF_BIRTHDAY").split("\\s");
                MyDate date = new MyDate(text[0]);
                StaffDTO product = new StaffDTO(rs.getString("STAFF_ID"), rs.getNString("STAFF_NAME"), date, rs.getNString("STAFF_ADDRESS"), rs.getString("STAFF_PHONE"), rs.getString("STAFF_POSITION"));
                staffList.add(product);
            }

        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readStaffListFromDatabase method from StaffDAO class!");
            System.err.println(e);
        }
        return staffList;
    }
    
    public static void main(String[] args) {
        StaffDAO o = new StaffDAO();
        Vector<StaffDTO> list = o.readStaffListFromDatabase();
        for(StaffDTO x: list) {
            System.out.println(x.getStaffId() + "---" + x.getStaffName() + "---" + x.getStaffAddress()+ "---" + x.getStaffBirthday()+ "---" + x.getPosition());
        }
    }
    
}
