package com.mb11.application.model.cricapidata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "seriesteamplayerid", nullable = false)
	private SeriesTeamPlayer vseriesTeamplayerid;

	/**
	 * Instantiates a new player credit.
	 *
	 * @param credit              the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(float credit, SeriesTeamPlayer vseriesTeamplayerid) {
		super();

		this.credit = credit;
		this.vseriesTeamplayerid = vseriesTeamplayerid;
	}

	/**
	 * Instantiates a new player credit.
	 *
	 * @param iD                  the i D
	 * @param credit              the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(Long iD, float credit, SeriesTeamPlayer vseriesTeamplayerid) {
		super();
		ID = iD;
		this.credit = credit;
		this.vseriesTeamplayerid = vseriesTeamplayerid;
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

	/**
	 * Gets the vseries teamplayerid.
	 *
	 * @return the vseries teamplayerid
	 */
	public SeriesTeamPlayer getVseriesTeamplayerid() {
		return vseriesTeamplayerid;
	}

	/**
	 * Sets the vseries teamplayerid.
	 *
	 * @param vseriesTeamplayerid the new vseries teamplayerid
	 */
	public void setVseriesTeamplayerid(SeriesTeamPlayer vseriesTeamplayerid) {
		this.vseriesTeamplayerid = vseriesTeamplayerid;
	}

}
