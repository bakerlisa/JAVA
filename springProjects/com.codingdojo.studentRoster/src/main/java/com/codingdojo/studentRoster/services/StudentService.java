package com.codingdojo.studentRoster.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
