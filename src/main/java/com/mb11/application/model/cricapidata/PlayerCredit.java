package com.mb11.application.model.cricapidata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCredit.
 */
@Entity
@Table(name="PlayerCredit")
public class PlayerCredit {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The credit. */
	private float credit;
	
	/** The vseries teamplayerid. */
	@OneToMany
	private List<SeriesTeamPlayer> vseriesTeamplayerid=new ArrayList<>();
	
	/**
	 * Instantiates a new player credit.
	 */
	public PlayerCredit()
	{
		
	}
	
	/**
	 * Instantiates a new player credit.
	 *
	 * @param credit the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(float credit, List<SeriesTeamPlayer> vseriesTeamplayerid) {
		super();
		
		this.credit = credit;
		this.vseriesTeamplayerid = vseriesTeamplayerid;
	}

	/**
	 * Instantiates a new player credit.
	 *
	 * @param iD the i D
	 * @param credit the credit
	 * @param vseriesTeamplayerid the vseries teamplayerid
	 */
	public PlayerCredit(Long iD, float credit, List<SeriesTeamPlayer> vseriesTeamplayerid) {
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
	public List<SeriesTeamPlayer> getVseriesTeamplayerid() {
		return vseriesTeamplayerid;
	}

	/**
	 * Sets the vseries teamplayerid.
	 *
	 * @param vseriesTeamplayerid the new vseries teamplayerid
	 */
	public void setVseriesTeamplayerid(List<SeriesTeamPlayer> vseriesTeamplayerid) {
		this.vseriesTeamplayerid = vseriesTeamplayerid;
	}
	
	


}
