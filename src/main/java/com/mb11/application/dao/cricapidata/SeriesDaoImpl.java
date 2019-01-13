package com.mb11.application.dao.cricapidata;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.cricapidata.Series;

// TODO: Auto-generated Javadoc
/**
 * The Class SeriesDaoImpl.
 */
@Transactional
@Repository
public class SeriesDaoImpl implements SeriesDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.cricapidata.SeriesDAO#getAllSeries()
	 */
	@Override
	public List<Series> getAllSeries() {

		return entityManager.createQuery("from Series", Series.class).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.SeriesDAO#getSeriesWrtStartAndEndDate(
	 * java.util.Date, java.util.Date)
	 */
	public List<Series> getSeriesWrtStartAndEndDate(Date startDate, Date endDate) {
		return entityManager.createQuery(
				"from Series where startdate>=" + "'" + startDate + "'" + "and enddate<=" + "'" + endDate + "'",
				Series.class).getResultList();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.SeriesDAO#getSeriesById(java.lang.Long)
	 */
	@Override
	public Series getSeriesById(Long id) {

		return entityManager.find(Series.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.SeriesDAO#addSeries(com.mb11.application
	 * .model.cricapidata.Series)
	 */
	@Override
	public Series addSeries(Series series) {

		return entityManager.merge(series);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.cricapidata.SeriesDAO#updateSeries(com.mb11.
	 * application.model.cricapidata.Series)
	 */
	@Override
	public Series updateSeries(Series series) {

		Series sr = getSeriesById(series.getID());

		return entityManager.merge(sr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.SeriesDAO#deleteSeries(java.lang.Long)
	 */
	@Override
	public void deleteSeries(Long id) {

		entityManager.remove(getSeriesById(id));
	}

}
