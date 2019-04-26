package com.dcl.entity;

import java.io.Serializable;

public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long parentId;
	private String parentIds;
	private Boolean available=false;
}
