package com.mb11.application.payload.admin.sport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.cricapidata.MatchRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Match;

@Service
public class MatchService {

	@Autowired
	private MatchRepository mr;
	
	@Autowired
	private com.mb11.application.payload.admin.sport.Match adminMatch;
	
	private String link="http://localhost:8080/cricapi/matches";
	
	public List<com.mb11.application.payload.admin.sport.Match> getAllMatches()
	{
		List<Match> match=mr.findAll();
		List<com.mb11.application.payload.admin.sport.Match> am=new ArrayList<>();
	    
		for(Match m:match)
		{
			adminMatch.setObjId(m.getID());
			adminMatch.setName(m.getMatchname());
			adminMatch.setLink(link);
			adminMatch.setMatchId(String.valueOf(m.getMatchid()));
			adminMatch.setSeriesIdURL("");
	
			
			am.add(adminMatch);
			
		}
		
		
		return am;    
	}
	
	
	public com.mb11.application.payload.admin.sport.Match getMatchByMatchId(Long id)
	{
		Match m=mr.findByMatchid(id);
		adminMatch.setObjId(m.getID());
		adminMatch.setName(m.getMatchname());
		adminMatch.setLink(link+"/"+id);
		adminMatch.setMatchId(String.valueOf(m.getMatchid()));
		adminMatch.setSeriesIdURL("");
		
		 return adminMatch;
	}
	
	
}
