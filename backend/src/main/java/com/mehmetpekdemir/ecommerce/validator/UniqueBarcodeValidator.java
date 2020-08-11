package com.mehmetpekdemir.ecommerce.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.ecommerce.repository.ProductRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class UniqueBarcodeValidator implements ConstraintValidator<UniqueBarcode, String> {

	private final ProductRepository productRepository;

	public UniqueBarcodeValidator(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public boolean isValid(String barcode, ConstraintValidatorContext context) {
		return !productRepository.existsByBarcode(barcode);
	}

}
