package com.example.SpringSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurity.Entity.Course;

public interface CourseRepo extends CrudRepository<Course,Integer>
{
    
}
