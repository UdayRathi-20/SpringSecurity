package com.example.SpringSecurity.Controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.SpringSecurity.Repository.FacultyRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@RequestMapping("/admin")
@Controller
public class AdminController 
{

    @Autowired
    FacultyRepo frepo;

    @Autowired
    StudentRepo srepo;

    @RequestMapping("/profile")
    @ResponseBody
    public String profile()
    {
        return "Admin Profile";
    }    
    @RequestMapping("/edit")
    @ResponseBody
    public String edit()
    {
        return "Admin Profile Edit";
    }    

    

    
}
    

