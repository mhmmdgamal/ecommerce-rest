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

import com.domain.ecommerce.customer.comment.Comment;
import com.domain.ecommerce.customer.comment.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	// get all comments
	@GetMapping("/list")
	public Iterable<Comment> all() {
		return commentService.getAll(1);
	}

	// add new Comment
	@PostMapping("/add")
	public void add(@RequestBody Comment comment) {
		commentService.add(comment);
	}

	// add new comment
	@PostMapping("/add/getid")
	public long addAndGetId(@RequestBody Comment comment) {
		return commentService.addGetId(comment);
	}

	// get comment by id
	@GetMapping("/list/{id}")
	public Comment one(@PathVariable long id) {
		return commentService.getById(id);
	}

	// update comment
	@PutMapping("/update/{id}")
	public void update(@RequestBody Comment comment, @PathVariable long id) {
		commentService.update(comment, id);
	}

	// delete comment by id
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		commentService.delete(id);
	}

}
