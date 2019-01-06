package com.mb11.application.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinviteplatformlink")
public class UserInvitePlatformLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private User userid;

	@Column(nullable = false)
	private MInvitePlatformLink mInviteplatformlink;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public MInvitePlatformLink getmInviteplatformlink() {
		return mInviteplatformlink;
	}

	public void setmInviteplatformlink(MInvitePlatformLink mInviteplatformlink) {
		this.mInviteplatformlink = mInviteplatformlink;
	}

}
