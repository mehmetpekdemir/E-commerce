package com.mehmetpekdemir.ecommerce.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
public class ErrorHandler implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public ErrorHandler(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public ApiError handleError(WebRequest webRequest) {
		final Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, true);

		final String message = (String) attributes.get("message");
		final String path = (String) attributes.get("path");
		final int status = (Integer) attributes.get("status");

		ApiError error = new ApiError(status, message, path);

		if (attributes.containsKey("errors")) {

			@SuppressWarnings("unchecked")
			final List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");
			Map<String, String> validationErrors = new HashMap<String, String>();
			for (FieldError fieldError : fieldErrors) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}

			error.setValidationErrors(validationErrors);
		}

		return error;
	}

}
