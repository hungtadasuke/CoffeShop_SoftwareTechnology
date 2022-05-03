package DAO;

import ApplicationHelper.DatabaseHelper;
import ApplicationHelper.MyDate;
import DTO.StaffDTO;
import java.util.Vector;
import java.sql.*;

public class StaffDAO {
    //constructor
    public StaffDAO() {
    }
    
    //method
     //get staff list from database
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
    
//    public void insert(StaffDTO staff) {
//        try (Connection con = DatabaseHelper.openConnection()){
//            PreparedStatement ps = con.prepareStatement("INSERT INTO STAFF VALUES (?, ?, ?, ?, ?, ?)");
//            ps.setString(1, staff.getStaffId());
//            ps.setNString(2, staff.getStaffName());
//            ps.setNString(3, staff.getStaffAddress());
//            ps.setString(4, staff.getStaffBirthday().formatDB());
//            ps.setString(5, staff.getNumberPhone());
//            ps.setString(6, staff.getPosition());
//            ps.executeUpdate();
//            System.out.println("Sucess!");
//        } catch (Exception e) {
//            System.err.println("Error at insert method from StaffDAO class!");
//            System.err.println(e);
//        }
//        
//    }
    
}
