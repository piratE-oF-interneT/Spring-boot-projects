package com.kp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.kp.entities.Subject;

@Service
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
