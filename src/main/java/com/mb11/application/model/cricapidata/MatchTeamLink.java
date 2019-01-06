package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matchteamlink")
public class MatchTeamLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Match mid;

	@Column(nullable = false)
	private SeriesTeamLink seriesTeamLinkId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Match getMid() {
		return mid;
	}

	public void setMid(Match mid) {
		this.mid = mid;
	}

	public SeriesTeamLink getSeriesTeamLinkId() {
		return seriesTeamLinkId;
	}

	public void setSeriesTeamLinkId(SeriesTeamLink seriesTeamLinkId) {
		this.seriesTeamLinkId = seriesTeamLinkId;
	}

}
