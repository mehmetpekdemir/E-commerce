package com.mehmetpekdemir.ecommerce.dto;

import java.io.Serializable;

import com.mehmetpekdemir.ecommerce.entity.Category;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */

@Getter
public class CategoryViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Long id;
	private final String name;

	private CategoryViewDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static CategoryViewDTO of(Category category) {
		return new CategoryViewDTO(
				category.getId(), 
				category.getName()
		);
	}

}
