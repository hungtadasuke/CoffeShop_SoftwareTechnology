package DAO;

import DTO.AccountDTO;
import ApplicationHelper.MyDate;

import java.sql.*;
import java.util.Vector;

import ApplicationHelper.DatabaseHelper;

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
                    accountList.add(new AccountDTO(rs.getString("A_USERNAME"), rs.getString("A_PASSWORD"), rs.getString("STAFF_ID"), rs.getString("A_Permission")));
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
    public Vector<String> AccountFromDB() {
        Vector<String> username = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT ACCOUNT FROM ACCOUNT";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                username.add(rs.getString("ACCOUNT"));
            }
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return username;
    }

    public void insert(AccountDTO account) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNT VALUES (?, ?, ?, ?)");
            ps.setString(1, account.getAccountUsername());
            ps.setNString(2, account.getAccountPassword());
            ps.setNString(3, account.getAccountStaffID());
            ps.setString(4, account.getAccountPermissions());
            
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at insert method from AccountDAO class!");
            System.err.println(e);
        }

    }

    public void delete(String account) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ACCOUNT  = ?");
            ps.setString(1, account);
            ps.executeUpdate();
            System.out.println("Delete Sucess!");
        } catch (Exception ex) {
            System.out.println("faild delete!");
        }
    }


    public void timkiem() {
        
    }

    public static void main(String[] args) {
        AccountDAO o = new  AccountDAO();
        Vector<AccountDTO> list = t.readAccountListFromDatabase();
//        
        System.out.println( t.AccountDTOFromDB());
    }

}

    

