package com.domain.ecommerce.customer.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//	Iterable<Comment> findByActivated(int activated);

	Iterable<Comment> findAllByOrderByIdDesc();

	Iterable<Comment> findTop5ByOrderByIdDesc();

	Iterable<Comment> findByUserId(Long id);

	Iterable<Comment> findByItemId(Long id);

//	Page<Comment> findByUserId(Long id, Pageable pageable);
//	Page<Comment> findByItemId(Long id, Pageable pageable);
}
