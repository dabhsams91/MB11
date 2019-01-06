package com.mb11.application.model.cricapidata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "match", uniqueConstraints = {@UniqueConstraint(columnNames = "matchname")})
public class MatchTeamLink {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Match mid;
	
	@Column(nullable = false)
	private SeriesTeamLink seriesTeamLinkId;
}
