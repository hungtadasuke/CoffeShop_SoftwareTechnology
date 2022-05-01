package BUS;

import DAO.Product_ToppingDAO;
import DTO.Product_ToppingDTO;
import java.util.Vector;

public class Product_ToppingBUS {
    //attribute
    private Product_ToppingDAO productToppingDAO;
    private Vector<Product_ToppingDTO> productToppingList;
    
    //constructor
    public Product_ToppingBUS() {
        this.productToppingDAO = new Product_ToppingDAO();
        this.productToppingList = this.productToppingDAO.readProductToppingListFromDatabase();
    }
    
    //setter and getter
    public Product_ToppingDAO getProductToppingDAO() {
        return productToppingDAO;
    }

    public void setProductToppingDAO(Product_ToppingDAO productToppingDAO) {
        this.productToppingDAO = productToppingDAO;
    }

    public Vector<Product_ToppingDTO> getProductToppingList() {
        return productToppingList;
    }

    public void setProductToppingList(Vector<Product_ToppingDTO> productToppingList) {
        this.productToppingList = productToppingList;
    }
    
    //reset
    public void reset() {
        this.setProductToppingList(this.getProductToppingDAO().readProductToppingListFromDatabase());
    }
    
    //get topping list from product id
    public Vector<String> getToppingIdList(String productId) {
        Vector<String> toppingIdList  = new Vector<>();
        this.reset();
        for(Product_ToppingDTO productTopping: this.getProductToppingList()) {
            if(productTopping.getProductId().equalsIgnoreCase(productId)) {
                toppingIdList.add(productTopping.getToppingId());
            }
        }
        return toppingIdList;
    }
    
    public static void main(String[] args) {
        Product_ToppingBUS o = new Product_ToppingBUS();
        for(String s: o.getToppingIdList("CF003")) {
            System.out.println(s);
        }
    }
}
