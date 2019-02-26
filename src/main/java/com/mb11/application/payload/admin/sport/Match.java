package com.mb11.application.payload.admin.sport;

import org.springframework.stereotype.Service;

@Service
public class Match {

	private long objId;

	private String matchId;

	private String name;

	private String seriesIdURL;

	private String link;

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeriesIdURL() {
		return seriesIdURL;
	}

	public void setSeriesIdURL(String seriesIdURL) {
		this.seriesIdURL = seriesIdURL;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
