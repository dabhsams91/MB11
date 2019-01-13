package com.mb11.application.dao.cricapidata;

import java.util.Date;
import java.util.List;

import com.mb11.application.model.cricapidata.Series;


// TODO: Auto-generated Javadoc
/**
 * The Interface SeriesDAO.
 */
public interface SeriesDAO {
	
	/**
	 * Gets the all series.
	 *
	 * @return the all series
	 */
	List<Series> getAllSeries();
	
	/**
	 * Gets the series by id.
	 *
	 * @param id the id
	 * @return the series by id
	 */
	Series getSeriesById(Long id);
	
	/**
	 * Adds the series.
	 *
	 * @param series the series
	 */
	Series addSeries(Series series);
	
	/**
	 * Update series.
	 *
	 * @param series the series
	 */
	Series updateSeries(Series series);
	
	/**
	 * Delete series.
	 *
	 * @param id the id
	 */
	void deleteSeries(Long id);
	
	/**
	 * Gets the series wrt start and end date.
	 *
	 * @param startSate the start sate
	 * @param endDate the end date
	 * @return the series wrt start and end date
	 */
	List<Series> getSeriesWrtStartAndEndDate(Date startSate,Date endDate);

}
