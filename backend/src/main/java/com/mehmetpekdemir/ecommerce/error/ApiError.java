package com.mehmetpekdemir.ecommerce.error;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ApiError {

	private int status;

	private String message;

	private String path;

	private long timestamp = new Date().getTime();

	private Map<String, String> validationErrors;

	public ApiError(int status, String message, String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}

}
