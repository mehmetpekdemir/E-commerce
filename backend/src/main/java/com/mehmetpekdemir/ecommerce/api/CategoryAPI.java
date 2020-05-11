package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ecommerce.dto.CategoryCreateDTO;
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
	public List<CategoryViewDTO> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/get/{id}")
	public CategoryViewDTO getCategories(@PathVariable("id") Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/create")
	public CategoryViewDTO createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
		return categoryService.createCategory(categoryCreateDTO);
	}
	
}
