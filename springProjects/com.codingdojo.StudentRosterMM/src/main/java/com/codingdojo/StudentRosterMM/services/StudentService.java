package com.codingdojo.StudentRosterMM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.StudentRosterMM.models.Course;
import com.codingdojo.StudentRosterMM.models.Student;
import com.codingdojo.StudentRosterMM.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository stuRepo;
	
	public StudentService(StudentRepository stuRepo) {
		this.stuRepo = stuRepo;
	}
	
	public List<Student> allStudents(){
		return stuRepo.findAll();
	}
	
	public List<Student> studentsNotContained(Course course){
		return stuRepo.findByCoursesNotContains(course);
	}
	
	public Student createStudent(Student student) {
		return stuRepo.save(student);
	}
	
	public Student singleStudent(Long id) {
		Optional<Student> optStu = stuRepo.findById(id);
		if(optStu.isPresent()) {
			return optStu.get();
		}else {
			return null;
		}
	}
		
	public List<Student> allClassMembers(Course course){
		return stuRepo.findAllByCourses(course);
	}
}
