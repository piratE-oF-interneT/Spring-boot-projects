package com.kp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.entities.AdmissionRecord;
import com.kp.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
