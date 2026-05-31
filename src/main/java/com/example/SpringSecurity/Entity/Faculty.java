package com.example.SpringSecurity.Entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Faculty implements UserDetails
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int fid;
        private String name,qual,dob,mobile,aadhar,username;
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            ArrayList<SimpleGrantedAuthority> data= new ArrayList<>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("Faculty");
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
        public Faculty() {
        }
        public Faculty(int fid, String name, String qual, String dob, String mobile, String aadhar) {
            this.fid = fid;
            this.name = name;
            this.qual = qual;
            this.dob = dob;
            this.mobile = mobile;
            this.aadhar = aadhar;
        }
        public int getFid() {
            return fid;
        }
        public void setFid(int fid) {
            this.fid = fid;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getQual() {
            return qual;
        }
        public void setQual(String qual) {
            this.qual = qual;
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
        @Override
        public String toString() {
            return "Faculty [fid=" + fid + ", name=" + name + ", qual=" + qual + ", dob=" + dob + ", mobile=" + mobile
                    + ", aadhar=" + aadhar + ", username=" + username + "]";
        }

        public void setUsername(String username) {
            this.username = username;
        }
        
        


}
