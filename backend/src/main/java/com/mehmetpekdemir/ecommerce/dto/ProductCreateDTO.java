package com.mehmetpekdemir.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */

@Getter
@Setter
@ToString
public class ProductCreateDTO {
	private String name;
	private String barcode;
	private Double price;
	private String description;
	private Long categoryId;
}
