package com.example.spinner;

public class Help {

    String ID, Size, Time, Date,Price;
    Boolean Premium;

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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Boolean getPremium() {
        return Premium;
    }

    public void setPremium(Boolean premium) {
        Premium = premium;
    }
}
