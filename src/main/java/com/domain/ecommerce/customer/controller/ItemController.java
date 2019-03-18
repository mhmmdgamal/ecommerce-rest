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

import com.domain.ecommerce.customer.item.Item;
import com.domain.ecommerce.customer.item.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	// get all items
	@GetMapping("/list")
	public Iterable<Item> all() {
		return itemService.getAll("DES");
	}

	// add new item
	@PostMapping("/add")
	public void add(@RequestBody Item item) {
		itemService.add(item);
	}

	// add new item
	@PostMapping("/add/getid")
	public long addAndGetId(@RequestBody Item item) {
		return itemService.addGetId(item);
	}

	// get item by id
	@GetMapping("/list/{id}")
	public Item one(@PathVariable long id) {
		return itemService.getById(id);
	}

	// update item
	@PutMapping("/update/{id}")
	public void update(@RequestBody Item item, @PathVariable long id) {
		itemService.update(item, id);
	}

	// delete item by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		itemService.delete(id);
	}
}
