package com.mehmetpekdemir.ecommerce.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.mehmetpekdemir.ecommerce.validator.UniqueBarcode;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class ProductCreateDTO {

	@NotNull
	private String name;

	@NotNull
	@Positive
	@Size(min = 3, max = 7)
	@Pattern(regexp = "[0-9]+")
	@UniqueBarcode
	private String barcode;

	@NotNull
	@Positive
	private Double price;

	@NotNull
	private String description;

	@NotNull
	@Positive
	private Long categoryId;

}
