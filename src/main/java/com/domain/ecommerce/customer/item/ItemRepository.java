package com.domain.ecommerce.customer.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	Page<Item> findByUserId(Long id, Pageable pageable);

	Page<Item> findByCategory(Long id, Pageable pageable);

}
