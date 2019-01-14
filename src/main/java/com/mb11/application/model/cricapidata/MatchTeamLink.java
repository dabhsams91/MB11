package com.mb11.application.model.cricapidata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchTeamLink.
 */
@Entity
@Table(name = "MatchTeamLink")
public class MatchTeamLink {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The matchid. */
	@ManyToOne
	@JoinColumn(name = "matchid", nullable = false)
	private Match matchid;

	/** The sid. */
	@ManyToOne
	@JoinColumn(name = "sid", nullable = false)
	private Series sid;

	/** The sid. */
	@ManyToOne
	@JoinColumn(name = "teamid", nullable = false)
	private MTeam teamid;

	public MatchTeamLink(Match matchid, Series sid, MTeam teamid) {
		this.matchid = matchid;
		this.sid = sid;
		this.teamid = teamid;
	}

	/**
	 * Instantiates a new match team link.
	 *
	 * @param iD               the i D
	 * @param mid              the mid
	 * @param seriesteamlinkid the seriesteamlinkid
	 */
	public MatchTeamLink(Long iD, Match matchid, Series sid, MTeam teamid) {
		ID = iD;
		this.matchid = matchid;
		this.sid = sid;
		this.teamid = teamid;
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

	public Match getMatchid() {
		return matchid;
	}

	public void setMatchid(Match matchid) {
		this.matchid = matchid;
	}

	public Series getSid() {
		return sid;
	}

	public void setSid(Series sid) {
		this.sid = sid;
	}

	public MTeam getTeamid() {
		return teamid;
	}

	public void setTeamid(MTeam teamid) {
		this.teamid = teamid;
	}

}
