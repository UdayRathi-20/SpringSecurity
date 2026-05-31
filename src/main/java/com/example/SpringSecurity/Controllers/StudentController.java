package com.example.SpringSecurity.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Course;
import com.example.SpringSecurity.Entity.Fees;
import com.example.SpringSecurity.Entity.Student;
import com.example.SpringSecurity.Repository.StudentRepo;

//to be secure and only user can access which having "Student" as Authority
@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    StudentRepo srepo;

    @RequestMapping("/profile")
    public String profile(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Student student = srepo.findStudentByUsername(username);
        Course course = student.getCourse();
        model.addAttribute("student", student);
        model.addAttribute("course", course);
        return "student/profile.html";
    }

    @RequestMapping("/incorrect")
    public String incorrect() {
        return "student/incorrect.html";
    }

    @RequestMapping("/feeCard")
    public String feeCard(Model model) {
        Student student=(Student)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Course course = student.getCourse();
        List<Fees> fees = student.getFees();
        model.addAttribute("student", student);
        model.addAttribute("course", course);
        model.addAttribute("fees", fees);
        return "student/feeCard.html";
    }

    @RequestMapping("/password")
    public String password()
    {
        return "/student/changePassword.html";  
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("currentpassword") String currentpassword,@RequestParam("newpassword") String newpassword) 
    {
        Student student=(Student)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String previousPassword = student.getMobile();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean ans = encoder.matches(currentpassword,previousPassword);
        if (ans == true) {
            student.setMobile(encoder.encode(newpassword));
            srepo.save(student);
            return "redirect:/logout";
        } else {
            return "redirect:/student/incorrect";
        }

    }

    @RequestMapping("/contact")
    public String contact() {
        return "/student/contact.html";
    }
}
