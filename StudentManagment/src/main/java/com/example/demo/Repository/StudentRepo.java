package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

  public Student findByPrn(int prn);
  public boolean existsByPrn(int prn);
  void deleteByPrn(int prn);

}
