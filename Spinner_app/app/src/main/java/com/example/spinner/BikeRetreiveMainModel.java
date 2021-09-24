package com.example.spinner;

public class BikeRetreiveMainModel {
    String Brand;
    String Name;
    String Origin;
    String Image;
    String Review;

    BikeRetreiveMainModel(){

    }





    public BikeRetreiveMainModel(String brand, String name, String origin, String image, String review) {
        Brand = brand;
        Name = name;
        Origin = origin;
        Image = image;
        Review = review;
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
