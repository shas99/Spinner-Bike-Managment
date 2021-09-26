package com.example.spinner;

public class CreateTest {
    String Brand;
    String Name;
    String Origin;
    String Review;
    String id5;
    String Image;
    String Lease;
    String Day;
    String Year;


    public CreateTest(){

    }



    public CreateTest(String Brand, String Name, String Origin, String Review, String ID,String Image, String Lease, String Day, String Year) {
        this.Brand = Brand;
        this.Name = Name;
        this.Origin = Origin;
        this.Review = Review;
        this.Image = Image;
        id5 = ID;
        this.Lease = Lease;
        this.Day = Day;
        this.Year = Year;

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

    public void setName(String name) {
        Name = name;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getId5() {
        return id5;
    }

    public void setId5(String id5) { this.id5 = id5; }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
