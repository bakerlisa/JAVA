package com.codingdojo.StudentRosterMM.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.StudentRosterMM.models.StudentCourse;


@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse,Long> {
	List<StudentCourse> findAll();
}
