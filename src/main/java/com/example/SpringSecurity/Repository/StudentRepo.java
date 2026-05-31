package com.example.SpringSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.Entity.Student;

public interface StudentRepo extends CrudRepository<Student,Integer>
{
    public Student findStudentByUsername(String username);

}
