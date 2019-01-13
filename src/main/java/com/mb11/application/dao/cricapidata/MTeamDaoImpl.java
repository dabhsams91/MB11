package com.mb11.application.dao.cricapidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.dao.cricapidata.MTeamDAO;
import com.mb11.application.model.cricapidata.MTeam;

// TODO: Auto-generated Javadoc
/**
 * The Class MTeamDaoImpl.
 */
@Transactional
@Repository
public class MTeamDaoImpl implements MTeamDAO {
    
	/** The entity manager. */
	@PersistenceContext	
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.mb11.application.dao.cricapidata.MTeamDAO#getAllMTeam()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MTeam> getAllMTeam() {
		
		String hql = "FROM MTeam as mteam ORDER BY mteam.id";
		return (List<MTeam>) entityManager.createQuery(hql).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.mb11.application.dao.cricapidata.MTeamDAO#getMTeamById(java.lang.Long)
	 */
	@Override
	public MTeam getMTeamById(Long id) {
		
		return entityManager.find(MTeam.class, id);
	}

	/* (non-Javadoc)
	 * @see com.mb11.application.dao.cricapidata.MTeamDAO#addMTeam(com.mb11.application.model.cricapidata.MTeam)
	 */
	@Override
	public MTeam addMTeam(MTeam mTeam) {
		return entityManager.merge(mTeam);
	}

	/* (non-Javadoc)
	 * @see com.mb11.application.dao.cricapidata.MTeamDAO#updateMTeam(com.mb11.application.model.cricapidata.MTeam)
	 */
	@Override
	public MTeam updateMTeam(MTeam mTeam) {
		MTeam mt=getMTeamById(mTeam.getID());
		return entityManager.merge(mt);
		
	}

	/* (non-Javadoc)
	 * @see com.mb11.application.dao.cricapidata.MTeamDAO#deleteMTeam(java.lang.Long)
	 */
	@Override
	public void deleteMTeam(Long id) {
		
		entityManager.remove(getMTeamById(id));
		
	}

}
