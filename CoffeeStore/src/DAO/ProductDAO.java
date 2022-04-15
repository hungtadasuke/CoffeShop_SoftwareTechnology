package DAO;

import DTO.ProductDTO;
import java.util.Vector;
import java.sql.*;

public class ProductDAO {
    //constructor
    public ProductDAO() {
    }
    
    //method  
    //get product list from database
    public Vector<ProductDTO> readProductListFromDatabase() {
        Vector<ProductDTO> productList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM PRODUCT";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                ProductDTO product = new ProductDTO(rs.getString("CLASSIFY_ID"), rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getString("PRODUCT_NICKNAME"), rs.getString("PRODUCT_STATUS"), rs.getBoolean("PRODUCT_BUSINESS"));
                productList.add(product);
            }

        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readProductListFromDatabase method from ProductDAO class!");
            System.err.println(e);
        }
        return productList;
    }
    
}
