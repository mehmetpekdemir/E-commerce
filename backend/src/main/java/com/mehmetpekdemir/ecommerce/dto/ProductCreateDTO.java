package com.mehmetpekdemir.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateDTO {
	
	private String name;
	private String barcode;
	private Double price;
	private String description;
	private Long categoryId;

}
