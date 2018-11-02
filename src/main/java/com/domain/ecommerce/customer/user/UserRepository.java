package com.domain.ecommerce.customer.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.domain.ecommerce.customer.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByNameAndPassword(String name, String password);

	long countByActivated(int activated);

	Iterable<User> findByActivated(int activated);

	Iterable<User> findTop5ByOrderByIdDesc();
}
