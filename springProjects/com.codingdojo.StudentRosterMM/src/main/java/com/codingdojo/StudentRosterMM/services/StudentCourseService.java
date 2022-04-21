package com.codingdojo.StudentRosterMM.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.StudentRosterMM.models.StudentCourse;
import com.codingdojo.StudentRosterMM.repositories.StudentCourseRepository;

@Service
public class StudentCourseService {
	private final StudentCourseRepository stuCoRepo;
	
	public StudentCourseService(StudentCourseRepository stuCoRepo) {
		this.stuCoRepo = stuCoRepo;
	}
	
	public List<StudentCourse> allStudentsCourses(){
		return stuCoRepo.findAll();
	}
	
	public StudentCourse createStudentClass(StudentCourse studentCourse) {
		return stuCoRepo.save(studentCourse);
	}
}
