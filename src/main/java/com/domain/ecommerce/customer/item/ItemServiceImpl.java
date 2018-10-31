package com.domain.ecommerce.customer.item;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.ecommerce.customer.comment.Comment;

public class ItemServiceImpl implements ItemService {

	@Autowired // mySql DB helper
	private ItemRepository userRepository;

	@Override
	public void add(Item item) {
		userRepository.save(item);
	}

	/**
	 * @param user
	 * @docRoot add user to DB
	 * @return user with ID after it added to DB
	 */
	@Override
	public long addGetId(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Item item, long id) {
		userRepository.findById(id).map(userFounded -> {
			userFounded.setName(item.getName());
			return userRepository.save(userFounded);
		}).orElseThrow(() -> new ItemNotFoundException("Could not find user: ", id));

	}

	@Override
	public void update(Item item) {
		update(item, item.getId());
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(Item item) {
		userRepository.deleteById(item.getId());
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void active(long id) {
		Item item = getById(id);
		item.setActivated(1);
		update(item);
	}

	@Override
	public Iterable<Item> getAll(String sore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Item> getLatest5element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Comment> getComments(long id, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Item> getApprovedById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Item> getAllApproved(String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Item> getTag(String tag, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approve(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Item> getAll(long userid, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

}
