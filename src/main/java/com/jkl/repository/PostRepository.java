package com.jkl.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jkl.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	

}
