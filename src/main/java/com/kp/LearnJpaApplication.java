package com.kp;

import java.time.LocalDateTime;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.kp.entities.Author;
import com.kp.entities.Product;
import com.kp.entities.Video;
import com.kp.repositories.AuthorRepository;
import com.kp.repositories.ProductRepository;
import com.kp.repositories.VideoRepository;

import lombok.experimental.var;
import lombok.Builder;


@SpringBootApplication
public class LearnJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaApplication.class, args);
		
		
	}
	
//	@Bean
	
	public CommandLineRunner commandLineRunner(AuthorRepository AuthorRepository , VideoRepository videoRepository,ProductRepository productRepository) {
		
		
		
		return args -> {
//			for (int i = 0; i < 10; i++) {
////				Faker faker = new Faker();
////				Author author = new Author();
////				author.setFirstName(faker.name().firstName());
////				author.setLastName(faker.name().lastName());
////				author.setCreatedAt(LocalDateTime.now());
////				author.setEmail(faker.name().username()+i+"kp@gmail.com");
////				
////				AuthorRepository.save(author);
////				int data = AuthorRepository.updateAllLastName("Pandey");
////				System.out.println(data);
//				
//				
//			}
//			AuthorRepository.updateEmail("kartikPandey1164@gmail.com",103L);
			
//			Author author = AuthorRepository.getAuthor(105L);
//			System.out.println(author);

			
			
//			Video video = new Video();
//			
//			video.setLength(1200);
//			video.setName("kartiks video");
//			
//			videoRepository.save(video);
			
			
//			inserting product entity
			
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				Product product = new Product();
				
				product.setName(faker.commerce().productName());
				
				product.setPrice(faker.random().nextDouble());
				
				productRepository.save(product);
				
				
			}
			
			
			
			
		
			
			
		};
		
	}

}
