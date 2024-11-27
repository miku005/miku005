package com.jkl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jkl.entity.Comment;
import com.jkl.entity.Post;
import com.jkl.repository.CommentRepository;
import com.jkl.repository.PostRepository;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
	private PostRepository postRepository;
	private CommentRepository commentRepository;
	public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
		super();
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}
@PostMapping
	public String createComment(
			@RequestBody Comment comment,
			@RequestParam long postId
			
			) {
	  Post post = postRepository.findById(postId).get();
	  comment.setPost(post);
	  commentRepository.save(comment);
	return "comment created successfully";
	
}
}
