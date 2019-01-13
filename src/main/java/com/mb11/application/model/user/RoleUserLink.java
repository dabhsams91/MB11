package com.mb11.application.model.user;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class RoleUserLink.
 */
@Entity
@Table(name="RoleUserLink")
public class RoleUserLink {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The userid. */
	@Column(nullable=false)
	@OneToMany
	private List<User> userid=new ArrayList<>();
	
	/** The roleid. */
	@Column(nullable=false)
	@OneToMany
	private List<Roles> roleid=new ArrayList<>();
	 
	/**
	 * Instantiates a new role user link.
	 */
	public RoleUserLink(){
		 
	 }
	
	/**
	 * Instantiates a new role user link.
	 *
	 * @param userid the userid
	 * @param roleid the roleid
	 */
	public RoleUserLink(List<User> userid, List<Roles> roleid) {
		super();
		
		this.userid = userid;
		this.roleid = roleid;
	}

	/**
	 * Instantiates a new role user link.
	 *
	 * @param iD the i D
	 * @param userid the userid
	 * @param roleid the roleid
	 */
	public RoleUserLink(Long iD, List<User> userid, List<Roles> roleid) {
		super();
		ID = iD;
		this.userid = userid;
		this.roleid = roleid;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * Gets the userid.
	 *
	 * @return the userid
	 */
	public List<User> getUserid() {
		return userid;
	}

	/**
	 * Sets the userid.
	 *
	 * @param userid the new userid
	 */
	public void setUserid(List<User> userid) {
		this.userid = userid;
	}

	/**
	 * Gets the roleid.
	 *
	 * @return the roleid
	 */
	public List<Roles> getRoleid() {
		return roleid;
	}

	/**
	 * Sets the roleid.
	 *
	 * @param roleid the new roleid
	 */
	public void setRoleid(List<Roles> roleid) {
		this.roleid = roleid;
	}

	
	
	
	

}
