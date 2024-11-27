package com.jkl.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

    @Id
	@Column(name = "id",nullable = false)
	private long Id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;


	@Column(name = "description", length = 5000, nullable = false)
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
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
private Set<Comment>comments;
}
