package com.mehmetpekdemir.ecommerce.service;

import java.util.List;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
public interface CategoryService {
	public List<CategoryViewDTO> getCategories();

	public CategoryViewDTO getCategoryById(Long id);

	public Category getCategoryByCategoryId(Long categoryId);

	public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO);

	public CategoryViewDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO);
}
