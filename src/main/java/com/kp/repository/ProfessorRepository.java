package com.kp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
