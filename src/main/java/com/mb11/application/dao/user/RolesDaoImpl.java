package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.Roles;

// TODO: Auto-generated Javadoc
/**
 * The Class RolesDaoImpl.
 */
@Transactional
@Repository
public class RolesDaoImpl implements RolesDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.RolesDAO#getAllRoles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAllRoles() {

		String hql = "FROM Roles as roles ORDER BY roles.id";
		return (List<Roles>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.RolesDAO#getRolesById(java.lang.Long)
	 */
	@Override
	public Roles getRolesById(Long id) {

		return entityManager.find(Roles.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.RolesDAO#addRoles(com.mb11.application.model.
	 * user.Roles)
	 */
	@Override
	public Roles addRoles(Roles roles) {

		return entityManager.merge(roles);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.RolesDAO#updateRoles(com.mb11.application.model
	 * .user.Roles)
	 */
	@Override
	public Roles updateRoles(Roles roles) {

		Roles rls = getRolesById(roles.getID());

		return entityManager.merge(rls);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.RolesDAO#deleteRoles(java.lang.Long)
	 */
	@Override
	public void deleteRoles(Long id) {
		entityManager.remove(getRolesById(id));

	}

}
