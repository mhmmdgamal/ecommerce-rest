package com.domain.ecommerce.customer.service;

public interface Service<E> {

	void add(E e);

	/**
	 * @param user
	 * @docRoot add user to DB
	 * @return user with ID after it added to DB
	 */
	long addGetId(E e);

	void update(E e, long id);

	void update(E e);

	void delete(long id);

	void delete(E e);

	void deleteAll();

	void active(long id);

	Iterable<E> getAll(String sore);

	E getById(long id);

	long getCount();

	Iterable<E> getLatest5element();
}
