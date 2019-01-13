package com.mb11.application.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInvitePlatformLink.
 */
@Entity
@Table(name="UserInvitePlatformLink")
public class UserInvitePlatformLink {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The minviteplatformid. */
	@Column(nullable=false)
	@ManyToMany
	private List<MInvitePlatform> minviteplatformid=new ArrayList<>();
	
	/** The userid. */
	@Column(nullable=false)
	@OneToMany
	private List<User> userid=new ArrayList<>();
	
	/**
	 * Instantiates a new user invite platform link.
	 */
	public UserInvitePlatformLink()
	{
		
	}
	
	/**
	 * Instantiates a new user invite platform link.
	 *
	 * @param minviteplatformid the minviteplatformid
	 * @param userid the userid
	 */
	public UserInvitePlatformLink(List<MInvitePlatform> minviteplatformid, List<User> userid) {
		super();
		
		this.minviteplatformid = minviteplatformid;
		this.userid = userid;
	}

	/**
	 * Instantiates a new user invite platform link.
	 *
	 * @param iD the i D
	 * @param minviteplatformid the minviteplatformid
	 * @param userid the userid
	 */
	public UserInvitePlatformLink(Long iD, List<MInvitePlatform> minviteplatformid, List<User> userid) {
		super();
		ID = iD;
		this.minviteplatformid = minviteplatformid;
		this.userid = userid;
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
	 * Gets the minviteplatformid.
	 *
	 * @return the minviteplatformid
	 */
	public List<MInvitePlatform> getMinviteplatformid() {
		return minviteplatformid;
	}

	/**
	 * Sets the minviteplatformid.
	 *
	 * @param minviteplatformid the new minviteplatformid
	 */
	public void setMinviteplatformid(List<MInvitePlatform> minviteplatformid) {
		this.minviteplatformid = minviteplatformid;
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

	
	
}
