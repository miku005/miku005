package com.jkl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	 @Id
		@Column(name = "id",nullable = false)
		private long Id;

		@Column(name = "name", nullable = false)
		private String name;


		@Column(name = "description")
		private String description;

		public long getId() {
			return Id;
		}


		public void setId(long id) {
			Id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
		@ManyToOne
		@JoinColumn(name = "post_id")
		private Post post;

		public void setPost(Post post) {
		this.post=post;
			
		}

		

		
}
