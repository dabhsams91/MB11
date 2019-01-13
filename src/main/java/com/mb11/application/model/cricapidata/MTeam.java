package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MTeam.
 */
@Entity
@Table(name="MTeam")
public class MTeam {
	
	/** The id. */
	@Id
	@GeneratedValue
	Long ID;
	
	/** The teamname. */
	@Column(nullable = false,unique = true)
	String teamname;
	
	
	/** The sporttype. */
	@Column(nullable = false)
	Sporttype sporttype;
	
	/**
	 * Instantiates a new m team.
	 */
	public MTeam() {
	
		
	}
	
	/**
	 * Instantiates a new m team.
	 *
	 * @param teamname the teamname
	 * @param sporttype the sporttype
	 */
	public MTeam(String teamname, Sporttype sporttype) {
		super();
		
		this.teamname = teamname;
		this.sporttype = sporttype;
	}
	
	/**
	 * Instantiates a new m team.
	 *
	 * @param iD the i D
	 * @param teamname the teamname
	 * @param sporttype the sporttype
	 */
	public MTeam(Long iD, String teamname, Sporttype sporttype) {
		super();
		ID = iD;
		this.teamname = teamname;
		this.sporttype = sporttype;
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
	 * Gets the teamname.
	 *
	 * @return the teamname
	 */
	public String getTeamname() {
		return teamname;
	}

	/**
	 * Sets the teamname.
	 *
	 * @param teamname the new teamname
	 */
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	/**
	 * Gets the sporttype.
	 *
	 * @return the sporttype
	 */
	public Sporttype getSporttype() {
		return sporttype;
	}

	/**
	 * Sets the sporttype.
	 *
	 * @param sporttype the new sporttype
	 */
	public void setSporttype(Sporttype sporttype) {
		this.sporttype = sporttype;
	}
	
	
	
	
	  

}
