package com.example.spinner;

public class CreateTest {
    String Brand;
    String Name;
    String Origin;
    String Review;
    String id5;
    String Image;


    public CreateTest(){

    }



    public CreateTest(String Brand, String Name, String Origin, String Review, String ID,String Image) {
        this.Brand = Brand;
        this.Name = Name;
        this.Origin = Origin;
        this.Review = Review;
        this.Image = Image;
        id5 = ID;

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
