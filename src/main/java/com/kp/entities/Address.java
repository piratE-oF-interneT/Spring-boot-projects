package com.kp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name="address_table")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Address {
	
	@Id
	private Long id;
	
	private String street;
	
	private Integer zipCode;
	
	private String houseNumber;
	
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;
	

}
