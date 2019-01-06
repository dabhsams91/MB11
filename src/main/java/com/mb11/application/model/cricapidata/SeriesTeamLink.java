package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seriesteamlink")
public class SeriesTeamLink {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Series sid;
	
	@Column(nullable = false)
	private MTeam mid;

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
	
}
