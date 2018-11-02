package com.domain.ecommerce.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // uses constructor injection to obtain a required userRepository bean
public class UserServiceImpl implements UserService {

	// mySql DB helper
	private UserRepository userRepository;

	@Autowired // constructor injection
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	/**
	 * @param user
	 * @docRoot add user to DB
	 * @return ID after added user to DB
	 */
	@Override
	public long addGetId(User user) {
		User returnedUser = userRepository.save(user);
		return returnedUser.getId();
	}

	@Override
	public void update(User user, long id) {

		userRepository.findById(id).map(userFounded -> {
			userFounded.setName(user.getName());
			userFounded.setEmail(user.getEmail());
//			userFounded=user;
			return userRepository.save(userFounded);

		}).orElseThrow(() -> new UserNotFoundException("Could not find user: ", id));
	}

	@Override
	public void update(User user) {
		update(user, user.getId());
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		userRepository.deleteById(user.getId());
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void active(long id) {
		User user = getById(id);
		user.setActivated(1);
		update(user);
	}

	@Override
	public Iterable<User> getAll(int activated) {
		return userRepository.findByActivated(activated);
	}

	@Override
	public User getById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Could not find user: ", id));
	}

	@Override
	public long getCount() {
		return userRepository.count();
	}

	@Override
	public Iterable<User> getLatest5element() {
		return userRepository.findTop5ByOrderByIdDesc();
	}

	@Override
	public User getLogin(String name, String password) {
		userRepository.findByNameAndPassword(name, password);
		return null;
	}

	@Override
	public long getNotActivatedCount() {
		return userRepository.countByActivated(0);
	}

	@Override
	public Iterable<User> getAll(String sort) {
		return userRepository.findAll();
	}

}
