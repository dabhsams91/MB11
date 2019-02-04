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
 * The Class Match.
 */
@Entity
@Table(name = "Matches")
public class Match {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	@Column(nullable = false)
	private Long matchid;

	/** The matchname. */
	@Column(nullable = false, length = 200)
	private String matchname;

	@Column(nullable = false, length = 100)
	private String format_str;

	@Column(nullable = false, length = 100)
	private String status_str;

	/** The sid. */
	@ManyToOne
	@JoinColumn(name = "sid", nullable = false)
	private Series sid;

	/**
	 * Instantiates a new match.
	 */
	public Match() {

	}

	public Match(Long matchid, String matchname, String format_str, String status_str, Series sid) {
		super();
		this.matchid = matchid;
		this.matchname = matchname;
		this.format_str = format_str;
		this.status_str = status_str;
		this.sid = sid;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	public String getMatchname() {
		return matchname;
	}

	public void setMatchname(String matchname) {
		this.matchname = matchname;
	}

	public String getFormat_str() {
		return format_str;
	}

	public void setFormat_str(String format_str) {
		this.format_str = format_str;
	}

	public String getStatus_str() {
		return status_str;
	}

	public void setStatus_str(String status_str) {
		this.status_str = status_str;
	}

	public Series getSid() {
		return sid;
	}

	public void setSid(Series sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Match [ID=" + ID + ", matchid=" + matchid + ", matchname=" + matchname + ", format_str=" + format_str
				+ ", status_str=" + status_str + ", sid=" + sid + "]";
	}

}
