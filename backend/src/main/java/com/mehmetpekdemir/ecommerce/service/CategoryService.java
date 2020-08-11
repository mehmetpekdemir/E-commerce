package com.mehmetpekdemir.ecommerce.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface CategoryService {

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Cacheable(cacheNames = "getCategories")
	List<CategoryViewDTO> getCategories();

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	CategoryViewDTO getCategoryById(Long id);

	Category getCategoryByCategoryId(Long categoryId);

	@CacheEvict(cacheNames = "getCategories", allEntries = true)
	CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO);

	@CacheEvict(cacheNames = "getCategories", allEntries = true)
	CategoryViewDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO);

}
