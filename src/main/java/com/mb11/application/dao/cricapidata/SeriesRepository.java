package com.mb11.application.dao.cricapidata;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

	public Series findBySeriesid(String seriesId);
	
	 @Query(value = "SELECT * FROM SERIES WHERE startdate >= ?1 and enddate<=?2", nativeQuery = true)
	  public List<Series> findByDates(Date startDate,Date endDate);
}
