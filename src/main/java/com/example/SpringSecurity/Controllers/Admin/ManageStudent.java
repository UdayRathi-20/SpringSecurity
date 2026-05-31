package com.example.SpringSecurity.Controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Course;
import com.example.SpringSecurity.Entity.Student;
import com.example.SpringSecurity.Repository.CourseRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@Controller
@RequestMapping("/admin/student")
public class ManageStudent 
{
    @Autowired
    CourseRepo crepo;

    @Autowired
    StudentRepo srepo;
    
    @RequestMapping("")
    public String signUpStudent(Model model)
    {
        List <Course>data=(List <Course>)crepo.findAll();
        model.addAttribute("data", data);
        return "admin/studentCrud/studentSignup.html";
    }

    @PostMapping("")
    @ResponseBody
    public String saveStudent(Student student,@RequestParam("cid") int cid)
    {   
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        student.setMobile(encoder.encode(student.getMobile()));
        student.setUsername(student.getAadhar());


        Course course=crepo.findById(cid).get();
        student.setCourse(course);
        List<Student> students=course.getStudents();
        students.add(student);
        
        course.setStudents(students);

        crepo.save(course);
        return "student saved!";
        
        
    }

    @RequestMapping("/display")
    public String display(Model model)
    {
        List<Student> data =(List<Student>)srepo.findAll();
        model.addAttribute("data", data);
        return "/admin/studentCrud/displayStudent.html";
    }

    
    @RequestMapping("/remove/{sid}")
    public String remove(@PathVariable("sid") int sid)
    {
        Student student=srepo.findById(sid).get();
        Course course=student.getCourse();
        List<Student> studentList=course.getStudents();

        ArrayList<Student> temp = new ArrayList<>();
        for(Student item : studentList)
        {
            if(sid!=item.getSid())
            {
                temp.add(item);
            }
        }
        course.setStudents(temp);
        crepo.save(course);
        srepo.deleteById(sid);

        
        return "redirect:/admin/student/display";
    }

    // @ResponseBody
    @RequestMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") int sid , Model model)
    {
        Student student=srepo.findById(sid).get();
        model.addAttribute("student", student);
        // return "ok ";
        return "/admin/studentCrud/editStudent.html";
        
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("name") String name,@RequestParam("mobile") String mobile,@RequestParam("aadhar")String aadhar,@RequestParam("sid") int sid)
    {
        Student student=srepo.findById(sid).get();
        student.setName(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        student.setMobile(encoder.encode(mobile));

        student.setAadhar(aadhar);
        student.setUsername(aadhar);
        srepo.save(student);
        // return "updated!";
        return "redirect:/admin/student/display";

    }
}
