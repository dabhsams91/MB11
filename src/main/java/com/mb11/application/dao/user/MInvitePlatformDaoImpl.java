package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.MInvitePlatform;

// TODO: Auto-generated Javadoc
/**
 * The Class MInvitePlatformDaoImpl.
 */
@Transactional
@Repository
public class MInvitePlatformDaoImpl implements MInvitePlatformDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.MInvitePlatformDAO#getAllMInvitePlatform()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MInvitePlatform> getAllMInvitePlatform() {

		String hql = "FROM MInvitePlatform mInvite ORDER BY mInvite.id";
		return (List<MInvitePlatform>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.MInvitePlatformDAO#getMInvitePlatformById(java.
	 * lang.Long)
	 */
	@Override
	public MInvitePlatform getMInvitePlatformById(Long id) {

		return entityManager.find(MInvitePlatform.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.MInvitePlatformDAO#addMInvitePlatform(com.mb11.
	 * application.model.user.MInvitePlatform)
	 */
	@Override
	public MInvitePlatform addMInvitePlatform(MInvitePlatform mInvitePlatform) {

		return entityManager.merge(mInvitePlatform);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.MInvitePlatformDAO#updateMInvitePlatform(com.
	 * mb11.application.model.user.MInvitePlatform)
	 */
	@Override
	public MInvitePlatform updateMInvitePlatform(MInvitePlatform mInvitePlatform) {

		MInvitePlatform min = getMInvitePlatformById(mInvitePlatform.getID());

		return entityManager.merge(min);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.MInvitePlatformDAO#deleteMInvitePlatform(java.
	 * lang.Long)
	 */
	@Override
	public void deleteMInvitePlatform(Long id) {

		entityManager.remove(getMInvitePlatformById(id));
	}

}
