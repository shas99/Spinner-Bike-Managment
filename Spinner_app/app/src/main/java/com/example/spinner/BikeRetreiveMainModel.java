package com.example.spinner;

public class BikeRetreiveMainModel {
    String Brand;
    String Name;
    String Origin;
    String Image;
    String Review;
    String Lease;
    String Day;
    String Year;

    BikeRetreiveMainModel(){

    }





    public BikeRetreiveMainModel(String brand, String name, String origin, String image, String review, String lease, String day, String year) {
        Brand = brand;
        Name = name;
        Origin = origin;
        Image = image;
        Review = review;
        Lease = lease;
        Day = day;
        Year = year;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getLease() {
        return Lease;
    }

    public void setLease(String lease) {
        Lease = lease;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) { Name = name; }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getReview() { return Review; }

    public void setReview(String review) { Review = review; }

}
