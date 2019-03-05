package com.mb11.application.model.cricapidata;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamPlayers.
 */
@Entity
@Table(name = "TeamPlayers")
public class TeamPlayers {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	@Column(nullable = false)
	private Long playerid;

	/** The firstname. */
	@Column(nullable = false, length = 100)
	private String firstname;

	/** The middlename. */
	@Column(length = 100)
	private String middlename;

	/** The lastname. */
	@Column(nullable = false, length = 100)
	private String lastname;

	/** The m team. */
	@ManyToOne
	@JoinColumn(name = "mteamid", nullable = false)
	private MTeam mTeam;

	@OneToOne(targetEntity = PlayerCredit.class, cascade = CascadeType.ALL)
	private PlayerCredit playerCredit;

	/**
	 * Instantiates a new team players.
	 */
	public TeamPlayers() {

	}

	public TeamPlayers(Long playerid, String firstname, String middlename, String lastname, MTeam mTeam) {
		super();
		this.playerid = playerid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.mTeam = mTeam;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Long playerid) {
		this.playerid = playerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public MTeam getmTeam() {
		return mTeam;
	}

	public void setmTeam(MTeam mTeam) {
		this.mTeam = mTeam;
	}

	public PlayerCredit getPlayerCredit() {
		return playerCredit;
	}

	public void setPlayerCredit(PlayerCredit playerCredit) {
		this.playerCredit = playerCredit;
	}

	@Override
	public String toString() {
		return "TeamPlayers [ID=" + ID + ", playerid=" + playerid + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", mTeam=" + mTeam + "]";
	}

}
