package com.mb11.application.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInvitePlatformLink.
 */
@Entity
@Table(name = "UserInvitePlatformLink")
public class UserInvitePlatformLink {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The minviteplatformid. */
	@ManyToOne
	@JoinColumn(name = "minviteplatformid", nullable = false)
	private MInvitePlatform minviteplatformid;

	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User userid;

	/**
	 * Instantiates a new user invite platform link.
	 *
	 * @param minviteplatformid the minviteplatformid
	 * @param userid            the userid
	 */
	public UserInvitePlatformLink(MInvitePlatform minviteplatformid, User userid) {
		this.minviteplatformid = minviteplatformid;
		this.userid = userid;
	}

	/**
	 * Instantiates a new user invite platform link.
	 *
	 * @param iD                the i D
	 * @param minviteplatformid the minviteplatformid
	 * @param userid            the userid
	 */
	public UserInvitePlatformLink(Long id, MInvitePlatform minviteplatformid, User userid) {
		ID = id;
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
	public MInvitePlatform getMinviteplatformid() {
		return minviteplatformid;
	}

	/**
	 * Sets the minviteplatformid.
	 *
	 * @param minviteplatformid the new minviteplatformid
	 */
	public void setMinviteplatformid(MInvitePlatform minviteplatformid) {
		this.minviteplatformid = minviteplatformid;
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

}
