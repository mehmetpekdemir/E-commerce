package com.mehmetpekdemir.ecommerce.exception;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

}
