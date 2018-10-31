package com.domain.ecommerce.customer.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepository extends CrudRepository<Item, Long> {

	Item findByUserId(Long id);

	Item findByCategoryId(Long id);

//	Page<Item> findByUserId(Long id, Pageable pageable);
//
//	Page<Item> findByCategoryId(Long id, Pageable pageable);

}
