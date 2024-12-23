package com.kp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.entities.Professor;
import com.kp.entities.Student;
import com.kp.service.ProfessorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/professors")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/create")
	public Professor admitProfessor(@RequestBody Professor professor) {
		//TODO: process POST request
		
		return professorService.admitProfessor(professor);
	}
	
	@PutMapping("professor/{professorId}/subject/{subjectId}")
	public Professor assignSubjectToProfessor(@PathVariable Integer professorId , @PathVariable Integer subjectId) {
		//TODO: process PUT request
		
		return professorService.assignSubjectToProfessor(professorId,subjectId);
	}

}
