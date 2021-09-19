package com.example.spinner;

public class BikeType {
    private static String Size;
    private static boolean Premium;

    public BikeType() {
    }

    public BikeType(boolean premium,String size) {

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
}
