package com.mehmetpekdemir.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * I have created the ProductUpdateDTO.java class because,
 * in some scenarios not all the fields should be updated.
 * 
 * @author MEHMET PEKDEMIR
 * @since May 13, 2020
 */
@Getter
@Setter
@ToString
public class ProductUpdateDTO {
	private String name;
	private Double price;
	private String description;
	private Long categoryId;
}
