package com.example.spinner;

public class AcceptRide {
    private static String Size, Time, Date;
    private static boolean Premium;

    public AcceptRide() {
    }

    public AcceptRide (boolean premium,String size,String time,String date) {
        Time = time;
        Date = date;
        Premium = premium;
        Size = size;
    }

    public static boolean getPremium() {
        return Premium;
    }

    public static void setPremium(boolean premium) {
        Premium = premium;
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
}




