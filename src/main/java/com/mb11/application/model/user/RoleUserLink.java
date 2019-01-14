package com.mb11.application.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleUserLink.
 */
@Entity
@Table(name = "RoleUserLink")
public class RoleUserLink {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The userid. */
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User userid;

	/** The roleid. */
	@ManyToOne
	@JoinColumn(name = "roleid", nullable = false)
	private Roles roleid;

	
	/**
	 * Instantiates a new role user link.
	 *
	 * @param userid the userid
	 * @param roleid the roleid
	 */
	public RoleUserLink(User userid, Roles roleid) {
		this.userid = userid;
		this.roleid = roleid;
	}

	/**
	 * Instantiates a new role user link.
	 *
	 * @param iD     the i D
	 * @param userid the userid
	 * @param roleid the roleid
	 */
	public RoleUserLink(Long id, User userid, Roles roleid) {

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
	public User getUserid() {
		return userid;
	}

	/**
	 * Sets the userid.
	 *
	 * @param userid the new userid
	 */
	public void setUserid(User userid) {
		this.userid = userid;
	}

	/**
	 * Gets the roleid.
	 *
	 * @return the roleid
	 */
	public Roles getRoleid() {
		return roleid;
	}

	/**
	 * Sets the roleid.
	 *
	 * @param roleid the new roleid
	 */
	public void setRoleid(Roles roleid) {
		this.roleid = roleid;
	}

}
