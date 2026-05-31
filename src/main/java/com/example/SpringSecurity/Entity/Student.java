package com.example.SpringSecurity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String name,mobile,aadhar,username;

    @ManyToOne
    Course course;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Fees> fees;
    public Student() {
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", name=" + name + ", mobile=" + mobile + ", aadhar=" + aadhar + ", username="
                + username + ", course=" + course + ", fees=" + fees + "]";
    }








    public Student(int sid, String name, String mobile, String aadhar, String username, Course course,
            List<Fees> fees) {
        this.sid = sid;
        this.name = name;
        this.mobile = mobile;
        this.aadhar = aadhar;
        this.username = username;
        this.course = course;
        this.fees = fees;
    }


    public int getSid() {
        return sid;
    }


    public void setSid(int sid) {
        this.sid = sid;
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


    public String getAadhar() {
        return aadhar;
    }


    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       ArrayList<SimpleGrantedAuthority> data = new ArrayList<>();
       SimpleGrantedAuthority xyz = new SimpleGrantedAuthority("Student");
       data.add(xyz);
       return data;
    }

    @Override
    public String getPassword() {
        return mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }








    public List<Fees> getFees() {
        return fees;
    }








    public void setFees(List<Fees> fees) {
        this.fees = fees;
    }

    
    
}
