package com.mb11.application.model.cricapidata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SeriesTeamLink.
 */
@Entity
@Table(name="SeriesTeamLink")
public class SeriesTeamLink {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The m team. */
	@ManyToMany
	private  List<MTeam> mTeam=new ArrayList<>();
	
	/** The series. */
	@ManyToMany
	private  List<Series> series=new ArrayList<>();
	
	
	
	
	/**
	 * Instantiates a new series team link.
	 */
	public SeriesTeamLink() {
		
	}


	/**
	 * Instantiates a new series team link.
	 *
	 * @param mTeam the m team
	 * @param series the series
	 */
	public SeriesTeamLink(List<MTeam> mTeam, List<Series> series) {
		super();
	
		this.mTeam = mTeam;
		this.series = series;
	}


	/**
	 * Instantiates a new series team link.
	 *
	 * @param iD the i D
	 * @param mTeam the m team
	 * @param series the series
	 */
	public SeriesTeamLink(Long iD, List<MTeam> mTeam, List<Series> series) {
		super();
		ID = iD;
		this.mTeam = mTeam;
		this.series = series;
	}




	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getID() {
		return ID;
	}




	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(Long iD) {
		ID = iD;
	}




	/**
	 * Gets the m team.
	 *
	 * @return the m team
	 */
	public List<MTeam> getmTeam() {
		return mTeam;
	}




	/**
	 * Sets the m team.
	 *
	 * @param mTeam the new m team
	 */
	public void setmTeam(List<MTeam> mTeam) {
		this.mTeam = mTeam;
	}




	/**
	 * Gets the series.
	 *
	 * @return the series
	 */
	public List<Series> getSeries() {
		return series;
	}




	/**
	 * Sets the series.
	 *
	 * @param series the new series
	 */
	public void setSeries(List<Series> series) {
		this.series = series;
	}

	
	
	

}
