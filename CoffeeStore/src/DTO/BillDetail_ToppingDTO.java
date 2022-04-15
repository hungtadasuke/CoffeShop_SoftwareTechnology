package DTO;

public class BillDetail_ToppingDTO {
    //attribute
    private String detailBillId;
    private String toppingId;
    
    //constructor
    public BillDetail_ToppingDTO(String detailBillId, String toppingId) {
        this.detailBillId = detailBillId;
        this.toppingId = toppingId;
    }
    
    //setter and getter
    public String getDetailBillId() {
        return detailBillId;
    }

    public void setDetailBillId(String detailBillId) {
        this.detailBillId = detailBillId;
    }

    public String getToppingId() {
        return toppingId;
    }

    public void setToppingId(String toppingId) {
        this.toppingId = toppingId;
    }
    
}
