package com.mehmetpekdemir.ecommerce.service.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;
import com.mehmetpekdemir.ecommerce.exception.ServiceException;
import com.mehmetpekdemir.ecommerce.repository.CategoryRepository;
import com.mehmetpekdemir.ecommerce.service.CategoryService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Cacheable(cacheNames = "getCategories")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<CategoryViewDTO> getCategories() {
		return categoryRepository.findAll().stream().map(CategoryViewDTO::of).collect(Collectors.toList());
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public CategoryViewDTO getCategoryById(Long id) {
		Category category = getCategoryByCategoryId(id);
		return CategoryViewDTO.of(category);
	}

	@Override
	public Category getCategoryByCategoryId(Long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ServiceException(String.format("Category not found with ID %d", categoryId)));
	}

	@CacheEvict(cacheNames = "getCategories", allEntries = true)
	@Override
	public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO) {
		AreTheseFieldsValid(categoryCreateDTO);
		Category category = categoryRepository.save(new Category(categoryCreateDTO.getName()));
		return CategoryViewDTO.of(category);
	}

	@Override
	public CategoryViewDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO) {
		Category category = getCategoryByCategoryId(id);
		AreTheseFieldsValid(categoryUpdateDTO);
		category.setName(categoryUpdateDTO.getName());
		Category updatedCategory = categoryRepository.save(category);
		return CategoryViewDTO.of(updatedCategory);
	}

	private boolean notExistsByName(String name) {
		return !categoryRepository.existsByName(name);
	}

	private void AreTheseFieldsValid(CategoryUpdateDTO categoryUpdateDTO) {
		Preconditions.checkArgument(isNotEmpty(categoryUpdateDTO.getName()), "Category name cannot be empty !");
		Preconditions.checkArgument(notExistsByName(categoryUpdateDTO.getName()), "Category name is already in use !");
	}

	private void AreTheseFieldsValid(CategoryCreateDTO categoryCreateDTO) {
		Preconditions.checkArgument(isNotEmpty(categoryCreateDTO.getName()), "Category name cannot be empty !");
		Preconditions.checkArgument(notExistsByName(categoryCreateDTO.getName()), "Category name is already in use !");
	}
}
