package com.mb11.application.model.cricapidata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchTeamLink.
 */
@Entity
@Table(name="MatchTeamLink")
public class MatchTeamLink {
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;
	
	/** The mid. */
	@Column(nullable = false)
	@OneToMany
	private List<Match> mid=new ArrayList<>();
	
	/** The seriesteamlinkid. */
	@Column(nullable = false)
	@OneToMany
	private List<SeriesTeamLink> seriesteamlinkid=new ArrayList<>();;
	
	/**
	 * Instantiates a new match team link.
	 */
	public MatchTeamLink()
	{
		
	}
	
	/**
	 * Instantiates a new match team link.
	 *
	 * @param mid the mid
	 * @param seriesteamlinkid the seriesteamlinkid
	 */
	public MatchTeamLink(List<Match> mid, List<SeriesTeamLink> seriesteamlinkid) {
		super();

		this.mid = mid;
		this.seriesteamlinkid = seriesteamlinkid;
	}

	/**
	 * Instantiates a new match team link.
	 *
	 * @param iD the i D
	 * @param mid the mid
	 * @param seriesteamlinkid the seriesteamlinkid
	 */
	public MatchTeamLink(Long iD, List<Match> mid, List<SeriesTeamLink> seriesteamlinkid) {
		super();
		ID = iD;
		this.mid = mid;
		this.seriesteamlinkid = seriesteamlinkid;
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
	 * Gets the mid.
	 *
	 * @return the mid
	 */
	public List<Match> getMid() {
		return mid;
	}

	/**
	 * Sets the mid.
	 *
	 * @param mid the new mid
	 */
	public void setMid(List<Match> mid) {
		this.mid = mid;
	}

	/**
	 * Gets the seriesteamlinkid.
	 *
	 * @return the seriesteamlinkid
	 */
	public List<SeriesTeamLink> getSeriesteamlinkid() {
		return seriesteamlinkid;
	}

	/**
	 * Sets the seriesteamlinkid.
	 *
	 * @param seriesteamlinkid the new seriesteamlinkid
	 */
	public void setSeriesteamlinkid(List<SeriesTeamLink> seriesteamlinkid) {
		this.seriesteamlinkid = seriesteamlinkid;
	}

	

}
