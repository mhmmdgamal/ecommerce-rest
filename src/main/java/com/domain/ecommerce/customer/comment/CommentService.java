package com.domain.ecommerce.customer.comment;

import com.domain.ecommerce.customer.service.Service;

public interface CommentService extends Service<Comment> {

	Iterable<Comment> getByUserId(long userId);

	Iterable<Comment> getByItemId(long itemId);
}