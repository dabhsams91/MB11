package com.mb11.application.model.cricapidata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamPlayers.
 */
@Entity
@Table(name="TeamPlayers")
public class TeamPlayers {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The firstname. */
	@Column(nullable = false,length=30)
	private String firstname;
	
	/** The middlename. */
	@Column(length=30)
	private String middlename;
	
	/** The lastname. */
	@Column(nullable = false,length=30)
	private String lastname;
	
	/** The m team. */
	@Column(nullable = false)
	@OneToMany
	private List<MTeam> mTeam=new ArrayList<>();
	
	/**
	 * Instantiates a new team players.
	 */
	public TeamPlayers()
	{
		
	}
	
	/**
	 * Instantiates a new team players.
	 *
	 * @param firstname the firstname
	 * @param middlename the middlename
	 * @param lastname the lastname
	 * @param mTeam the m team
	 */
	public TeamPlayers(String firstname, String middlename, String lastname, List<MTeam> mTeam) {
		super();
		
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.mTeam = mTeam;
	
	}

	/**
	 * Instantiates a new team players.
	 *
	 * @param iD the i D
	 * @param firstname the firstname
	 * @param middlename the middlename
	 * @param lastname the lastname
	 * @param mTeam the m team
	 */
	public TeamPlayers(Long iD, String firstname, String middlename, String lastname, List<MTeam> mTeam) {
		super();
		ID = iD;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.mTeam = mTeam;
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
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the middlename.
	 *
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * Sets the middlename.
	 *
	 * @param middlename the new middlename
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the m team.
	 *
	 * @return the m team
	 */
	public List<MTeam> getmTeam() {
		return mTeam;
	}

	/**
	 * Sets the m team.
	 *
	 * @param mTeam the new m team
	 */
	public void setmTeam(List<MTeam> mTeam) {
		this.mTeam = mTeam;
	}

	
	

	
}
