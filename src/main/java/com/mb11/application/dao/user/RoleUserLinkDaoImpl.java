package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.RoleUserLink;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleUserLinkDaoImpl.
 */
@Transactional
@Repository
public class RoleUserLinkDaoImpl implements RoleUserLinkDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.RoleUserLinkDAO#getAllRoleUserLink()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleUserLink> getAllRoleUserLink() {

		String hql = "FROM RoleUserLink as rolesUserLink ORDER BY rolesUserLink.id";
		return (List<RoleUserLink>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.RoleUserLinkDAO#getRoleUserLinkById(java.lang.
	 * Long)
	 */
	@Override
	public RoleUserLink getRoleUserLinkById(Long id) {

		return entityManager.find(RoleUserLink.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.RoleUserLinkDAO#addRoleUserLink(com.mb11.
	 * application.model.user.RoleUserLink)
	 */
	@Override
	public RoleUserLink addRoleUserLink(RoleUserLink roleUserLink) {
		return entityManager.merge(roleUserLink);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.RoleUserLinkDAO#updateRoleUserLink(com.mb11.
	 * application.model.user.RoleUserLink)
	 */
	@Override
	public RoleUserLink updateRoleUserLink(RoleUserLink roleUserLink) {

		RoleUserLink rul = getRoleUserLinkById(roleUserLink.getID());

		return entityManager.merge(rul);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.RoleUserLinkDAO#deleteRoleUserLink(java.lang.
	 * Long)
	 */
	@Override
	public void deleteRoleUserLink(Long id) {

		entityManager.remove(getRoleUserLinkById(id));
	}

}
