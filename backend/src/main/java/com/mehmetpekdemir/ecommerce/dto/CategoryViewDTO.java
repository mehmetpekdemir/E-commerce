package com.mehmetpekdemir.ecommerce.dto;

import com.mehmetpekdemir.ecommerce.entity.Category;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public final class CategoryViewDTO {

	private final Long id;
	private final String name;

	private CategoryViewDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static CategoryViewDTO of(Category category) {
		return new CategoryViewDTO(category.getId(), category.getName());
	}

}
