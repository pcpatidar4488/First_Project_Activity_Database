package com.example.berylsystem;

import java.security.PrivateKey;

public class DataProvider {

    private String name;
    private String rollno;
     private String mobile;
    private String etclass;
    private String id;

    public DataProvider(String id,String name,String rollno,String mobile,String etclass)
    {
        this.id=id;
        this.name=name;
        this.rollno=rollno;
        this.mobile=mobile;
        this.etclass=etclass;
    }

   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

   public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEtclass() {
        return etclass;
    }

    public void setEtclass(String etclass) {
        this.etclass = etclass;
    }
}