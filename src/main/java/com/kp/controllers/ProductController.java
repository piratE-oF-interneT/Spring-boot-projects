package com.kp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.entities.Product;
import com.kp.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("getAll")
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "id") String SortBy,
										@RequestParam(defaultValue = "1") Integer page										
			) {
		
//		return productRepository.findBy(
//				Sort.by(Sort.Order.asc(SortBy),
//						Sort.Order.asc("name")
//						)
//				
//				
//				);
		
	
		PageRequest pageable = PageRequest.of(page, 5);
		
		return productRepository.findAll(pageable);
		
	}
	
	
	

}
