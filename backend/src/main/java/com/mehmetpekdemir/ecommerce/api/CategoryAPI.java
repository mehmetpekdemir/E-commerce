package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.CategoryViewDTO;
import com.mehmetpekdemir.ecommerce.service.CategoryService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/")
public class CategoryAPI {

	private final CategoryService categoryService;

	public CategoryAPI(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("v1/category")
	public ResponseEntity<List<CategoryViewDTO>> getCategories() {
		final List<CategoryViewDTO> categories = categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("v1/category/{id}")
	public ResponseEntity<CategoryViewDTO> getCategoryById(@PathVariable("id") Long id) {
		final CategoryViewDTO category = categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}

	@PostMapping("v1/category")
	public ResponseEntity<CategoryViewDTO> createCategory(@Valid @RequestBody CategoryCreateDTO categoryCreateDTO) {
		final CategoryViewDTO category = categoryService.createCategory(categoryCreateDTO);
		return ResponseEntity.ok(category);
	}

	@PutMapping("v1/category/{id}")
	public ResponseEntity<CategoryViewDTO> updateCategory(@PathVariable("id") Long id,
			@Valid @RequestBody CategoryUpdateDTO categoryUpdateDTO) {
		final CategoryViewDTO category = categoryService.updateCategory(id, categoryUpdateDTO);
		return ResponseEntity.ok(category);
	}

}
