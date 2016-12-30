package com.zheng;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
	private Integer id;
	private String name;

	public User() {
	}
	
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(null == obj) {
			return false;
		}
		
		if(!(obj instanceof User)) {
			return false;
		}
		
		User other = (User) obj;
		return new EqualsBuilder().append(this.id, other.id).append(this.name, other.name).build();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).build();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).build();
	}

}
