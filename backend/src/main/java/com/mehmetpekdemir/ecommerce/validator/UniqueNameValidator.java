package com.mehmetpekdemir.ecommerce.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.ecommerce.repository.CategoryRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

	private final CategoryRepository categoryRepository;

	public UniqueNameValidator(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return !categoryRepository.existsByName(name);
	}

}
