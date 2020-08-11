package com.mehmetpekdemir.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.mehmetpekdemir.ecommerce.validator.UniqueName;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class CategoryCreateDTO {
	
	@NotNull
	@UniqueName
	private String name;
	
}
