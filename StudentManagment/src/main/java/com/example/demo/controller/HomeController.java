package com.example.demo.controller;


import com.example.demo.Repository.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.Model.Student;
import com.example.demo.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private Studentservice service;


    @Autowired
    private StudentRepo repo;

    @GetMapping("/")
    public String Homepage()
    {
        return "HomePage";
    }


    @GetMapping("/addstudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student()); // empty form object
        return "add_Student"; // this is the name of your HTML file in templates
    }

    @PostMapping("/savestu")
    public String AddNewStudent(@ModelAttribute("student") Student stu) {
        service.AddNewStudent(stu);
        return "redirect:/Allstudents"; // redirect to show all students page (example)
    }


    @GetMapping("/getstudent/{prn}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable int prn) {
        Student student = service.getStudentInfo(prn);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/update_student")
    public String showFindStudentPage() {
        return "update_student"; // serves update_student.html
    }

    @GetMapping("/api/student/{prn}")
    @ResponseBody
    public ResponseEntity<Student> apiGetStudent(@PathVariable int prn) {
        Student student = service.getStudentInfo(prn);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/update_student2")
    public String showUpdateFormPage() {
        return "update_student2";
    }

    @PostMapping("/updatestudent")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@RequestBody Student stu) {
        String result = service.updateStudent(stu);
        if ("Updated Successfully!".equals(result)) {
            return ResponseEntity.ok("Student updated successfully!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed!");
    }






    @GetMapping("/student/{prn}")
    public ResponseEntity<Student> getStudentByPrn(@PathVariable int prn) {
        Optional<Student> student = repo.findById(prn);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/removeStudent")
    public String showRemoveStudentPage() {
        return "removeStudent";
    }

    @PostMapping("/findStudent")
    public String findStudent(@RequestParam int prn, Model model) {
        Student student = service.getStudentInfo(prn);
        if (student != null) {
            model.addAttribute("student", student);
        } else {
            model.addAttribute("message", "Student not found.");
        }
        return "removeStudent";
    }

    @DeleteMapping("/removeStudent/{prn}")
    public String removeStudent(@PathVariable int prn, Model model) {
        boolean removed = service.removeStudent(prn);
        if (removed) {
            model.addAttribute("message", "Student removed successfully.");
        } else {
            model.addAttribute("message", "Student not found.");
        }
        return "removeStudent";
    }


    @GetMapping("/Allstudents")
    public String getallstudents(Model model) {
        List<Student> studentlist = service.getallstudents();
        model.addAttribute("studentlist", studentlist);
        return "showall";
    }



}