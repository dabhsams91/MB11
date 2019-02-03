package com.mb11.application.model.cricapidata;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Series.
 */
@Entity
@Table(name = "Series")
public class Series {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long ID;

	/** The series id. */
	@NotNull
	@Column(name = "seriesid", unique = true, length = 30)
	private String seriesid;

	/** The sname. */
	@Column(nullable = false, length = 100)
	private String sname;

	@Column(nullable = false, length = 100)
	private String short_name;

	@Column(nullable = false, length = 30)
	private String category;

	/** The startdate. */
	@Column(nullable = false)
	private Date startdate;

	/** The enddate. */
	@Column(nullable = false)
	private Date enddate;

	/** The totalmatch. */
	@Column(nullable = false)
	private int totalmatch;

	@Column(nullable = false)
	private int totalteams;

	@Column(nullable = false)
	private Boolean status;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "SeriesTeamLink", joinColumns = { @JoinColumn(name = "sid") }, inverseJoinColumns = {
			@JoinColumn(name = "mteamid") })
	Set<MTeam> mTeams = new HashSet<>();

	public Series() {

	}

	public Series(@NotNull String seriesid, String sname, String short_name, String category, Date startdate,
			Date enddate, int totalmatch, int totalteams, Boolean status) {
		super();
		this.seriesid = seriesid;
		this.sname = sname;
		this.short_name = short_name;
		this.category = category;
		this.startdate = startdate;
		this.enddate = enddate;
		this.totalmatch = totalmatch;
		this.totalteams = totalteams;
		this.status = status;

	}

	public Series(@NotNull String seriesid, String sname, String short_name, String category, Date startdate,
			Date enddate, int totalmatch, int totalteams, Boolean status, Set<MTeam> mTeams) {
		super();
		this.seriesid = seriesid;
		this.sname = sname;
		this.short_name = short_name;
		this.category = category;
		this.startdate = startdate;
		this.enddate = enddate;
		this.totalmatch = totalmatch;
		this.totalteams = totalteams;
		this.status = status;
		this.mTeams = mTeams;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getSeriesid() {
		return seriesid;
	}

	public void setSeriesid(String seriesid) {
		this.seriesid = seriesid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getTotalmatch() {
		return totalmatch;
	}

	public void setTotalmatch(int totalmatch) {
		this.totalmatch = totalmatch;
	}

	public int getTotalteams() {
		return totalteams;
	}

	public void setTotalteams(int totalteams) {
		this.totalteams = totalteams;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<MTeam> getmTeams() {
		return mTeams;
	}

	public void setmTeams(Set<MTeam> mTeams) {
		this.mTeams = mTeams;
	}

	@Override
	public String toString() {
		return "Series [ID=" + ID + ", seriesid=" + seriesid + ", sname=" + sname + ", short_name=" + short_name
				+ ", category=" + category + ", startdate=" + startdate + ", enddate=" + enddate + ", totalmatch="
				+ totalmatch + ", totalteams=" + totalteams + ", status=" + status + ", mTeams=" + mTeams + "]";
	}

}
