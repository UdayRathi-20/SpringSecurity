package com.example.SpringSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.Entity.Admin;

public interface AdminRepo extends CrudRepository<Admin,Integer>
{
    public Admin findAdminByUsername(String username);    
}