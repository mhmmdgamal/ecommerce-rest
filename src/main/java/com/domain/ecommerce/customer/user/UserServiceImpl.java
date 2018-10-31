package com.domain.ecommerce.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // dao
public class UserServiceImpl extends UserJdbcTemplateImpl implements UserService {

	@Autowired //mySql DB helper
	private UserRepository userRepository;

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
		return addAndGetId(user);
	}

	@Override
	public void update(User user, long id) {
		userRepository.findById(id).map(userFounded -> {
			userFounded.setName(user.getName());
			userFounded.setEmail(user.getEmail());
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
	public Iterable<User> getAll(boolean pendings) {
		return userRepository.findAll();
	}

	@Override
	public User getById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Could not find user: ", id));

	}

	@Override
	public User getLogin(String name, String password) {
		userRepository.findByNameAndPassword(name, password);
		return null;
	}

	@Override
	public long getCount() {
		return userRepository.count();
	}

	@Override
	public long getNotActivatedCount() {
		return userRepository.findByActivated(0);
	}

	@Override
	public Iterable<User> getLatest5element() {
		return userRepository.findTop5ByOrderByIdDesc();
	}

	@Override
	public Iterable<User> getAll(String sort) {
		return userRepository.findAll();
	}

}
