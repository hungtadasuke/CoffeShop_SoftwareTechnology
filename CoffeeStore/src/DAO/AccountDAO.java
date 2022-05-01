package DAO;

import DTO.AccountDTO;
import java.sql.*;
import java.util.Vector;

public class AccountDAO {
    //constructor
    public AccountDAO() {
    }
    
    //method
    //read account list from DB
    public Vector<AccountDTO> readAccountListFromDatabase() {
        Vector<AccountDTO> accountList = new Vector<>();
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_ACCOUNT_LIST}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    accountList.add(new AccountDTO(rs.getString("A_USERNAME"), rs.getString("A_PASSWORD"), rs.getString("STAFF_ID")));
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at readAccountListFromDatabase method of AccountDAO class!");
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readAccountListFromDatabase method of AccountDAO class!");
            System.err.println(e);
        }
        return accountList;
    }
    
    //main
    public static void main(String[] args) {
        AccountDAO o = new AccountDAO();
        for(AccountDTO x: o.readAccountListFromDatabase()) {
            System.out.println(x.getUsername() + "---" + x.getPassword() + "---" + x.getStaffId());
        }
    }
}
