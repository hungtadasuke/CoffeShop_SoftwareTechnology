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
}
