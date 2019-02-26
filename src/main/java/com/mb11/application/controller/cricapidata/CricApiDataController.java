package com.mb11.application.controller.cricapidata;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.model.cricapidata.Series;

@RestController
public class CricApiDataController {
	
	@Autowired
	private SeriesRepository sr;
	
	@GetMapping("/series")
	public List<Series> retrieveAllSeries() {
		return sr.findAll();
	}
	
	
	@GetMapping("/series/{id}")
	public Resource<Series> retrieveUser(@PathVariable String id) {
	Series series = sr.findBySeriesid(id);
		
		if(series==null)
			throw new SeriesNotFoundException("id-"+ id);
		
		
		//"all-series", SERVER_PATH + "/series"
		//retrieveAllSereis
		Resource<Series> resource = new Resource<Series>(series);
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllSeries());
		
		resource.add(linkTo.withRel("all-series"));
		
		//HATEOAS
		
		return resource;
	}
	
	

}
