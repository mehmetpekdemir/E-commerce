package com.mehmetpekdemir.ecommerce.error;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

}
