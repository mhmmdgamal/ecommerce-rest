package com.example.user;

public interface UserService {

	Iterable<User> findAll();

	void add(User user);
	
	void update(User user, int id);

	User findOne(int id);

	void delete(int id);
}