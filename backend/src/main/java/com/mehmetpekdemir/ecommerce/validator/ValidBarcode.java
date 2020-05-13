package com.mehmetpekdemir.ecommerce.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 13, 2020
 */
@Documented
@Constraint(validatedBy = BarcodeConstraintValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBarcode {
	
	String message() default "Invalid Barcode";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
