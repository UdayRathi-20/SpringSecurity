package com.example.SpringSecurity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Admin;


import com.example.SpringSecurity.Repository.AdminRepo;
import com.example.SpringSecurity.Repository.FacultyRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@Controller
public class WebsiteController {


    @Autowired
    FacultyRepo frepo;

    @Autowired
    StudentRepo srepo;
    
    @Autowired
    AdminRepo arepo;

    @RequestMapping({"/home","/"})
    public String home()
    {
        return "website/index.html";
    }
    @RequestMapping("/main")
    public String main()
    {
        return "/home.html";
    }
    @RequestMapping("/contact")
    @ResponseBody
    public String contact()
    {
        return "Contact us";
    }

    

    @RequestMapping("/admin")
    public String signUpAdmin()
    {
        return "adminSignup.html";
    }

    @PostMapping("/admin")
    @ResponseBody
    public String saveAdmin(Admin admin)
    {   
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        admin.setMobile(encoder.encode(admin.getMobile()));

        admin.setUsername(admin.getAadhar());

        arepo.save(admin);
        return "Admin stored!";        
    }

   
}
