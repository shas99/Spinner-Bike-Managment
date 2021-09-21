package com.example.spinner;

public class Event_Model {

    String Name,Start,End,Web,Banner;

    public Event_Model() {
    }

    public Event_Model(String name, String start, String end, String web, String banner) {
        Name = name;
        Start = start;
        End = end;
        Web = web;
        Banner = banner;
    }

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }
}
