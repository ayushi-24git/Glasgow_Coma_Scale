package com.example.aarnarratta.glasgowcomascale;

/**
 * Created by aarnarratta on 13-04-2018.
 */

public class UserInformation {
    public String name;
    public String address;
    public String mobile;
    public String patientid;
    public void UserInformation(){

    }
    public UserInformation(String name, String address, String mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
//        this.patientid = patientid;
    }
    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name=name;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String Address){
        this.address=address;
    }
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String Mobile){
        this.name=mobile;
    }
//    public String getPatientId(){
//        return patientid;
//    }
//    public void setPatientId(String Mobile){
//        this.name=patientid;
//    }
}