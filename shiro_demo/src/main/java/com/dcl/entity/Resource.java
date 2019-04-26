package com.dcl.entity;

import java.io.Serializable;

public class Resource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Byte type;
	private String url;
	private Long parentId;
	private String parentIds;
	private String permission;
	private Boolean available=false;
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
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", parentId=" + parentId
				+ ", parentIds=" + parentIds + ", permission=" + permission + ", available=" + available + "]";
	}
	
}
