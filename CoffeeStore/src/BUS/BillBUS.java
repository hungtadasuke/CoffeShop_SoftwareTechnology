package BUS;

import ApplicationHelper.MyDate;
import DAO.BillDAO;
import DTO.BillDTO;
import java.text.*;
import java.util.Date;
import java.util.Vector;


public class BillBUS {
    //attribute
    private BillDAO billDAO;
    private Vector<BillDTO> billList;
    
    //constructor
    public BillBUS() {
        this.billDAO = new BillDAO();
        this.billList = this.billDAO.readBillListFromDatabase();
    }
    
    //setter and getter
    public BillDAO getBillDAO() {
        return billDAO;
    }

    public void setBillDAO(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    public Vector<BillDTO> getBillList() {
        return billList;
    }

    public void setBillList(Vector<BillDTO> billList) {
        this.billList = billList;
    }
    
    //method
    //reset list
    public void resetList() {
        this.setBillList(this.billDAO.readBillListFromDatabase());
    }
    
    //them mot bill moi
    public void insertBill(BillDTO bill) {
        this.getBillDAO().insertBill(bill);
        this.setBillList(this.getBillDAO().readBillListFromDatabase());
        this.resetList();
    }
    
    public boolean checkExists(String billId) {
        this.resetList();
        for(BillDTO bill: this.getBillList()) {
            if(bill.getBillId().equalsIgnoreCase(billId)) {
                return false;
            }
        }
        return true;
    }
    
    //update status, receivedMoney and excessMoney of a bill
    public void updateBill(String billId, boolean status, Double receivedMoney, Double excessMoney) {
        this.getBillDAO().updateBill(billId, status, receivedMoney, excessMoney);
        this.resetList();
    }
    
    
    //return ve gia cua mot bill khi truyen vao mabill
    public Double getPriceOfBill(String billId) {
        this.resetList();
        for(BillDTO bill: this.getBillList()) {
            if(bill.getBillId().equalsIgnoreCase(billId)) {
                return bill.getTotal();
            }
        }
        return 0.0;
    }
    
    //Tra ve mot bill tu Id cua bill
    public BillDTO getBillFromId(String billId) {
        this.resetList();
        for(BillDTO bill: this.getBillList()) {
            if(bill.getBillId().equalsIgnoreCase(billId)) {
                return bill;
            }
        }
        return null;
    }
    
    //delete bill
    public void deleteBill(String billId) {
        this.getBillDAO().deleteBill(billId);
        this.resetList();
    }
    
    //get bill list from bill type and time
    public Vector<BillDTO> getBillList(String billType, String dateStart, String dateEnd) throws ParseException {
        this.resetList();
        Vector<BillDTO> list = new Vector<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date DateStart = sdf.parse(dateStart);
            Date DateEnd = sdf.parse(dateEnd);
            for(BillDTO bill: this.getBillList()) {
                if(bill.isBillStatus() && bill.getBillType().equalsIgnoreCase(billType) && (DateStart.compareTo(DateEnd) == -1 || DateStart.compareTo(DateEnd) == 0)){
                    Date DateCheck = sdf.parse(MyDate.format(bill.getDate().toString()));
                    if(DateCheck.compareTo(DateStart) == 1 && DateCheck.compareTo(DateEnd) == -1) {
                        list.add(bill);
                    } else if (DateCheck.compareTo(DateStart) == 0 || DateCheck.compareTo(DateEnd) == 0) {
                        list.add(bill);
                    }
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getBillList from billType and time of BillBUS class!");
            System.err.println(e);
        }
        return list;
    }
    
    //get count bills from bill tyoe and time
    public int getCountBill(String billType, String dateStart, String dateEnd) throws ParseException {
        this.resetList();
        int count = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date DateStart = sdf.parse(dateStart);
            Date DateEnd = sdf.parse(dateEnd);
            for(BillDTO bill: this.getBillList()) {
                if(bill.isBillStatus() && bill.getBillType().equalsIgnoreCase(billType) && (DateStart.compareTo(DateEnd) == -1 || DateStart.compareTo(DateEnd) == 0)){
                    Date DateCheck = sdf.parse(MyDate.format(bill.getDate().toString()));
                    if(DateCheck.compareTo(DateStart) == 1 && DateCheck.compareTo(DateEnd) == -1) {
                        count++;
                    } else if (DateCheck.compareTo(DateStart) == 0 || DateCheck.compareTo(DateEnd) == 0) {
                        count++;
                    }
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getCountBill from billType and time of BillBUS class!");
            System.err.println(e);
        }
        return count;
    }
    
    //get total bills from bill type and time
    public Double getTotalOfBillList(String dateStart, String dateEnd) throws ParseException {
        this.resetList();
        Double total = 0.0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date DateStart = sdf.parse(dateStart);
            Date DateEnd = sdf.parse(dateEnd);
            Date DateCheck;
            for(BillDTO bill: this.getBillList()) {
                if(bill.isBillStatus() && (DateStart.compareTo(DateEnd) == -1 || DateStart.compareTo(DateEnd) == 0)) {
                    DateCheck = sdf.parse(MyDate.format(bill.getDate().toString()));
                    if(DateCheck.compareTo(DateStart) == 1 && DateCheck.compareTo(DateEnd) == -1) {
                        total += bill.getTotal();
                    } else if (DateCheck.compareTo(DateStart) == 0 || DateCheck.compareTo(DateEnd) == 0) {
                        total += bill.getTotal();
                    }
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getTotalOfBillList from billType and time of BillBUS class!");
            System.err.println(e);
        }
        return total;
    }
    
    //get sum count of bill from time
    public int getSumCountBill(String dayStart, String dayEnd) throws ParseException {
        return this.getCountBill("Spot", dayStart, dayEnd) + this.getCountBill("Take Away", dayStart, dayEnd);
    }
    
    //get bill list from date
    public Vector<BillDTO> getBillList(String dateStart, String dateEnd) throws ParseException {
        this.resetList();
        Vector<BillDTO> list = new Vector<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date DateStart = sdf.parse(dateStart);
            Date DateEnd = sdf.parse(dateEnd);
            for(BillDTO bill: this.getBillList()) {
                if(bill.isBillStatus() && (DateStart.compareTo(DateEnd) == -1 || DateStart.compareTo(DateEnd) == 0)){
                    Date DateCheck = sdf.parse(MyDate.format(bill.getDate().toString()));
                    if(DateCheck.compareTo(DateStart) == 1 && DateCheck.compareTo(DateEnd) == -1) {
                        list.add(bill);
                    } else if (DateCheck.compareTo(DateStart) == 0 || DateCheck.compareTo(DateEnd) == 0) {
                        list.add(bill);
                    }
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getBillList from billType and time of BillBUS class!");
            System.err.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) throws ParseException {
        BillBUS o = new BillBUS();
        for(BillDTO bill: o.getBillList("2022-04-22", "2022-04-22")) {
            System.out.println(bill.getBillId());
        }
    }
    
    
}
