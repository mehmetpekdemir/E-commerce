package com.mehmetpekdemir.ecommerce.service;

import java.util.List;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
public interface CategoryService {
	public List<CategoryViewDTO> getCategories();
	public CategoryViewDTO getCategoryById(Long categoryId);
	public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO);
}