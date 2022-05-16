package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class ToppingDAO {

    //construtor
    public ToppingDAO() {
    }
    
    //method
    public Vector<ToppingDTO> readToppingListFromDatabase() {
        Vector<ToppingDTO> toppingList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try (Statement stmt = con.createStatement()){
                con.setAutoCommit(false);
                ResultSet rs = stmt.executeQuery("SELECT * FROM TOPPING");
                while(rs.next()) {
                    ToppingDTO topping = new ToppingDTO(rs.getString("TOPPING_ID"), rs.getString("TOPPING_NAME"), rs.getDouble("TOPPING_PRICE"), rs.getBoolean("TOPPING_BUSINESS"));
                    toppingList.add(topping);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readToppingListFromDatabase method from ToppingDAO class!");
            System.err.println(e);
        }
        return toppingList;
    }
}
