package com.mb11.application.dao.cricapidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.dao.cricapidata.MatchTeamLinkDAO;
import com.mb11.application.model.cricapidata.MatchTeamLink;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchTeamLinkDaoImpl.
 */
@Transactional
@Repository
public class MatchTeamLinkDaoImpl implements MatchTeamLinkDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.MatchTeamLinkDAO#getAllMatchTeamLink()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MatchTeamLink> getAllMatchTeamLink() {

		String hql = "FROM MatchTeamLink as mtl ORDER BY mtl.id";
		return (List<MatchTeamLink>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.MatchTeamLinkDAO#getMatchTeamLinkById(
	 * java.lang.Long)
	 */
	@Override
	public MatchTeamLink getMatchTeamLinkById(Long id) {

		return entityManager.find(MatchTeamLink.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.MatchTeamLinkDAO#addMatchTeamLink(com.
	 * mb11.application.model.cricapidata.MatchTeamLink)
	 */
	@Override
	public MatchTeamLink addMatchTeamLink(MatchTeamLink matchTeamLink) {

		return entityManager.merge(matchTeamLink);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.MatchTeamLinkDAO#updateMatchTeamLink(com
	 * .mb11.application.model.cricapidata.MatchTeamLink)
	 */
	@Override
	public MatchTeamLink updateMatchTeamLink(MatchTeamLink matchTeamLink) {

		MatchTeamLink mtl = getMatchTeamLinkById(matchTeamLink.getID());

		return entityManager.merge(mtl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.MatchTeamLinkDAO#deleteMatchTeamLink(
	 * java.lang.Long)
	 */
	@Override
	public void deleteMatchTeamLink(Long id) {
		entityManager.remove(getMatchTeamLinkById(id));

	}

}
