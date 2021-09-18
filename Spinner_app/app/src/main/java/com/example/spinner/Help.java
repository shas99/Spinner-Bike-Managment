package com.example.spinner;

public class Help {

    String ID,Test;

    public Help() {

    }

    public Help(String ID, String test) {
        this.ID = ID;
        Test = test;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTest() {
        return Test;
    }

    public void setTest(String test) {
        Test = test;
    }
}
