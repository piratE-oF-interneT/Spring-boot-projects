package com.kp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.entities.Subject;
import com.kp.service.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	
	@PostMapping("/create")
	public Subject createNewSubject(@RequestBody Subject subject) {
		//TODO: process POST request
		
		return subjectRepository.save(subject);
	}
	

}
