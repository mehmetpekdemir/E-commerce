package com.mehmetpekdemir.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.mehmetpekdemir.ecommerce.validator.UniqueName;

import lombok.Data;

/**
 * <p>
 * I have created the CategoryUpdateDTO.java class because, in some scenarios
 * not all the fields should be updated. I can restrict fields updated.However,
 * I have updated the entire field except id.
 * </p>
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class CategoryUpdateDTO {

	@NotNull
	@UniqueName
	private String name;

}
