package com.example.SpringSecurity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Faculty;
import com.example.SpringSecurity.Repository.FacultyRepo;


//to be secure and only user can access which having "Faculty" as Authority
@RequestMapping("/faculty")
@Controller
public class FacultyController 
{
    @Autowired
    FacultyRepo frepo;

    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping("/profile")
    public String profile(Model model)
    {   
        Faculty faculty=(Faculty)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("faculty", faculty);

        return "faculty/profile.html";
    }    
    @RequestMapping("/edit")
    @ResponseBody
    public String edit()
    {
        return "Faculty Profile Edit";
    }    

    
}
