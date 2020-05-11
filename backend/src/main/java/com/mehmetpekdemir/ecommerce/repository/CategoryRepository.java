package com.mehmetpekdemir.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetpekdemir.ecommerce.entity.Category;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Boolean existsByName(String name);
}
