package com.domain.ecommerce.customer.item;

import com.domain.ecommerce.customer.comment.Comment;
import com.domain.ecommerce.customer.service.Service;

public interface ItemService extends Service<Item> {

	Iterable<Comment> getComments(long id, String sort);

	Iterable<Item> getApprovedById(long id);

	Iterable<Item> getAllApproved(String sort);

	Iterable<Item> getTag(String tag, String sort);

	boolean approve(long id);

	Iterable<Item> getAll(long userid, String sort);

}
