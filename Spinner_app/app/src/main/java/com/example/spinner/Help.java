package com.example.spinner;

public class Help {

    private static String ID, Size, Time, Date,Price;
    private static Boolean Premium;

    public Help() {

    }

    public Help(String ID, Boolean premium, String size, String time, String date,String price) {
        this.ID = ID;
        Premium = premium;
        Size = size;
        Time = time;
        Date = date;
        Price = price;
    }

    public static String getPrice() {
        return Price;
    }

    public static void setPrice(String price) {
        Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static String getSize() {
        return Size;
    }

    public static void setSize(String size) {
        Size = size;
    }

    public static String getTime() {
        return Time;
    }

    public static void setTime(String time) {
        Time = time;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String date) {
        Date = date;
    }

    public static Boolean getPremium() {
        return Premium;
    }

    public static void setPremium(Boolean premium) {
        Premium = premium;
    }
}
