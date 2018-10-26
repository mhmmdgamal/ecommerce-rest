package com.domain.ecommerce.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//dao
public class UserServiceImpl implements UserService {

    @Autowired//instanse of mysql data base helper
    private UserRepository userRepository; 

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public User findOne(int id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user, int id) {
		userRepository.findById(id).map(userFounded -> {
			userFounded.setName(user.getName());
			userFounded.setEmail(user.getEmail());
			return userRepository.save(userFounded);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}
}
