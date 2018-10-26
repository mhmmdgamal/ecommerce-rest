package com.domain.ecommerce.customer.user;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message, long id) {
		super(message + id);
	}
}
