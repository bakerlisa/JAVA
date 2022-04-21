package com.codingdojo.StudentRosterMM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.StudentRosterMM.models.Course;
import com.codingdojo.StudentRosterMM.models.Student;
import com.codingdojo.StudentRosterMM.repositories.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository coRepo;
	
	public CourseService(CourseRepository coRepo) {
		this.coRepo = coRepo;
	}
	
	public List<Course> allCourses() {
		return coRepo.findAll();
	}
	
	public Course createClass(Course course) {
		return coRepo.save(course);
	}
	
	public Course singleCourses(Long id) {
		Optional<Course> optCour = coRepo.findById(id);
		if(optCour.isPresent()) {
			return optCour.get();
		}else {
			return null;
		}
	}
	public List<Course> allClassMembers(Student student){
		return coRepo.findAllByStudents(student);
	}
	
	public List<Course> studentsNotContained(Student student){
		return coRepo.findByStudentsNotContains(student);
	}
}
