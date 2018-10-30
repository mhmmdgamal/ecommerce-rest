package com.domain.ecommerce.customer.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	Page<Comment> findByUserId(Long id, Pageable pageable);
	Page<Comment> findByItemId(Long id, Pageable pageable);
}
