package com.mb11.application.dao.cricapidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.cricapidata.TeamPlayers;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamPlayersDaoImpl.
 */
@Transactional
@Repository
public class TeamPlayersDaoImpl implements TeamPlayersDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.cricapidata.TeamPlayersDAO#getAllTeamPlayers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamPlayers> getAllTeamPlayers() {

		String hql = "FROM TeamPlayers as tp ORDER BY tp.id";
		return (List<TeamPlayers>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.TeamPlayersDAO#getTeamPlayersById(java.
	 * lang.Long)
	 */
	@Override
	public TeamPlayers getTeamPlayersById(Long id) {

		return entityManager.find(TeamPlayers.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.TeamPlayersDAO#addTeamPlayers(com.mb11.
	 * application.model.cricapidata.TeamPlayers)
	 */
	@Override
	public TeamPlayers addTeamPlayers(TeamPlayers teamPlayers) {

		return entityManager.merge(teamPlayers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.TeamPlayersDAO#updateTeamPlayers(com.
	 * mb11.application.model.cricapidata.TeamPlayers)
	 */
	@Override
	public TeamPlayers updateTeamPlayers(TeamPlayers teamPlayers) {
		TeamPlayers tp = getTeamPlayersById(teamPlayers.getID());

		return entityManager.merge(tp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.TeamPlayersDAO#deleteTeamPlayers(java.
	 * lang.Long)
	 */
	@Override
	public void deleteTeamPlayers(Long id) {
		entityManager.remove(getTeamPlayersById(id));

	}

}
