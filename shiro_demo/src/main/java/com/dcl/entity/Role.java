package com.dcl.entity;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String resourceIds;
	private Boolean available = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", resourceIds=" + resourceIds
				+ ", available=" + available + "]";
	}
	
}
