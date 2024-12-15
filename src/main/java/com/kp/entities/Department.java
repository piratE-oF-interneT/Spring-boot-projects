package com.kp.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Department {
	
	@Id
	private Long id;
	
	private String name;
	
	
	@OneToMany(mappedBy = "department")

	private List<EmployeeEntity> employees;
	

}
