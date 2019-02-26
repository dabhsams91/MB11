package com.mb11.application.payload.admin.sport;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Series {

	private long objId;

	private String seriesId;

	private String displayName;

	private Date startdate;

	private Date enddate;

	private int totalmatch;

	private String matchlistLink;

	private String teamlistLink;

	private String link;

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public String getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public String getMatchlistLink() {
		return matchlistLink;
	}

	public void setMatchlistLink(String matchlistLink) {
		this.matchlistLink = matchlistLink;
	}

	public String getTeamlistLink() {
		return teamlistLink;
	}

	public void setTeamlistLink(String teamlistLink) {
		this.teamlistLink = teamlistLink;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
