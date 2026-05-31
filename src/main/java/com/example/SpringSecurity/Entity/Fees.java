package com.example.SpringSecurity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Fees 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int feeid;
    int amount;
    String date;

    @ManyToOne
    Student student;

    public Fees() {
    }

    public Fees(int feeid, int amount, String date, Student student) {
        this.feeid = feeid;
        this.amount = amount;
        this.date = date;
        this.student = student;
    }

    public int getFeeid() {
        return feeid;
    }

    public void setFeeid(int feeid) {
        this.feeid = feeid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Fees [feeid=" + feeid + ", amount=" + amount + ", date=" + date + "]";
    }

    

}
