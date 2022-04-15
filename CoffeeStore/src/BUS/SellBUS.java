package BUS;

public class SellBUS {
   //attribute
   private ClassifyBUS classifyBUS;
   private ProductBUS productBUS;
   private TableBUS tableBUS;
   
   //constructor
   public SellBUS() {
       this.classifyBUS = new ClassifyBUS();
       this.productBUS = new ProductBUS();
       this.tableBUS = new TableBUS();
   }
   
   //setter and getter
    public ClassifyBUS getClassifyBUS() {
        return classifyBUS;
    }

    public void setClassifyBUS(ClassifyBUS classifyBUS) {
        this.classifyBUS = classifyBUS;
    }

    public ProductBUS getProductBUS() {
        return productBUS;
    }

    public void setProductBUS(ProductBUS productBUS) {
        this.productBUS = productBUS;
    }

    public TableBUS getTableBUS() {
        return tableBUS;
    }

    public void setTableBUS(TableBUS tableBUS) {
        this.tableBUS = tableBUS;
    }
}
