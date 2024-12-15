package com.kp.entities.embedded;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Embeddable
public class OrderId implements Serializable{
	
	private Long id;
	
	private String username;
	
	@Embedded
	private Address address;
	
	
	

}
