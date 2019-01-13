package com.mb11.application.payload.admin.sport;

public class Team {

	private long objId;

	private String name;

	private String seriesIdURL;

	private String matchIdURL;

	private String link;

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
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

	public String getMatchIdURL() {
		return matchIdURL;
	}

	public void setMatchIdURL(String matchIdURL) {
		this.matchIdURL = matchIdURL;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
