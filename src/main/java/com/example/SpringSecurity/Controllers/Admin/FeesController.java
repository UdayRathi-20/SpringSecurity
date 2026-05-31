package com.example.SpringSecurity.Controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.Entity.Course;
import com.example.SpringSecurity.Entity.Fees;
import com.example.SpringSecurity.Entity.Student;
import com.example.SpringSecurity.Repository.FeesRepo;
import com.example.SpringSecurity.Repository.StudentRepo;

@Controller
@RequestMapping("/admin/fees")
public class FeesController 
{

    @Autowired
    StudentRepo srepo;

    @Autowired
    FeesRepo feerepo;

    @RequestMapping("")
    public String studentList(Model model)
    {
        List<Student> data =(List<Student>)srepo.findAll();
        model.addAttribute("data", data);
        return "/admin/fees/studentList.html";
    }

    

    @RequestMapping("/feeSubmit/{sid}")
    public String feeSubmit(@PathVariable("sid") int sid,Model model)
    {
        Student student=srepo.findById(sid).get();
        Course course = student.getCourse();
        model.addAttribute("student", student);
        model.addAttribute("course", course);
        return"admin/fees/feeSubmit.html";
    }

    @PostMapping("/save")
    public String save(Fees fees,@RequestParam("sid") int sid )
    {
        Student student=srepo.findById(sid).get();
        List<Fees> feesList=student.getFees();
        
        feesList.add(fees);
        fees.setStudent(student);
        srepo.save(student);
        
        return"redirect:/admin/fees";
    }

    @RequestMapping("/feeCard/{sid}")
    public String feeCard(@PathVariable("sid") int sid,Model model)
    {
        Student student=srepo.findById(sid).get();
        
        List<Fees> fees = student.getFees();
        
        model.addAttribute("fees", fees);

        return"admin/fees/feeCard.html";
    
    }

    @RequestMapping("/feeReceipt/{feeid}")
    public String feeReceipt(@PathVariable("feeid") int feeid,Model model)
    {
        Fees fees=feerepo.findById(feeid).get();
        Student student=fees.getStudent();
        Course course=student.getCourse();
        model.addAttribute("fees", fees);
        model.addAttribute("student", student);
        model.addAttribute("course", course);
        return"admin/fees/feeReceipt.html";
    }
}
