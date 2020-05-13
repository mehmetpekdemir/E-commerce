package com.mehmetpekdemir.ecommerce.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

/**
 * I have created the CategoryUpdateDTO.java class because,
 * in some scenarios not all the fields should be updated.
 * I can restrict  fields updated.However, 
 * I have updated the entire field except id.
 * @author MEHMET PEKDEMIR
 * @since May 13, 2020
 */
@Getter
@Setter
@ToString
public class CategoryUpdateDTO {
	private String name;
}
