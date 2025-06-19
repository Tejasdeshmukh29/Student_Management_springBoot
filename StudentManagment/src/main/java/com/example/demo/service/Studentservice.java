package com.example.demo.service;


import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {

    @Autowired
    private StudentRepo repo;

    public void AddNewStudent(Student stu) {
      repo.save(stu);
    }


    public Student getStudentInfo(int prn) {
        return repo.findByPrn(prn);
    }

@Transactional
    public String updateStudent(Student stu) {
        if (repo.existsByPrn(stu.getPrn())) {
            repo.save(stu);
            return "Updated Successfully!";
        }
        return "Internal Server Error!";
    }


    @Transactional
    public boolean removeStudent(int prn) {
        if(repo.existsByPrn(prn))
        {
            repo.deleteByPrn(prn);
            return true;
        }
        return false;
    }

    public List<Student> getallstudents() {
        return repo.findAll();
    }
}
