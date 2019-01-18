package com.mb11.application.model.user;

import java.util.Collection;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privilege")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	private String name;

	/*@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
*/
	public Privilege(String name) {
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

	/*public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
*/
}
