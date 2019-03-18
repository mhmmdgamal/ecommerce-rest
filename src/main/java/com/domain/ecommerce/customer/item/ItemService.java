package com.domain.ecommerce.customer.item;

import com.domain.ecommerce.customer.service.Service;

public interface ItemService extends Service<Item> {

//	Iterable<Item> getActivatedById(long id);

//	Iterable<Item> getAllActivated(String sort);

//	public long getNotActivatedCount();
	
	Iterable<Item> getTag(String tag, String sort);

	Iterable<Item> getAll(long userid, String sort);

	Iterable<Item> getByCategoryId(Long id);

	Iterable<Item> getByUserId(Long id);

}
