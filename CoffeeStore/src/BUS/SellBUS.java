package BUS;

public class SellBUS {
   //attribute
   private ClassifyBUS classifyBUS;
   private ProductBUS productBUS;
   private TableBUS tableBUS;
   private Product_SizeBUS productSizeBUS;
   private ToppingBUS toppingBUS;
   private Product_ToppingBUS productToppingBUS;
   private StaffBUS staffBUS;
   private BillBUS billBUS;
   private Detail_BillBUS detailBillBUS;
   private DetailBillToppingBUS detailBillToppingBUS;
   private SpotBillBUS spotBillBUS;
   
   //constructor
   public SellBUS() {
       this.classifyBUS = new ClassifyBUS();
       this.productBUS = new ProductBUS();
       this.tableBUS = new TableBUS();
       this.productSizeBUS = new Product_SizeBUS();
       this.toppingBUS = new ToppingBUS();
       this.productToppingBUS = new Product_ToppingBUS();
       this.staffBUS = new StaffBUS();
       this.billBUS = new BillBUS();
       this.detailBillBUS = new Detail_BillBUS();
       this.detailBillToppingBUS = new DetailBillToppingBUS();
       this.spotBillBUS = new SpotBillBUS();
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

    public Product_SizeBUS getProductSizeBUS() {
        return productSizeBUS;
    }

    public void setProductSizeBUS(Product_SizeBUS productSizeBUS) {
        this.productSizeBUS = productSizeBUS;
    }

    public ToppingBUS getToppingBUS() {
        return toppingBUS;
    }

    public void setToppingBUS(ToppingBUS toppingBUS) {
        this.toppingBUS = toppingBUS;
    }

    public Product_ToppingBUS getProductToppingBUS() {
        return productToppingBUS;
    }

    public void setProductToppingBUS(Product_ToppingBUS productToppingBUS) {
        this.productToppingBUS = productToppingBUS;
    }

    public StaffBUS getStaffBUS() {
        return staffBUS;
    }

    public void setStaffBUS(StaffBUS staffBUS) {
        this.staffBUS = staffBUS;
    }

    public BillBUS getBillBUS() {
        return billBUS;
    }

    public void setBillBUS(BillBUS billBUS) {
        this.billBUS = billBUS;
    }

    public Detail_BillBUS getDetailBillBUS() {
        return detailBillBUS;
    }

    public void setDetailBillBUS(Detail_BillBUS detailBillBUS) {
        this.detailBillBUS = detailBillBUS;
    }

    public DetailBillToppingBUS getDetailBillToppingBUS() {
        return detailBillToppingBUS;
    }

    public void setDetailBillToppingBUS(DetailBillToppingBUS detailBillToppingBUS) {
        this.detailBillToppingBUS = detailBillToppingBUS;
    }

    public SpotBillBUS getSpotBillBUS() {
        return spotBillBUS;
    }

    public void setSpotBillBUS(SpotBillBUS spotBillBUS) {
        this.spotBillBUS = spotBillBUS;
    }
}
