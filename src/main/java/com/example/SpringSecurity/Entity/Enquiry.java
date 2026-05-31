package com.example.SpringSecurity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enquiry 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eqid;
    private String name,mobile,course,date;
    public Enquiry() {
    }
    public Enquiry(int eqid, String name, String mobile, String course, String date) {
        this.eqid = eqid;
        this.name = name;
        this.mobile = mobile;
        this.course = course;
        this.date = date;
    }
    public int getEqid() {
        return eqid;
    }
    public void setEqid(int eqid) {
        this.eqid = eqid;
    }
    public String getName() {
        return name;
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
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Enquiry [eqid=" + eqid + ", name=" + name + ", mobile=" + mobile + ", course=" + course + ", date="
                + date + "]";
    }

    
}
