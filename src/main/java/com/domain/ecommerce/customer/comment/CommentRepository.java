package com.domain.ecommerce.customer.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	Comment findByUserId(Long id);

	Comment findByItemId(Long id);
	
//	Page<Comment> findByUserId(Long id, Pageable pageable);
//	Page<Comment> findByItemId(Long id, Pageable pageable);
}
