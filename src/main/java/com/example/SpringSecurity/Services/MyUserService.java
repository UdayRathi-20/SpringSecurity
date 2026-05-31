package com.example.SpringSecurity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.Entity.Admin;
import com.example.SpringSecurity.Entity.Faculty;
import com.example.SpringSecurity.Entity.Student;
import com.example.SpringSecurity.Repository.AdminRepo;
import com.example.SpringSecurity.Repository.FacultyRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@Service
public class MyUserService implements UserDetailsService
{

    @Autowired
    StudentRepo stRepo;

    @Autowired
    FacultyRepo fcRepo;

    @Autowired
    AdminRepo adRepo;

    @Override
    public UserDetails loadUserByUsername(String username)  
    {
        Student student=stRepo.findStudentByUsername(username);
        if(student!=null)
        {
            return student;
        }
        Faculty faculty= fcRepo.findFacultyByUsername(username);
        if(faculty!=null)
        {
            return faculty;
        }
        Admin admin = adRepo.findAdminByUsername(username);
        if(admin!=null)
        {
            return admin;
        }
        return null;
    }
    
}
