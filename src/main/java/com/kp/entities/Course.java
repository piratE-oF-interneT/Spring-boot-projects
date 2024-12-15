package com.kp.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
//	this is owning side and relation is bidirectional
//	use @JoinTable in owning side
	@ManyToMany
	@JoinTable(
				name = "course_author",
				joinColumns = {
//						joinColumns -> attribute must contain the primary / owning entity foreign key name --> Course entity
						@JoinColumn(name = "course_id")
				},
				inverseJoinColumns = {
//						inverseJoinColumns --> attribute must contain the inverse / non-owning foreign key name --> author entity
						@JoinColumn(name="author_id")
				}
			)
	private List<Author> authors;
	
	@OneToMany(mappedBy = "course")
	private List<Section> sections;

}
