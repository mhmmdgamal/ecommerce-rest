package com.domain.ecommerce.customer.user;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	UserNotFoundException(int id) {
		super("Could not find user " + id); 
	} 
}
