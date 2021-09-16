package com.example.spinner;

public class UserDetails {
    private static String name,email,sex,mobileNo,points;

    UserDetails(String name, String email, String sex, String mobileNo,String Points) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.mobileNo = mobileNo;
        this.points = Points;


    }
    public static String getName(){
        return name;
    }
    public static String getEmail(){
        return email;
    }
    public static String getSex(){
        return sex;
    }
    public static String getMobileNo(){
        return mobileNo;
    }
    public static String getPoints(){
        return points;
    }
}