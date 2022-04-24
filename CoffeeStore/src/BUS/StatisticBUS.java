package BUS;

import DTO.BillDTO;
import DTO.Detail_BillDTO;
import DTO.StatisticProductDTO;
import java.text.ParseException;
import java.util.Vector;

public class StatisticBUS {
    //attribute
    private SellBUS sellBUS;
    
    //constructor
    public StatisticBUS() {
        this.sellBUS = new SellBUS();
    }
    
    //setter and getter
    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }
    
    //method
    //Tao danh sach StatisticProductDTO tu dateStart and dateEnd
    public Vector<StatisticProductDTO> getSatisticProductDTO(String dateStart, String dateEnd) {
        Vector<StatisticProductDTO> statisticList = new Vector<>();
        int count = 0;
        for(Detail_BillDTO detail: this.getDetailBillListFromDate(dateStart, dateEnd)) {
            for(StatisticProductDTO statistic: statisticList) {
                count = 0;
                if(detail.getProductId().equalsIgnoreCase(statistic.getProductId())) {
                    count++;
                    break;
                }
            }
            if(count == 0) {
                StatisticProductDTO statistic = new StatisticProductDTO();
                statistic.setProductId(detail.getProductId());
                
            }
        }
        return statisticList;
    }
    
    //Tao danh sach detailBill from dateStart and dateEnd
    private Vector<Detail_BillDTO> getDetailBillListFromDate(String dateStart, String dateEnd) {
        Vector<Detail_BillDTO> detailList = new Vector<>();
        try {
            for(BillDTO bill: this.getSellBUS().getBillBUS().getBillList(dateStart, dateEnd)) {
                for(Detail_BillDTO detail: this.getSellBUS().getDetailBillBUS().getDetailBillListFromBillId(bill.getBillId())) {
                    detailList.add(detail);
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getDetailBillListFromDate method of StatisticBUS class!");
            System.err.println(e);
        }
        return detailList;
    }
    
    public static void main(String[] args) {
        StatisticBUS o = new StatisticBUS();
        for(Detail_BillDTO detail: o.getDetailBillListFromDate("2022-04-15", "2022-04-24")) {
            System.out.println(detail.getDetailBillId());
        }
    }
    
}
