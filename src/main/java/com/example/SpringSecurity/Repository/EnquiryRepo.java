package com.example.SpringSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.Entity.Enquiry;

public interface EnquiryRepo extends  CrudRepository<Enquiry,Integer>
{
    
}
