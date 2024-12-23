package com.kp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admission_id",referencedColumnName = "id")
	private AdmissionRecord admissionRecord;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(
			name="student_professor_table",
			joinColumns = {
					@JoinColumn(name = "student_id")
				
			},
			inverseJoinColumns = {
					@JoinColumn(name = "professor_id")
			}
			
			)
	
	private List<Professor> professors;
	
	@ManyToMany
	@JoinTable(name = "student_subject_table",
				joinColumns = {
						@JoinColumn(name="student_id")
				},
				inverseJoinColumns = {
						@JoinColumn(name="subject_id")
				}
				
			)
	private List<Subject> subjects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdmissionRecord getAdmissionRecord() {
		return admissionRecord;
	}

	public void setAdmissionRecord(AdmissionRecord admissionRecord) {
		this.admissionRecord = admissionRecord;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Student(String name, AdmissionRecord admissionRecord, List<Professor> professors) {
		super();
		this.name = name;
		this.admissionRecord = admissionRecord;
		this.professors = professors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student() {
		super();
	} 
	
	
	
	
	

}
