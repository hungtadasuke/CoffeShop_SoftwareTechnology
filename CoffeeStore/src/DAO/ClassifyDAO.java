package DAO;

import DTO.ClassifyDTO;
import java.util.Vector;
import java.sql.*;

public class ClassifyDAO {
    //constructor
    public ClassifyDAO() {
    }
    
    //method
    //get classify list from 'CLASSIFY' table on database
    public Vector<ClassifyDTO> readClassifyListFromDatabase() {
        Vector<ClassifyDTO> classifyList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM CLASSIFY";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                ClassifyDTO classify = new ClassifyDTO(rs.getString(1), rs.getString("CLASSIFY_NAME"));
                classifyList.add(classify);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readClassifyFromDatabase method from ClassifyDAO class!");
            System.err.println(e);
        }
        return classifyList;
    }
}
