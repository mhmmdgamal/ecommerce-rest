package com.domain.ecommerce.customer.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Iterable<Category> findByActivated(int activated);

	Iterable<Category> findAllByOrderByIdDesc();

	Iterable<Category> findTop5ByOrderByIdDesc();

	Iterable<Category> findByParent(int parent);

	Iterable<Category> findByParentOrderByIdDesc(int parent);
}
