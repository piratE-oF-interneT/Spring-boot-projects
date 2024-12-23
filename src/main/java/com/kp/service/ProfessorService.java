package com.kp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.entities.Professor;
import com.kp.entities.Student;
import com.kp.entities.Subject;
import com.kp.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	public Professor admitProfessor(Professor professor) {
		
		
		
		// TODO Auto-generated method stub
		return professorRepository.save(professor);
	}

	public Professor assignSubjectToProfessor(Integer professorId, Integer subjectId) {
		// TODO Auto-generated method stub
		
		Optional<Professor> professorEntity = professorRepository.findById(subjectId);
		Optional<Subject> subjectEntity = subjectRepository.findById(subjectId);
		
		
		return professorEntity.flatMap(professor -> subjectEntity.map(subject ->{
				professor.setSubject(subject);
//				subject.getAllotedProfessors().add(professor);
				return professorRepository.save(professor);
		})).orElse(null);
	}
	
	
	
	

}
