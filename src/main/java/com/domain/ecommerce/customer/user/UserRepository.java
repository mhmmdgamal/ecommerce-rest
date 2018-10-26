package com.domain.ecommerce.customer.user;

import org.springframework.data.repository.CrudRepository;

import com.domain.ecommerce.customer.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
