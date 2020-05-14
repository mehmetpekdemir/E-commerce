package com.mehmetpekdemir.ecommerce.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 13, 2020
 */
public class BarcodeConstraintValidator implements ConstraintValidator<ValidBarcode, String> {

	@Override
	public void initialize(ValidBarcode args0) {
	}

	@Override
	public boolean isValid(String barcode, ConstraintValidatorContext context) {
		return barcode.matches("[0-9]+") && (barcode.length() > 3) && (barcode.length() < 7);
	}

}
