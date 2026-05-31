package com.example.SpringSecurity.Entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name,dob,mobile,aadhar,username;
    public Admin() {
    }
    public Admin(int aid, String name, String dob, String mobile, String aadhar, String username) {
        this.aid = aid;
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
        this.aadhar = aadhar;
        this.username = username;
    }
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
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
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "Admin [aid=" + aid + ", name=" + name + ", dob=" + dob + ", mobile=" + mobile + ", aadhar=" + aadhar
                + ", username=" + username + "]";
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        ArrayList<SimpleGrantedAuthority> data= new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("Admin");
        data.add(authority);
        return data;
    }
    @Override
    public String getPassword() {
            return mobile;      //mobile number as passwod
        }
    @Override
    public String getUsername() {
            return username;      //aadhar as username
        }

    
}
