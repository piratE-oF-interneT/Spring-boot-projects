package com.kp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.entities.Professor;
import com.kp.entities.Student;
import com.kp.repository.ProfessorRepository;
import com.kp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public Student admitStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentRepository.save(student);
		
		
		
	
	}

	public Student assignProfessorToStudent(Integer studentId, Integer professorId) {
		// TODO Auto-generated method stub
		
		Optional<Student> studentEntity = studentRepository.findById(studentId);
		Optional<Professor> professorEntity = professorRepository.findById(professorId);
		
		
		
		return studentEntity.flatMap(student -> professorEntity.map(professor -> {
			student.getProfessors().add(professor);
			return studentRepository.save(student);
		})).orElse(null);
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		
		
		return studentRepository.findById(id).orElse(null);
	}

}
