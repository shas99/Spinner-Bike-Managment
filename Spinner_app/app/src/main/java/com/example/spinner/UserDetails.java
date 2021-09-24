package com.example.spinner;

public class UserDetails {
    private static String name,email,sex,mobileNo,points,ID,Target;

    UserDetails(String name, String email, String sex, String mobileNo,String Points,String ID,String Target) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.mobileNo = mobileNo;
        this.points = Points;
        this.ID = ID;
        this.Target = Target;

    }

    public static void setPoints(String points) {
        UserDetails.points = points;
    }

    public static String ID(){
        return ID;
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
    public static String getTarget(){
        return Target;
    }

}