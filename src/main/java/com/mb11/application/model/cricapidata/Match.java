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
public class Match {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String matchname;
	
	@Column(nullable = false)
	private Series sid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatchname() {
		return matchname;
	}

	public void setMatchname(String matchname) {
		this.matchname = matchname;
	}

	public Series getSid() {
		return sid;
	}

	public void setSid(Series sid) {
		this.sid = sid;
	}
	
	
}
