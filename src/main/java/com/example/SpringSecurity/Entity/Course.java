package com.example.SpringSecurity.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;
    String name;
    int fees;
    String duration;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Student> students=new ArrayList<>();
    public Course() {
    }
    public Course(int cid, String name, int fees, String duration, List<Student> students) {
        this.cid = cid;
        this.name = name;
        this.fees = fees;
        this.duration = duration;
        this.students = students;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFees() {
        return fees;
    }
    public void setFees(int fees) {
        this.fees = fees;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "Course [cid=" + cid + ", name=" + name + ", fees=" + fees + ", duration=" + duration + "]";
    }    

}
