package com.mb11.application.model.cricapidata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MTeam.
 */
@Entity
@Table(name = "MTeam")
public class MTeam {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	@Column(nullable = false)
	private Long teamid;

	/** The teamname. */
	//@Column(nullable = false, unique = true)
	@Column(nullable = false,length=100)
	private String teamname;
	
	@Column(nullable = false,length=100)
	private String teamabbr;
	
	@Column(nullable = false)
	private String logo_url;
	
	@Column(nullable = false,length=10)
	private String sex;
	
	/** The sporttype. */
	@Column(nullable = false)
	private Sporttype sporttype;

	@ManyToMany(mappedBy = "mTeams")
	private Set<Series> series = new HashSet<>();

	public MTeam() {
		
	}
	
	

	public MTeam(Long teamid, String teamname, String teamabbr, String logo_url, String sex, Sporttype sporttype,
			Set<Series> series) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.teamabbr = teamabbr;
		this.logo_url = logo_url;
		this.sex = sex;
		this.sporttype = sporttype;
		this.series = series;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getTeamabbr() {
		return teamabbr;
	}

	public void setTeamabbr(String teamabbr) {
		this.teamabbr = teamabbr;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Sporttype getSporttype() {
		return sporttype;
	}

	public void setSporttype(Sporttype sporttype) {
		this.sporttype = sporttype;
	}

	public Set<Series> getSeries() {
		return series;
	}

	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "MTeam [ID=" + ID + ", teamid=" + teamid + ", teamname=" + teamname + ", teamabbr=" + teamabbr
				+ ", logo_url=" + logo_url + ", sex=" + sex + ", sporttype=" + sporttype + ", series=" + series + "]";
	}
	
	

	

}
