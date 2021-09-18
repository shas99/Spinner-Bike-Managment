package com.example.spinner;

public class isStartButtonClicked {

    public static Boolean isClicked;

    isStartButtonClicked(Boolean isClicked){
        this.isClicked = isClicked;
    }


    public static Boolean getIsClicked(){
        return isClicked;
    }


    public static void setIsClicked(Boolean isClicked) {
        isStartButtonClicked.isClicked = isClicked;
    }
}
