package com.domain.ecommerce.customer.category;

import com.domain.ecommerce.customer.item.Item;
import com.domain.ecommerce.customer.service.Service;

public interface CategoryService extends Service<Category> {

	Iterable<Item> getItems(long id, String sort);

	Iterable<Category> getAllSup(String sort);

	Iterable<Category> getAllSub(String sort);

}
