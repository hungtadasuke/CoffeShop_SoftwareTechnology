package DAO;

import DTO.Product_ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class Product_ToppingDAO {
        //construtor
    public Product_ToppingDAO() {
    }
    
    //method
    public Vector<Product_ToppingDTO> readProductToppingListFromDatabase() {
        Vector<Product_ToppingDTO> productToppingList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try (Statement stmt = con.createStatement()){
                con.setAutoCommit(false);
                ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT_TOPPING");
                while(rs.next()) {
                    Product_ToppingDTO pro_to = new Product_ToppingDTO(rs.getString("PRODUCT_ID"), rs.getString("TOPPING_ID"));
                    productToppingList.add(pro_to);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readProductToppingListFromDatabase method from Product_ToppingDAO class!");
            System.err.println(e);
        }
        return productToppingList;
    }
    
}
