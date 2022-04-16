package BUS;

import DAO.ToppingDAO;
import DTO.ToppingDTO;
import java.util.Vector;

public class ToppingBUS {
    //attribue
    private ToppingDAO toppingDAO;
    private Vector<ToppingDTO> toppingList;
    
    //constructor
    public ToppingBUS() {
        this.toppingDAO = new ToppingDAO();
        this.toppingList = this.toppingDAO.readToppingListFromDatabase();
    }
    
    //setter and getter
    public ToppingDAO getToppingDAO() {
        return toppingDAO;
    }

    public void setToppingDAO(ToppingDAO toppingDAO) {
        this.toppingDAO = toppingDAO;
    }

    public Vector<ToppingDTO> getToppingList() {
        return toppingList;
    }

    public void setToppingList(Vector<ToppingDTO> toppingList) {
        this.toppingList = toppingList;
    }
    
    //method
    public ToppingDTO getToppingFromId (String toppingId) {
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(toppingId)) {
                return topping;
            }
        }
        return null;
    }
    
}
