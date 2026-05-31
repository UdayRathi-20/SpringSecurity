package com.example.SpringSecurity.Controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Course;
import com.example.SpringSecurity.Entity.Student;
import com.example.SpringSecurity.Repository.CourseRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@RequestMapping("/admin/course")
@Controller
public class CourseController 
{
    @Autowired
    CourseRepo crepo;

    @Autowired
    StudentRepo srepo;

    @RequestMapping("")             
    public String signUpCourse()
    {
        return "/admin/course/courseSignup.html";
    }

    @PostMapping("")
    @ResponseBody
    public String saveCourse(Course course)
    {   
        
        crepo.save(course);
        return "Course Added!";        
    }

    
    @RequestMapping("/display")
    public String display(Model model)
    {
        List<Course> data =(List<Course>)crepo.findAll();
        model.addAttribute("data", data);
        return "/admin/course/displayCourse.html";
    }

    @RequestMapping("/remove/{cid}")
    public String remove(@PathVariable("cid") int cid)
    {
        crepo.deleteById(cid);
        return "redirect:/admin/course/display";
    }

    @RequestMapping("/edit/{cid}")
    public String edit(@PathVariable("cid") int cid , Model model)
    {
        Course course=crepo.findById(cid).get();
        model.addAttribute("course", course);
        return "/admin/course/editCourse.html";
    }
    @PostMapping("/edit")
    public String edit(Course course)
    {
        crepo.save(course);
        return "redirect:/admin/course/display";
    }
    
    @RequestMapping("/viewStudent/{cid}")
    public String viewStudent(@PathVariable("cid") int cid, Model model)
    {
        Course course=crepo.findById(cid).get();
        List<Student> students=course.getStudents();
        String  name= course.getName();
        System.out.println("***********************************");
        System.out.println(name);
        System.out.println("***********************************");
        model.addAttribute("name", name);
        model.addAttribute("students", students);
        return "/admin/course/viewCourseStudent.html";
    }
}
