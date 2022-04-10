package DTO;

public class BillDTO {
    //attribute
    private String billId;
    private String date;
    private Double total;
    private Double receivedMoney;
    private Double excessMoney;
    private boolean billStatus;
    private String staffId;
    
    //constructor
    public BillDTO(String billId, String date, Double total, Double receivedMoney, Double excessMoney, String staffId) {
        this.billId = billId;
        this.date = date;
        this.total = total;
        this.receivedMoney = receivedMoney;
        this.excessMoney = excessMoney;
        this.staffId = staffId;
    }
    
    //setter and getter
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(Double receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public Double getExcessMoney() {
        return excessMoney;
    }

    public void setExcessMoney(Double excessMoney) {
        this.excessMoney = excessMoney;
    }

    public boolean isBillStatus() {
        return billStatus;
    }

    public void setBillStatus(boolean billStatus) {
        this.billStatus = billStatus;
    } 

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
