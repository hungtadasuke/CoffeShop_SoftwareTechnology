package ApplicationHelper;

import java.time.LocalDate;

public class MyDate {
    //attribute
    private String day;
    private String month;
    private String year;

    public static int[][] arrDaysOfMonth = new int[][]{{31,28,31,30,31,30,31,31,30,31,30,31},
                                                       {31,29,31,30,31,30,31,31,30,31,30,31}};
    //constructor
    public MyDate() {
    }
    
    public MyDate(String date) {
        String[] temp = date.split("-");
        this.day = temp[2];
        this.month = temp[1];
        this.year = temp[0];
    }
    public MyDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void getDateNow() {
        LocalDate date = LocalDate.now(); //2021-12-11 LD
        String dateString = String.valueOf(date);  //2021-12-11 String
        String[] dateArray = dateString.split("-");
        this.day = dateArray[2];
        this.month = dateArray[1];
        this.year = dateArray[0];
    }
    
    
    @Override
    public String toString() {
        return this.day+"/"+this.month+"/"+this.year;
    }
    
}