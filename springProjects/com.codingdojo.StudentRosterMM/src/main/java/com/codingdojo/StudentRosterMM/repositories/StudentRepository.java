package com.codingdojo.StudentRosterMM.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.StudentRosterMM.models.Course;
import com.codingdojo.StudentRosterMM.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
	List<Student> findAll();

    List<Student> findByCoursesNotContains(Course course);
    
    List<Student> findAllByCourses(Course course);

}
