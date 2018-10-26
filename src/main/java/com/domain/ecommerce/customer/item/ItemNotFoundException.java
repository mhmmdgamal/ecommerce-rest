package com.domain.ecommerce.customer.item;

public class ItemNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String message, long id) {
		super(message + id);
	}
}
