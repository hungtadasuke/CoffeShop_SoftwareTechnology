package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.util.Vector;

public class ProductBUS {
    //attribute
    private ProductDAO productDAO;
    private Vector<ProductDTO> productList;
    
    //constructor
    public ProductBUS() {
        this.productDAO = new ProductDAO();
        this.productList = productDAO.readProductListFromDatabase();
    }
    
    //setter and getter
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Vector<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(Vector<ProductDTO> productList) {
        this.productList = productList;
    }
    
    //method  
    public void resetProductList() {
        this.setProductList(this.getProductDAO().readProductListFromDatabase());
    }
    
}
