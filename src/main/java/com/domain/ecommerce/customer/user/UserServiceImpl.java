package com.domain.ecommerce.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // dao
public class UserServiceImpl implements UserService {

	@Autowired // instanse of mysql data base helper
	private UserRepository userRepository;

	@Override
	public void add(User user) {
		userRepository.save(user);

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
		user.setActivated(true);
		update(user);
	}

	/**
	 * @param user
	 * @return user with ID after it added to DB
	 */
	@Override
	public User create(User user) {
		return JdbcTemplateImpl.create(user);
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
		return userRepository.findByActivated(false);
	}

//	<improve>
	@Override
	public Iterable<User> getLatestCount(int count) {
		return null;
	}

	@Override
	public Iterable<User> getAll(String sort) {
		return userRepository.findAll();
	}

}
