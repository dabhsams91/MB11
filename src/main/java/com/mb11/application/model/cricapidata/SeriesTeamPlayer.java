package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seriesteamplayer")
public class SeriesTeamPlayer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private Series sid;
	
	@Column(nullable = false)
	private MTeam mid;
	
	@Column(nullable = false)
	private String pfirstname;
	
	private String pmiddlename;

	@Column(nullable = false)
	private String plastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Series getSid() {
		return sid;
	}

	public void setSid(Series sid) {
		this.sid = sid;
	}

	public MTeam getMid() {
		return mid;
	}

	public void setMid(MTeam mid) {
		this.mid = mid;
	}

	public String getPfirstname() {
		return pfirstname;
	}

	public void setPfirstname(String pfirstname) {
		this.pfirstname = pfirstname;
	}

	public String getPmiddlename() {
		return pmiddlename;
	}

	public void setPmiddlename(String pmiddlename) {
		this.pmiddlename = pmiddlename;
	}

	public String getPlastname() {
		return plastname;
	}

	public void setPlastname(String plastname) {
		this.plastname = plastname;
	}
}
