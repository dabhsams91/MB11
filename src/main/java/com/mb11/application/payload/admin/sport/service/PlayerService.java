package com.mb11.application.payload.admin.sport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.dao.cricapidata.TeamPlayersRepository;
import com.mb11.application.model.cricapidata.Match;
import com.mb11.application.model.cricapidata.TeamPlayers;

@Service
public class PlayerService {

	@Autowired
	private TeamPlayersRepository tmr;
	
	@Autowired
	private com.mb11.application.payload.admin.sport.Player adminPlayer;
	
	private String link="http://localhost:8080/cricapi/palyers";
	
	public List<com.mb11.application.payload.admin.sport.Player> getAllPlayers()
	{
		List<TeamPlayers> teamPlayers=tmr.findAll();
		List<com.mb11.application.payload.admin.sport.Player> am=new ArrayList<>();
	    
		for(TeamPlayers tp:teamPlayers)
		{
			adminPlayer.setObjId(tp.getID());
			adminPlayer.setPlayerId(String.valueOf(tp.getPlayerid()));
			adminPlayer.setSeriesId("");
			adminPlayer.setTeamId("");
			adminPlayer.setName(tp.getFirstname()+" "+tp.getLastname());
			adminPlayer.setLink(link);
			adminPlayer.setMatchId("");
			
			am.add(adminPlayer);
			
		}
		
		
		return am;    
	}
	
	public com.mb11.application.payload.admin.sport.Player getAllPlayersByPlayerId(Long id)
	{
		TeamPlayers tp=tmr.findByPlayerid(id);
		
			adminPlayer.setObjId(tp.getID());
			adminPlayer.setPlayerId(String.valueOf(tp.getPlayerid()));
			adminPlayer.setSeriesId("");
			adminPlayer.setTeamId("");
			adminPlayer.setName(tp.getFirstname()+" "+tp.getLastname());
			adminPlayer.setLink(link+"/"+id);
			adminPlayer.setMatchId("");
			
		
		
		return adminPlayer;    
	}
}
