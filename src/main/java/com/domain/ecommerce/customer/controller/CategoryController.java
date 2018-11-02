package com.domain.ecommerce.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ecommerce.customer.category.Category;
import com.domain.ecommerce.customer.category.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// get all categories
	@GetMapping("/list")
	public Iterable<Category> all() {
		return categoryService.getAll(1);
	}

	// add new category
	@PostMapping("/add")
	public void add(@RequestBody Category category) {
		categoryService.add(category);
	}

	// add new category
	@PostMapping("/add/getid")
	public long addAndGetId(@RequestBody Category category) {
		return categoryService.addGetId(category);
	}

	// get category by id
	@GetMapping("/list/{id}")
	public Category one(@PathVariable long id) {
		return categoryService.getById(id);
	}

	// update category
	@PutMapping("/update/{id}")
	public void update(@RequestBody Category category, @PathVariable long id) {
		categoryService.update(category, id);
	}

	// delete category by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		categoryService.delete(id);
	}


}
