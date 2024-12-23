package com.kp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kp.entities.Author;

import jakarta.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author,Long>{
	
	@Modifying
	@Transactional
	@Query("update Author a set a.lastName=:lastName")
	
	int updateAllLastName(String lastName);
	
	@Modifying
	@Transactional
	@Query("update Author a set a.email = :email where id = :id")
	int updateEmail(String email , Long id);
	
	
	@Query("select a from Author a where id = :id ")
	
	Author getAuthor(Long id);
	

}
