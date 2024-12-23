package com.kp.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	List<Product> findBy(Sort sort);

}
