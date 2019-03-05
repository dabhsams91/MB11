package com.mb11.application.model.cricapidata;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCredit.
 */
@Entity
@Table(name = "PlayerCredit")
public class PlayerCredit {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The credit. */
	private float credit;

	/** The vseries teamplayerid. */
	/** The sid. */
	@OneToOne(targetEntity = TeamPlayers.class, cascade = CascadeType.ALL)
	private TeamPlayers teamPlayers;

	/**
	 * Instantiates a new player credit.
	 *
	 * @param credit              the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(float credit, TeamPlayers teamPlayers) {
		super();

		this.credit = credit;
		this.teamPlayers = teamPlayers;
	}

	/**
	 * Instantiates a new player credit.
	 *
	 * @param iD                  the i D
	 * @param credit              the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(Long iD, float credit, TeamPlayers teamPlayers) {
		super();
		ID = iD;
		this.credit = credit;
		this.teamPlayers = teamPlayers;
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
	 * Gets the credit.
	 *
	 * @return the credit
	 */
	public float getCredit() {
		return credit;
	}

	/**
	 * Sets the credit.
	 *
	 * @param credit the new credit
	 */
	public void setCredit(float credit) {
		this.credit = credit;
	}

	public TeamPlayers getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(TeamPlayers teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

}
