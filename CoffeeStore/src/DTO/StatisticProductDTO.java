package DTO;

public class StatisticProductDTO {
    //private
    private String productId;
    private String[][] salesOfSize;
    
    //constructor
    public StatisticProductDTO() {
        this.salesOfSize = new String[3][3];
    }
    
    //setter and getter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String[][] getSalesOfSize() {
        return salesOfSize;
    }

    public void setSalesOfSize(String[][] salesOfSize) {
        this.salesOfSize = salesOfSize;
    } 
}
