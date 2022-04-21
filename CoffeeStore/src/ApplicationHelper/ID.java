package ApplicationHelper;

import BUS.BillBUS;
import BUS.Detail_BillBUS;
import DTO.BillDTO;
import DTO.Detail_BillDTO;

public class ID {
    //attribute
    private static final BillBUS billBUS = new BillBUS();
    private static final Detail_BillBUS detailBillBUS = new Detail_BillBUS();
    
    //getter
    public static BillBUS getBillBUS() {
        return billBUS;
    }

    public static Detail_BillBUS getDetailBillBUS() {
        return detailBillBUS;
    }
    
    //method
    public static String createBillId() {
        getBillBUS().resetList();
        int Id = 1;
        String newBillId;
        for(BillDTO bill: getBillBUS().getBillList()) {
            newBillId = "BL" + String.format("%03d", Id);
            if(bill.getBillId().equalsIgnoreCase(newBillId)) {
                Id++;
            } else {
                break;
            }
        }
        newBillId = "BL" + String.format("%03d", Id);
        return newBillId;  
    }
    
    public static String createDetailBillId(String billId) {
        return billId + createOrdinalNumber(billId);
    }
    
    public static int createOrdinalNumber(String billId) {
        getDetailBillBUS().resetList();
        int num = 1;
        for(Detail_BillDTO detail: getDetailBillBUS().getDetailBillList()) {
            if(detail.getBillId().equalsIgnoreCase(billId) && detail.getOrdinalNumber() == num) {
                num++;
            } else if(!detail.getBillId().equalsIgnoreCase(billId)) {
            } else {
                break;
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        System.out.println(createDetailBillId("BL001"));
    }
}
