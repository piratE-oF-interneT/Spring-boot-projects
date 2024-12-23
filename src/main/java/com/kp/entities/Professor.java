package com.kp.entities;

import java.util.List;
import java.util.jar.Attributes.Name;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	@ManyToMany(mappedBy = "professors")
	
	private List<Student> students;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id",referencedColumnName = "subjectId")
	private Subject subject;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public Professor(String name, List<Student> students, Subject subject) {
		super();
		this.name = name;
		this.students = students;
		this.subject = subject;
	}


	public Professor() {
		super();
	}
	
	
	

}
