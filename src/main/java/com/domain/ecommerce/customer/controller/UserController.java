package com.domain.ecommerce.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.domain.ecommerce.customer.user.User;
import com.domain.ecommerce.customer.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// get all users
	@GetMapping("/list")
	public Iterable<User> all() {
		return userService.getAll(true);
	}

	// add new user
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userService.add(user);
	}

	// get user by id
	@GetMapping("/list/{id}")
	public User one(@PathVariable long id) {
		return userService.getById(id);
	}

	// update user
	@PutMapping("/update/{id}")
	public void update(@RequestBody User user, @PathVariable long id) {
		userService.update(user, id);
	}

	// delete user by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}
}