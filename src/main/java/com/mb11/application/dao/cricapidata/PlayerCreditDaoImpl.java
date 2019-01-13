package com.mb11.application.dao.cricapidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.cricapidata.PlayerCredit;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCreditDaoImpl.
 */
@Transactional
@Repository
public class PlayerCreditDaoImpl implements PlayerCreditDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.PlayerCreditDAO#getAllPlayerCredit()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerCredit> getAllPlayerCredit() {

		String hql = "FROM PlayerCredit as pc ORDER BY pc.id";
		return (List<PlayerCredit>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.PlayerCreditDAO#getPlayerCreditById(java
	 * .lang.Long)
	 */
	@Override
	public PlayerCredit getPlayerCreditById(Long id) {

		return entityManager.find(PlayerCredit.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.PlayerCreditDAO#addPlayerCredit(com.mb11
	 * .application.model.cricapidata.PlayerCredit)
	 */
	@Override
	public PlayerCredit addPlayerCredit(PlayerCredit playerCredit) {

		return entityManager.merge(playerCredit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.PlayerCreditDAO#updatePlayerCredit(com.
	 * mb11.application.model.cricapidata.PlayerCredit)
	 */
	@Override
	public PlayerCredit updatePlayerCredit(PlayerCredit playerCredit) {

		PlayerCredit pc = getPlayerCreditById(playerCredit.getID());

		return entityManager.merge(pc);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.cricapidata.PlayerCreditDAO#deletePlayerCredit(java.
	 * lang.Long)
	 */
	@Override
	public void deletePlayerCredit(Long id) {

		entityManager.remove(getPlayerCreditById(id));
	}

}
