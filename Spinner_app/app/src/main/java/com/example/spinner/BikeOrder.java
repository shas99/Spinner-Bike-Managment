package com.example.spinner;

public class BikeOrder {

    String cyclerID;
    String mobileNo;
    String NIC;
    String bicycleType;

    public BikeOrder(){

    }

    public BikeOrder(String cyclerID,String mobileNo,String NIC,String bicycleType) {
        this.cyclerID = cyclerID;
        this.mobileNo=mobileNo;
        this.NIC=NIC;
        this.bicycleType=bicycleType;

    }

    public String getCyclerID() {
        return cyclerID;
    }

    public void setCyclerID(String cyclerID) {
        this.cyclerID = cyclerID;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(String bicycleType) {
        this.bicycleType = bicycleType;
    }
}
