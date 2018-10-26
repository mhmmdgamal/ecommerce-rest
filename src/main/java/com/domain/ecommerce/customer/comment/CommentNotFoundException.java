package com.domain.ecommerce.customer.comment;

public class CommentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CommentNotFoundException(String message, long id) {
		super(message + id);
	}
}
