package BUS;

import DAO.TableDAO;
import DTO.TableDTO;
import java.util.Vector;

public class TableBUS {
    //attribute
    private TableDAO tableDAO;
    private Vector<TableDTO> tableList;
    
    //constructor
    public TableBUS() {
        this.tableDAO = new TableDAO();
        this.tableList = this.tableDAO.readTableListFromDatabase();
    }
    
    //setter and getter
    public TableDAO getTableDAO() {
        return tableDAO;
    }

    public void setTableDAO(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    public Vector<TableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(Vector<TableDTO> tableList) {
        this.tableList = tableList;
    }
    
    //method
    public void resetTableList() {
        this.setTableList(this.getTableDAO().readTableListFromDatabase());
    }
    
    //update status a table
    public void updateStatusTable(String tableId, boolean status) {
        this.getTableDAO().updateStatustable(tableId, status);
        this.resetTableList();
    }
    
    //get table from id
    public TableDTO getTableFromId(String tableId) {
        this.resetTableList();
        for(TableDTO table: this.getTableList()) {
            if(table.getTableId().equalsIgnoreCase(tableId)) {
                return table;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        TableBUS o = new TableBUS();
        o.updateStatusTable("TB001", true);
    }
}
