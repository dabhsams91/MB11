package com.mb11.application.model.cricapidata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SeriesTeamPlayer.
 */
@Entity
@Table(name="SeriesTeamPlayer")
public class SeriesTeamPlayer {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The sid. */
	@ManyToMany
	private List<Series> sid=new ArrayList<>();
	
	/** The tpid. */
	@ManyToMany
	private List<TeamPlayers> tpid=new ArrayList<>();
	
	/**
	 * Instantiates a new series team player.
	 */
	public SeriesTeamPlayer()
	{
		
	}
	
	/**
	 * Instantiates a new series team player.
	 *
	 * @param sid the sid
	 * @param tpid the tpid
	 */
	public SeriesTeamPlayer(List<Series> sid, List<TeamPlayers> tpid) {
		super();
		
		this.sid = sid;
		this.tpid = tpid;
	}

	/**
	 * Instantiates a new series team player.
	 *
	 * @param iD the i D
	 * @param sid the sid
	 * @param tpid the tpid
	 */
	public SeriesTeamPlayer(Long iD, List<Series> sid, List<TeamPlayers> tpid) {
		super();
		ID = iD;
		this.sid = sid;
		this.tpid = tpid;
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
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public List<Series> getSid() {
		return sid;
	}

	/**
	 * Sets the sid.
	 *
	 * @param sid the new sid
	 */
	public void setSid(List<Series> sid) {
		this.sid = sid;
	}

	/**
	 * Gets the tpid.
	 *
	 * @return the tpid
	 */
	public List<TeamPlayers> getTpid() {
		return tpid;
	}

	/**
	 * Sets the tpid.
	 *
	 * @param tpid the new tpid
	 */
	public void setTpid(List<TeamPlayers> tpid) {
		this.tpid = tpid;
	}

	
	

}
