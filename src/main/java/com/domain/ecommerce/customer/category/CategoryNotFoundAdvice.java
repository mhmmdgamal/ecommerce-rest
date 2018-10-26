package com.domain.ecommerce.customer.category;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class CategoryNotFoundAdvice {
	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String categoryNotFoundHandler(CategoryNotFoundException ex) {
		return ex.getMessage();
	}
}
