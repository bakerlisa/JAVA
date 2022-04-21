package com.codingdojo.StudentRosterMM.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.StudentRosterMM.models.Course;
import com.codingdojo.StudentRosterMM.models.Student;


@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
	List<Course> findAll();
	
    List<Course> findByStudentsNotContains(Student student);
    
    List<Course> findAllByStudents(Student student);
}

