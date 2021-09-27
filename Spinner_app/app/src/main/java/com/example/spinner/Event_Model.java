package com.example.spinner;

public class Event_Model {

    //Database variables
    String name,Start,End,Web,Banner,Status;


    //default constructor for firebase
    public Event_Model() {
    }


    //constructors
    public Event_Model(String name, String start, String end, String web, String banner, String status) {
        this.name = name;
        Start = start;
        End = end;
        Web = web;
        Banner = banner;
        Status = status;
    }


    //Getters and Setters
    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getBanner() {
        return Banner;
    }

    public void setBanner(String banner) {
        Banner = banner;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
