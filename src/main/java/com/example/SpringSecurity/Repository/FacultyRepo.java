package com.example.SpringSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.Entity.Faculty;

public interface FacultyRepo extends CrudRepository<Faculty,Integer>
{
    public Faculty findFacultyByUsername(String username);    
}
