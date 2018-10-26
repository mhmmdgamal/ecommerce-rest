package com.ecommerce.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.dao.user.User;
import com.ecommerce.dao.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// get all users
	@GetMapping("/list")
	public Iterable<User> all() {
		return userService.findAll();
	}

	// add new user
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userService.add(user);
	}

	// get user by id
	@GetMapping("/list/{id}")
	public User one(@PathVariable int id) {
		return userService.findOne(id);
	}

	// update user
	@PutMapping("/update/{id}")
	public void update(@RequestBody User user, @PathVariable int id) {
		userService.update(user, id);
	}

	// delete user by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		userService.delete(id);
	}
}