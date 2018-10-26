package com.domain.ecommerce.customer.comment;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class CommentNotFoundAdvice {
	@ExceptionHandler(CommentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String commentNotFoundHandler(CommentNotFoundException ex) {
		return ex.getMessage();
	}
}
