package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.UserInvitePlatformLink;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInvitePlatformLinkDaoImpl.
 */
@Transactional
@Repository
public class UserInvitePlatformLinkDaoImpl implements UserInvitePlatformLinkDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UserInvitePlatformLinkDAO#
	 * getAllUserInvitePlatformLink()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInvitePlatformLink> getAllUserInvitePlatformLink() {

		String hql = "FROM UserInvitePlatformLink as usr ORDER BY usr.id";
		return (List<UserInvitePlatformLink>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UserInvitePlatformLinkDAO#
	 * getUserInvitePlatformLinkById(java.lang.Long)
	 */
	@Override
	public UserInvitePlatformLink getUserInvitePlatformLinkById(Long id) {

		return entityManager.find(UserInvitePlatformLink.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UserInvitePlatformLinkDAO#
	 * addUserInvitePlatformLink(com.mb11.application.model.user.
	 * UserInvitePlatformLink)
	 */
	@Override
	public UserInvitePlatformLink addUserInvitePlatformLink(UserInvitePlatformLink userInvitePlatformLink) {

		return entityManager.merge(userInvitePlatformLink);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UserInvitePlatformLinkDAO#
	 * updateUserInvitePlatformLink(com.mb11.application.model.user.
	 * UserInvitePlatformLink)
	 */
	@Override
	public UserInvitePlatformLink updateUserInvitePlatformLink(UserInvitePlatformLink userInvitePlatformLink) {
		UserInvitePlatformLink uipl = getUserInvitePlatformLinkById(userInvitePlatformLink.getID());

		return entityManager.merge(uipl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UserInvitePlatformLinkDAO#
	 * deleteUserInvitePlatformLink(java.lang.Long)
	 */
	@Override
	public void deleteUserInvitePlatformLink(Long id) {

		entityManager.remove(getUserInvitePlatformLinkById(id));
	}

}
