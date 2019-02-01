package com.mb11.application;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mb11.application.config.MB11Properties;
import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.Series;
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
		
	//List<Series> ls=es.getSeriesAndTeams("201819");
	//sr.saveAll(ls);
		
//	List<Match> matches= es.getMatches(111297L);	
//		mr.saveAll(matches);
		
		//System.out.println(ls.size());
		//sr.saveAll(ls);
		//es.getMatches(111146L);
		
	//	List<MTeam> mt=es.getTeams(111297L);
	//	mtr.saveAll(mt);
		
		//es.getMatches(111297L);
		
		//es.getTeamPlayers(111297L);
		
		
	}
}
