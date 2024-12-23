package com.kp.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Author {
	
	@Id
	@GeneratedValue(
				strategy = GenerationType.SEQUENCE , generator = "author_sequence"
			)
	
	@SequenceGenerator(
				name = "author_sequence",
				sequenceName = "abc",
				initialValue = 101,
				allocationSize = 5
				
			)
	private Long id;
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", createdAt=" + createdAt + ", courses=" + courses + "]";
	}

	@Column(
			nullable = false,
			insertable=true,
			updatable = true
		
			)
	private String firstName;
	
	@Column(
			nullable = true,
			insertable = true,
			updatable = true
			)
	private String lastName;
	
	@Column(
			unique = true,
			nullable = false,
			insertable = true,
			updatable = false
			)	
	private String email;
	
	@Column(
			insertable = true,
			updatable = false
			)
	private LocalDateTime createdAt;
	
//	this is inverse/non-owning side
	@ManyToMany(mappedBy = "authors")
	private List<Course> courses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	
	
	
	
	
	

}
