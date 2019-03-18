package com.domain.ecommerce.customer.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.ecommerce.customer.comment.Comment;
import com.domain.ecommerce.customer.user.UserNotFoundException;

@Service
public class ItemServiceImpl implements ItemService {

	// mySql DB helper
	private ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void add(Item item) {
		itemRepository.save(item);
	}

	/**
	 * @param user
	 * @docRoot add user to DB
	 * @return user with ID after it added to DB
	 */
	@Override
	public long addGetId(Item item) {
		Item returnedItem = itemRepository.save(item);
		return returnedItem.getId();
	}

	@Override
	public void update(Item item, long id) {
		itemRepository.findById(id).map(itemFounded -> {
			item.setId(id);
			itemFounded = item;
			return itemRepository.save(itemFounded);
		}).orElseThrow(() -> new ItemNotFoundException("Could not find user: ", id));

	}

	@Override
	public void update(Item item) {
		update(item, item.getId());
	}

	@Override
	public void delete(long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public void delete(Item item) {
		itemRepository.deleteById(item.getId());
	}

	@Override
	public void deleteAll() {
		itemRepository.deleteAll();
	}

//	@Override
//	public void active(long id) {
//		Item item = getById(id);
////		item.setActivated(1);
//		update(item);
//	}

	@Override
	public Iterable<Item> getAll(String sort) {
		return itemRepository.findAll();
	}

	@Override
	public Item getById(long id) {
		return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Could not find item : ", id));
	}

	@Override
	public long getCount() {
		return itemRepository.count();
	}

	@Override
	public Iterable<Item> getLatest5element() {
		return itemRepository.findTop5ByOrderByIdDesc();
	}

//	@Override
//	public Iterable<Item> getActivatedById(long id) {
//		return itemRepository.findByIdAndActivated(id, 1);
//	}

//	@Override
//	public Iterable<Item> getAll(int activated) {
//		return itemRepository.findByActivated(activated);
//	}

//	public Iterable<Item> getAll(int activated, String sort) {
//		if (sort.equals("DES"))
//			return itemRepository.findByActivatedOrderByIdDesc(1);
//		return itemRepository.findByActivated(1);
//	}

	@Override
	public Iterable<Item> getTag(String tag, String sort) {
		if (sort.equals("DES"))
			return itemRepository.findByTagOrderByIdDesc(tag);
		return itemRepository.findByTag(tag);
	}

	@Override
	public Iterable<Item> getAll(long userid, String sort) {
		return itemRepository.findAll();
	}

//	@Override
//	public Iterable<Item> getAllActivated(String sort) {
//		if (sort.equals("DES"))
//			return itemRepository.findByActivatedOrderByIdDesc(1);
//		return itemRepository.findByActivated(1);
//	}

//	@Override
//	public long getNotActivatedCount() {
//		return itemRepository.countByActivated(0);
//	}

	@Override
	public Iterable<Item> getByCategoryId(Long id) {
		return itemRepository.findByCategoryId(id);
	}

	@Override
	public Iterable<Item> getByUserId(Long id) {
		return itemRepository.findByUserId(id);
	}

}
