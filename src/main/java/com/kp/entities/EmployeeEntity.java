package com.kp.entities;

import com.kp.entities.Role;

import org.hibernate.annotations.ManyToAny;
import org.springframework.context.annotation.Fallback;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="employee")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeEntity {
	
	@Id
//	by default strategy=generationType.AUTO
	private Long id;
	
	private String name;
	
	@Column(nullable = false , unique = true)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "Address_id")
	private Address address;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	
	@ManyToOne
	@JoinColumn(name="department _id")
	private Department department;
	
	

}
