package com.mehmetpekdemir.ecommerce.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class ProductUpdateDTO {

	@NotNull
	private String name;

	@NotNull
	@Positive
	private Double price;

	@NotNull
	private String description;

	@NotNull
	@Positive
	private Long categoryId;
	
}
