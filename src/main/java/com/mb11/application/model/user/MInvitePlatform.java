package com.mb11.application.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MInvitePlatform.
 */
@Entity
@Table(name = "MInvitePlatform")
public class MInvitePlatform {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The name. */
	@Column(nullable = false, unique = true)
	private String name;

	/**
	 * Instantiates a new m invite platform.
	 *
	 * @param name the name
	 */
	public MInvitePlatform(String name) {
		this.name = name;
	}

	/**
	 * Instantiates a new m invite platform.
	 *
	 * @param iD   the i D
	 * @param name the name
	 */
	public MInvitePlatform(Long iD, String name) {
		ID = iD;
		this.name = name;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
