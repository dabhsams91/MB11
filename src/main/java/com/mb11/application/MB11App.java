package com.mb11.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mb11.application.config.MB11Properties;
import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.service.sport.EntitySportAPIService;

@SpringBootApplication
@EnableConfigurationProperties(MB11Properties.class)
public class MB11App implements CommandLineRunner
{
	@Autowired
	EntitySportAPIService es;
	
	@Autowired
	SeriesRepository sr;
	
	@Autowired
	MTeamRepository mtr;
	
	@Autowired
	MatchRepository mr;
	
	public static void main(String[] args) {
		SpringApplication.run(MB11App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
