package com.mehmetpekdemir.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;
import com.mehmetpekdemir.ecommerce.error.ServiceException;
import com.mehmetpekdemir.ecommerce.repository.CategoryRepository;
import com.mehmetpekdemir.ecommerce.service.CategoryService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryViewDTO> getCategories() {
		return categoryRepository.findAll().stream().map(CategoryViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public CategoryViewDTO getCategoryById(Long id) {
		final Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ServiceException(String.format("Category not found with ID %d", id)));
		return CategoryViewDTO.of(category);
	}

	@Override
	public Category getCategoryByCategoryId(Long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ServiceException(String.format("Category not found with ID %d", categoryId)));
	}

	@Override
	public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO) {
		final Category category = categoryRepository.save(new Category(categoryCreateDTO.getName()));
		return CategoryViewDTO.of(category);
	}

	@Override
	public CategoryViewDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ServiceException(String.format("Category not found with ID %d", id)));

		category.setName(categoryUpdateDTO.getName());

		final Category updatedCategory = categoryRepository.save(category);
		return CategoryViewDTO.of(updatedCategory);
	}

}
