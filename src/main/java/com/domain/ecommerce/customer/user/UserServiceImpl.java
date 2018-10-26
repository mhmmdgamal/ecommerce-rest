package com.domain.ecommerce.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.ecommerce.customer.comment.Comment;
import com.domain.ecommerce.customer.item.Item;

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
	public void update(long id) {
		User user = getById(id);
		update(user, id);

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
		getById(id).setActivated(true);
		update(id);

	}

	// <improve>
	@Override
	public int getLastId() {
		return 0;
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
	public User getLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotActivatedCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<User> getLatestCount(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getAll(String sort) {
		// Not used
		return null;
	}

}
