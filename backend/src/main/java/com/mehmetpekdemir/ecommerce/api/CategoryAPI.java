package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

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
 * @since May 11, 2020
 */
@RestController
@RequestMapping("api/category")
public class CategoryAPI {

	private final CategoryService categoryService;

	public CategoryAPI(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<CategoryViewDTO>> getCategories() {
		List<CategoryViewDTO> categories = categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryViewDTO> getCategoryById(@PathVariable("id") Long id) {
		CategoryViewDTO category = categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}
	
	@PostMapping("/create")
	public ResponseEntity<CategoryViewDTO> createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
		 CategoryViewDTO category = categoryService.createCategory(categoryCreateDTO);
		 return ResponseEntity.ok(category);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryViewDTO> updateCategory(@PathVariable("id") Long id,@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
		CategoryViewDTO category = categoryService.updateCategory(id,categoryUpdateDTO);
		return ResponseEntity.ok(category);
	}

}
