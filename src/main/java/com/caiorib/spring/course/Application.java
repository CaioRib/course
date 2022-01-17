package com.caiorib.spring.course;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.domain.ProductEntity;
import com.caiorib.spring.course.repositories.CategoryRepository;
import com.caiorib.spring.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void startupDB() {
		CategoryEntity category1 = new CategoryEntity(null, "Informática");
		CategoryEntity category2 = new CategoryEntity(null, "Escritório");

		ProductEntity product1 = new ProductEntity(null, "Computador", "2000");
		ProductEntity product2 = new ProductEntity(null, "Impressora", "800");
		ProductEntity product3 = new ProductEntity(null, "Mouse", "80");

		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
	}

}
