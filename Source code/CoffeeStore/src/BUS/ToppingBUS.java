package BUS;

import DAO.ToppingDAO;
import DTO.ToppingDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class ToppingBUS implements ICoffeeShop{
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
    
    //lay gia topping tu id
    public Double getPriceFromId(String toppingId) {
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(toppingId)) {
                return topping.getToppingPrice();
            }
        }
        return 0.0;
    }

    @Override
    public void resetList() {
        this.setToppingList(this.getToppingDAO().readToppingListFromDatabase());
    }
    
}
