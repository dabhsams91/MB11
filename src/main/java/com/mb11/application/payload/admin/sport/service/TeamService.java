package com.mb11.application.payload.admin.sport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.cricapidata.MTeamRepository;
import com.mb11.application.model.cricapidata.MTeam;
import com.mb11.application.model.cricapidata.Series;

@Service
public class TeamService {
	
	@Autowired
	private MTeamRepository mr;
	
	@Autowired
	private com.mb11.application.payload.admin.sport.Team adminTeam;
	
	private String link="http://localhost:8080/cricapi/teams";
	
	public List<com.mb11.application.payload.admin.sport.Team> getAllTeams()
	{
		List<MTeam> mTeam=mr.findAll();
		List<com.mb11.application.payload.admin.sport.Team> at=new ArrayList<>();
	    
		for(MTeam m:mTeam)
		{
			adminTeam.setObjId(m.getID());
			adminTeam.setName(m.getTeamname());
			adminTeam.setLink(link);
			adminTeam.setMatchIdURL("");
			adminTeam.setSeriesIdURL("");
			
			at.add(adminTeam);
			
		}
		
		
		return at;    
	}
	
	public com.mb11.application.payload.admin.sport.Team getTeamsByTeamId(Long id)
	{
		MTeam mTeam=mr.findByTeamid(id);
		
		
			adminTeam.setObjId(mTeam.getID());
			adminTeam.setName(mTeam.getTeamname());
			adminTeam.setLink(link+"/"+id);
			adminTeam.setMatchIdURL("");
			adminTeam.setSeriesIdURL("");
			
					
		
		return adminTeam;    
	}
	
	

}
