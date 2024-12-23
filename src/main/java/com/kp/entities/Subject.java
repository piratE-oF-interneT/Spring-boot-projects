package com.kp.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;
	
	private String title;
	
	@OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
	private List<Professor> allotedProfessors;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;

	public Integer getId() {
		return subjectId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(allotedProfessors, subjectId, title);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Subject other = (Subject) obj;
//		return Objects.equals(allotedProfessors, other.allotedProfessors) && Objects.equals(subjectId, other.subjectId)
//				&& Objects.equals(title, other.title);
//	}

	public void setId(Integer id) {
		this.subjectId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Professor> getAllotedProfessors() {
		return allotedProfessors;
	}

	public void setAllotedProfessors(List<Professor> allotedProfessors) {
		this.allotedProfessors = allotedProfessors;
	}

	public Subject(String title, List<Professor> allotedProfessors) {
		super();
		this.title = title;
		this.allotedProfessors = allotedProfessors;
	}

	public Subject() {
		super();
	}
	
	

}
