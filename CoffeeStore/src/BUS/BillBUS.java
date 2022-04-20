package BUS;

import DAO.BillDAO;
import DTO.BillDTO;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    //Print Bill To Excel
    public void printBill(String billId) {
        try {
            //Tao khu vuc lam viec
            XSSFWorkbook workBook = new XSSFWorkbook();
            //Tao sheet co ten = billId
            XSSFSheet sheet = workBook.createSheet(billId);
            
            //Tao doi tuong hang
            XSSFRow row = null;
            //Tao doi tuong cot
            Cell cell = null;
            
            //Merge cell in excel
            CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
            sheet.addMergedRegion(range);
            
            //Tao mot doi tuong cell style
            CellStyle styleId = workBook.createCellStyle();
            styleId.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font1 = workBook.createFont();
            font1.setFontHeight(15);
            font1.setBold(true);
            font1.setColor(IndexedColors.BLACK1.getIndex());
            styleId.setFont(font1);
            
//            CellRangeAddress range2 = new CellRangeAddress(0, 9, 0, 7);
            
//            RegionUtil.setBorderBottom(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderTop(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderRight(BorderStyle.DOUBLE, range2, sheet);
            
            //Tao tieu de
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Your Order Is " + billId);
            cell.setCellStyle(styleId);
            
            //Tao ten cua hang
            range = new CellRangeAddress(1, 2, 0, 7);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("COFFEE SHOP");
            
            CellStyle styleStoreName = workBook.createCellStyle();
            XSSFFont font2 = workBook.createFont();
            font2.setBold(true);
            font2.setFontHeight(18);
            styleStoreName.setFont(font2);
            styleStoreName.setAlignment(HorizontalAlignment.CENTER);
            
            cell.setCellStyle(styleStoreName);
            
            //Tao dia chi
            range = new CellRangeAddress(3, 3, 0, 7);
            sheet.addMergedRegion(range);
            
            CellStyle styleAddress = workBook.createCellStyle();
            XSSFFont font3 = workBook.createFont();
            font3.setFontHeight(13);
            styleAddress.setAlignment(HorizontalAlignment.CENTER);
            styleAddress.setFont(font3);
            
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("CMT8");
            cell.setCellStyle(styleAddress);
            
            range = new CellRangeAddress(4, 4, 0, 7);
            sheet.addMergedRegion(range);
            
            styleAddress.setAlignment(HorizontalAlignment.CENTER);
            styleAddress.setFont(font3);
            
            row = sheet.createRow(4);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("770 Cach Mang Thang Tam, 5 Ward, Tan Binh District");
            cell.setCellStyle(styleAddress);
            
            range = new CellRangeAddress(5, 5, 0, 7);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(5);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Ho Chi Minh City");
            cell.setCellStyle(styleAddress);
            
            //Tao ngay
            CellStyle styleDate = workBook.createCellStyle();
            XSSFFont font4 = workBook.createFont();
            font4.setFontHeight(13);
            font4.setBold(true);
            styleDate.setAlignment(HorizontalAlignment.LEFT);
            styleDate.setFont(font4);
            
            row = sheet.createRow(6);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Date:");
            cell.setCellStyle(styleDate);
            
            row = sheet.createRow(7);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Staff:");
            cell.setCellStyle(styleDate);
            
            row = sheet.createRow(8);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Type:");
            cell.setCellStyle(styleDate);
            
            row = sheet.createRow(9);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Table:");
            cell.setCellStyle(styleDate);
            
            String path = "D://NetBeansProjects//Software Technology - Coffee Shop//ExcelBill//" + billId + ".xlsx";
            //Tao mot doi tuong file tren dia
            File f = new File(path);
            //Mo file
            try (FileOutputStream fis = new FileOutputStream(f)){
                //Ghi khu vuc lam viec len file
                workBook.write(fis);
                
            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.err.println("Error at prinBill method of BillBUS class");
            }  
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Error at prinBill method of BillBUS class");
        }
    }
    
    public static void main(String[] args) {
        BillBUS o = new BillBUS();
        o.printBill("BL001");
    }
    
    
}
