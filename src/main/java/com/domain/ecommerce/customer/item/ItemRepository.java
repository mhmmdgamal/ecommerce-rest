package com.domain.ecommerce.customer.item;

import org.springframework.data.repository.CrudRepository;

import com.domain.ecommerce.customer.user.User;

public interface ItemRepository extends CrudRepository<User, Long> {
}
