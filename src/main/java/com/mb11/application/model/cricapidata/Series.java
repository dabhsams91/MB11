package com.mb11.application.model.cricapidata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String seriesId;

	/** The sname. */
	@Column(nullable = false, length = 30)
	private String sname;

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
	private Boolean status;

	/**
	 * Instantiates a new series.
	 *
	 * @param seriesId   the series id
	 * @param sname      the sname
	 * @param startdate  the startdate
	 * @param enddate    the enddate
	 * @param totalmatch the totalmatch
	 */
	public Series(String seriesId, String sname, Date startdate, Date enddate, int totalmatch, Boolean status) {

		this.seriesId = seriesId;
		this.sname = sname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.totalmatch = totalmatch;
		this.status = status;
	}

	/**
	 * Instantiates a new series.
	 *
	 * @param iD         the i D
	 * @param seriesId   the series id
	 * @param sname      the sname
	 * @param startdate  the startdate
	 * @param enddate    the enddate
	 * @param totalmatch the totalmatch
	 */
	public Series(long id, String seriesId, String sname, Date startdate, Date enddate, int totalmatch,
			Boolean status) {
		super();
		ID = id;
		this.seriesId = seriesId;
		this.sname = sname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.totalmatch = totalmatch;
		this.status = status;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(long iD) {
		ID = iD;
	}

	/**
	 * Gets the series id.
	 *
	 * @return the series id
	 */
	public String getSeriesId() {
		return seriesId;
	}

	/**
	 * Sets the series id.
	 *
	 * @param seriesId the new series id
	 */
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * Gets the sname.
	 *
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * Sets the sname.
	 *
	 * @param sname the new sname
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * Gets the startdate.
	 *
	 * @return the startdate
	 */
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * Sets the startdate.
	 *
	 * @param startdate the new startdate
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * Gets the enddate.
	 *
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * Sets the enddate.
	 *
	 * @param enddate the new enddate
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	/**
	 * Gets the totalmatch.
	 *
	 * @return the totalmatch
	 */
	public int getTotalmatch() {
		return totalmatch;
	}

	/**
	 * Sets the totalmatch.
	 *
	 * @param totalmatch the new totalmatch
	 */
	public void setTotalmatch(int totalmatch) {
		this.totalmatch = totalmatch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Series [ID=" + ID + ", seriesId=" + seriesId + ", sname=" + sname + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", totalmatch=" + totalmatch + "]";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
