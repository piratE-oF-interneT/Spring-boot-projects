package com.kp.entities.embedded;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable{
	
	private String street;
	
	private String houseNumber;
	
	private String zipCode;
	
	

}
