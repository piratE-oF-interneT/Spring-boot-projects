package com.kp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.entities.Student;

import com.kp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public Student admitStudent(@RequestBody Student student) {
		//TODO: process POST request
		
		return studentService.admitStudent(student);
	}
	
	@PutMapping("/professors/student/{studentId}/professor/{professorId}")
	public Student assignProfessorToStudent(@PathVariable Integer studentId,@PathVariable Integer professorId) {
		//TODO: process PUT request
		
		return studentService.assignProfessorToStudent(studentId,professorId);
	}
	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable Integer id) {
		
		
		return studentService.getStudent(id);
	}
	

	
	
	
	

}
