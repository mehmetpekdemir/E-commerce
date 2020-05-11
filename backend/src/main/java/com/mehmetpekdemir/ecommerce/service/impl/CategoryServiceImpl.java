package com.mehmetpekdemir.ecommerce.service.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
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

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<CategoryViewDTO> getCategories() {
		return categoryRepository.findAll().stream().map(CategoryViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public CategoryViewDTO getCategoryById(Long categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ServiceException(String.format("Category not found with ID #%d", categoryId)));
		return CategoryViewDTO.of(category);
	}

	@Override
	public CategoryViewDTO createCategory(CategoryCreateDTO categoryCreateDTO) {
		Preconditions.checkArgument(isNotEmpty(categoryCreateDTO.getName()), "Category name cannot be empty !");
		Preconditions.checkArgument(notExistsByName(categoryCreateDTO.getName()), "Category name is already in use !");
		Category category = categoryRepository.save(new Category(categoryCreateDTO.getName()));
		return CategoryViewDTO.of(category);
	}

	private boolean notExistsByName(String name) {
		return !categoryRepository.existsByName(name);
	}

}
