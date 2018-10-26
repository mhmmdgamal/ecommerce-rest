package com.domain.ecommerce.customer.service;

public interface Service<E> {

	void add(E e);

	void update(E e);

	void update(long id);

	void update(E e, long id);

	void delete(long id);

	void delete(E e);

	void deleteAll();

	void active(long id);

	int getLastId();

	Iterable<E> getAll(String sore);

	E getById(long id);

	int getCount();

	Iterable<E> getLatestCount(int coune);
}
