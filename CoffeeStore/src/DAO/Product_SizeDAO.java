package DAO;

import DTO.Product_SizeDTO;
import java.sql.*;
import java.util.Vector;

public class Product_SizeDAO {
    //constructor
    public Product_SizeDAO() {
    }
    
    //method
    //read product_size list from database
    public Vector<Product_SizeDTO> readProductAndSizeFromDatabase() {
        Vector<Product_SizeDTO> productSizeList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT_SIZE");
                while(rs.next()) {
                    Product_SizeDTO o = new Product_SizeDTO(rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_SIZE"), rs.getDouble("PRODUCT_PRICE"));
                    productSizeList.add(o);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
           System.err.println("Error at readProductAndSizeFromDatabase method from Product_SizeDAO class!");
           System.err.println(e);
        } 
        return productSizeList;
    }
    
    public static void main(String[] args) {
        Product_SizeDAO o = new Product_SizeDAO();
        Vector<Product_SizeDTO> list = o.readProductAndSizeFromDatabase();
        for(Product_SizeDTO x: list) {
            System.out.println(x.getProductId() + "-" + x.getSize() + "-" + x.getPrice());
        }
    }
}
