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

import com.example.SpringSecurity.Entity.Course;
import com.example.SpringSecurity.Entity.Enquiry;
import com.example.SpringSecurity.Entity.Faculty;
import com.example.SpringSecurity.Repository.EnquiryRepo;

@Controller
@RequestMapping("/admin/enquiry")
public class EnquiryController 
{
    @Autowired
    EnquiryRepo erepo;

    @RequestMapping("")
    public String signUpEnquiry()
    {
        
        return "admin/enquiry/enquirySignup.html";
    }

    @PostMapping("")
    @ResponseBody
    public String saveEnquiry(Enquiry enquiry)
    {   
        erepo.save(enquiry);
        return "Enquiry Saved";        
    }

    @RequestMapping("/display")
    public String display(Model model)
    {
        List<Enquiry> data =(List<Enquiry>)erepo.findAll();
        model.addAttribute("data", data);
        return "/admin/enquiry/displayEnquiry.html";
    }

    @RequestMapping("/remove/{eqid}")
    public String remove(@PathVariable("eqid") int eqid)
    {
        erepo.deleteById(eqid);
        return "redirect:/admin/enquiry/display";
    }

    @RequestMapping("/edit/{eqid}")
    public String edit(@PathVariable("eqid") int eqid , Model model)
    {
        Enquiry enquiry=erepo.findById(eqid).get();
        model.addAttribute("enquiry", enquiry);
        return "/admin/enquiry/editEnquiry.html";
    }
    @PostMapping("/edit")
    public String edit(Enquiry enquiry)
    {
        erepo.save(enquiry);
        return "redirect:/admin/enquiry/display";

    }

}
