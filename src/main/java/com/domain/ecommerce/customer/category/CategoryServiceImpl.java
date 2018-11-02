package com.domain.ecommerce.customer.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.ecommerce.customer.item.Item;
import com.domain.ecommerce.customer.user.UserNotFoundException;
import com.domain.ecommerce.customer.user.UserRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	// mySql DB helper
	private CategoryRepository categoryRepository;

	@Autowired // constructor injection
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void add(Category e) {
		categoryRepository.save(e);
	}

	@Override
	public long addGetId(Category e) {
		Category returnedCategory = categoryRepository.save(e);
		return returnedCategory.getId();
	}

	@Override
	public void update(Category category, long id) {
		categoryRepository.findById(id).map(categoryFounded -> {
//			userFounded.setName(user.getName());
			categoryFounded = category;
			return categoryRepository.save(categoryFounded);

		}).orElseThrow(() -> new CategoryNotFoundException("Could not find category : ", id));
	}

	@Override
	public void update(Category category) {
		update(category, category.getId());
	}

	@Override
	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category e) {
		categoryRepository.deleteById(e.getId());
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	@Override
	public void active(long id) {
		Category category = getById(id);
		category.setActivated(1);
		update(category);
	}

	@Override
	public Iterable<Category> getAll(int activated) {
		return categoryRepository.findByActivated(activated);
	}

	@Override
	public Iterable<Category> getAll(String sort) {
		if (sort.equals("DES"))
			return categoryRepository.findAllByOrderByIdDesc();
		return categoryRepository.findAll();
	}

	@Override
	public Category getById(long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Could not find Category : ", id));
	}

	@Override
	public long getCount() {
		return categoryRepository.count();
	}

	@Override
	public Iterable<Category> getLatest5element() {
		return categoryRepository.findTop5ByOrderByIdDesc();
	}

	@Override
	public Iterable<Category> getAllSup(String sort) {
		if (sort.equals("DES"))
			return categoryRepository.findByParentOrderByIdDesc(0);
//		return categoryRepository.findAllByOrderByParentDesc(0);
		return categoryRepository.findByParent(0);
	}

	@Override
	public Iterable<Category> getAllSub(String sort) {
		if (sort.equals("DES"))
			return categoryRepository.findByParentOrderByIdDesc(0);
//		return categoryRepository.findAllByOrderByParentDesc(0);
		return categoryRepository.findByParent(1);
	}

}
