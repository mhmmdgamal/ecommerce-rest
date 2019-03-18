package com.domain.ecommerce.customer.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CommentServiceImpl implements CommentService {

	// mySql DB helper
	private CommentRepository commentRepository;

	@Autowired // constructor injection
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void add(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public long addGetId(Comment comment) {
		Comment returnedComment = commentRepository.save(comment);
		return returnedComment.getId();
	}

	@Override
	public void update(Comment comment, long id) {
		commentRepository.findById(id).map(commentFounded -> {
//			commentFounded.setComment(comment.getComment());
			comment.setId(id);
			commentFounded = comment;
			return commentRepository.save(commentFounded);

		}).orElseThrow(() -> new CommentNotFoundException("Could not find user: ", id));
	}

	@Override
	public void update(Comment comment) {
		update(comment, comment.getId());
	}

	@Override
	public void delete(long id) {
		commentRepository.deleteById(id);
	}

	@Override
	public void delete(Comment comment) {
		commentRepository.deleteById(comment.getId());
	}

	@Override
	public void deleteAll() {
		commentRepository.deleteAll();
	}

//	@Override
//	public void active(long id) {
//		Comment comment = getById(id);
////		comment.setActivated(1);
//		update(comment);
//	}

//	@Override
//	public Iterable<Comment> getAll(int activated) {
//		return commentRepository.findByActivated(activated);
//	}

	@Override
	public Iterable<Comment> getAll(String sort) {
		if (sort.equals("DES"))
			return commentRepository.findAllByOrderByIdDesc();
		return commentRepository.findAll();
	}

	@Override
	public Comment getById(long id) {
		return commentRepository.findById(id)
				.orElseThrow(() -> new CommentNotFoundException("Could not find Comment: ", id));
	}

	@Override
	public long getCount() {
		return commentRepository.count();
	}

	@Override
	public Iterable<Comment> getLatest5element() {
		return commentRepository.findTop5ByOrderByIdDesc();
	}

	@Override
	public Iterable<Comment> getByUserId(long userId) {
		return commentRepository.findByUserId(userId);
	}

	@Override
	public Iterable<Comment> getByItemId(long itemId) {
		return commentRepository.findByItemId(itemId);
	}

}
