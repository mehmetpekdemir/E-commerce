package com.mehmetpekdemir.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.ecommerce.entity.Category;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Boolean existsByName(String name);

}
