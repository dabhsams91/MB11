package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Long player_id;

	/** The firstname. */
	@Column(nullable = false, length = 30)
	private String firstname;

	/** The middlename. */
	@Column(length = 30)
	private String middlename;

	/** The lastname. */
	@Column(nullable = false, length = 30)
	private String lastname;

	/** The m team. */
	@ManyToOne
	@JoinColumn(name = "mteamid", nullable = false)
	private MTeam mTeam;

	/**
	 * Instantiates a new team players.
	 */
	public TeamPlayers() {

	}

	public TeamPlayers(Long player_id, String firstname, String middlename, String lastname, MTeam mTeam) {
		super();
		this.player_id = player_id;
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

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
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

	@Override
	public String toString() {
		return "TeamPlayers [ID=" + ID + ", player_id=" + player_id + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", mTeam=" + mTeam + "]";
	}


	
	
}
