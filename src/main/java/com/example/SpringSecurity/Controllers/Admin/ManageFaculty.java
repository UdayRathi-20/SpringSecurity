package com.example.SpringSecurity.Controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Faculty;
import com.example.SpringSecurity.Repository.FacultyRepo;

@RequestMapping("/admin/faculty")
@Controller
public class ManageFaculty {

    @Autowired
    FacultyRepo frepo;

    @RequestMapping("")             
    public String signUpFaculty()
    {
        return "admin/facultyCrud/facultySignup.html";
    }

    @PostMapping("")
    @ResponseBody
    public String saveFaculty(Faculty faculty)
    {   
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        faculty.setMobile(encoder.encode(faculty.getMobile()));

        faculty.setUsername(faculty.getAadhar());

        frepo.save(faculty);
        return "Faculty stored!";        
    }

    @RequestMapping("/display")
    public String display(Model model)
    {
        List<Faculty> data =(List<Faculty>)frepo.findAll();
        model.addAttribute("data", data);
        return "/admin/facultyCrud/displayFaculty.html";
    }

    @RequestMapping("/remove/{fid}")
    public String remove(@PathVariable("fid") int fid)
    {
        frepo.deleteById(fid);
        return "redirect:/admin/faculty/display";
    }

    @RequestMapping("/edit/{fid}")
    public String edit(@PathVariable("fid") int fid , Model model)
    {
        Faculty faculty=frepo.findById(fid).get();
        model.addAttribute("faculty", faculty);
        return "/admin/facultyCrud/editFaculty.html";
    }
    @PostMapping("/edit")
    public String edit(Faculty faculty)
    {
        frepo.save(faculty);
        return "redirect:/admin/faculty/display";

    }


}
