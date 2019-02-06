package com.mb11.application.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Roles.
 */
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	private String name;

	public Role() {

	}

	public Role(String name) {
		this.name = name;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long id) {
		this.ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}