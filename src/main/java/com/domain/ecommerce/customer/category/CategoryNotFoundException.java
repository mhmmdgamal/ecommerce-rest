package com.domain.ecommerce.customer.category;

public class CategoryNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(String message, long id) {
		super(message + id);
	}
}
