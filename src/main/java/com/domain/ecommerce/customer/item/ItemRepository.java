package com.domain.ecommerce.customer.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Iterable<Item> findTop5ByOrderByIdDesc();

//	Iterable<Item> findByActivated(int activated);

//	Iterable<Item> findByActivatedOrderByIdDesc(int activated);

	Iterable<Item> findByTag(String tag);

	Iterable<Item> findByTagOrderByIdDesc(String tag);

//	Iterable<Item> findByIdAndActivated(long id, int activated);

//	long countByActivated(int activated);
	
	Iterable<Item> findByUserId(Long id);

	Iterable<Item> findByCategoryId(Long id);

//	Page<Item> findByUserId(Long id, Pageable pageable);
//
//	Page<Item> findByCategoryId(Long id, Pageable pageable);

}
