package com.jkl.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkl.entity.Post;
import com.jkl.repository.CommentRepository;
import com.jkl.repository.PostRepository;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
	private PostRepository postRepository;
	private CommentRepository commentRepository;
	public PostController(PostRepository postRepository, CommentRepository commentRepository) {
		super();
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}
	@PostMapping
	public String createPost(
			
			@RequestBody Post post
			) {
	postRepository.save(post);
	return "saved";
}
	@DeleteMapping
	public void deletePost() {
		postRepository.deleteById(1L);;
	}
}
