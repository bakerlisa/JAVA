package com.codingdojo.studentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.studentRoster.models.Dorm;
import com.codingdojo.studentRoster.models.Student;
import com.codingdojo.studentRoster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo){
		this.studentRepo = studentRepo;
	}
	
	public List<Student> allStudents(){
		return studentRepo.findAll();
	}
	
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}
	
	public Student addStudentFrom(Student student) {
		return studentRepo.save(student);
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optStudent = studentRepo.findById(id);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}else {
			return null;
		}
	}
	
	public Student editStudentFrom(Student student) {
		Optional<Student> optStudent = studentRepo.findById(student.getId());
		if(optStudent.isPresent()) {
			Student thisStudent = optStudent.get();
			
			thisStudent.setFirstName(student.getFirstName());
			thisStudent.setLastName(student.getLastName());
			thisStudent.setDorm(student.getDorm());
		
			return studentRepo.save(thisStudent);
		}else {
			return null;
		}
			
	}
}
