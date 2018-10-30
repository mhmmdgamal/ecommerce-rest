package com.domain.ecommerce.customer.service;

public interface Service<E> {

	void add(E e);

	void update(E e);

	void update(E e, long id);

	void delete(long id);

	void delete(E e);

	void deleteAll();

	void active(long id);

	E create(E e);

	Iterable<E> getAll(String sore);

	E getById(long id);

	long getCount();

	Iterable<E> getLatestCount(int coune);
}
