package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersDaoImpl.
 */
@Transactional
@Repository
public class UsersDaoImpl implements UsersDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UsersDAO#getAllUsers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {

		String hql = "FROM User as usr ORDER BY usr.id";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UsersDAO#getUsersById(java.lang.Long)
	 */
	@Override
	public User getUsersById(Long id) {

		return entityManager.find(User.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.UsersDAO#addUsers(com.mb11.application.model.
	 * user.Users)
	 */
	@Override
	public User addUsers(User users) {

		return entityManager.merge(users);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.UsersDAO#updateUsers(com.mb11.application.model
	 * .user.Users)
	 */
	@Override
	public User updateUsers(User users) {
		users = getUsersById(users.getID());
		return entityManager.merge(users);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.UsersDAO#deleteUsers(java.lang.Long)
	 */
	@Override
	public void deleteUsers(Long id) {
		entityManager.remove(getUsersById(id));

	}

	@Override
	public User findByEmail(String email) {
		try {
			String hql = "FROM User as usr where usr.email= :email";
			Query query = entityManager.createQuery(hql).setParameter("email", email);
			User user = (User) query.getSingleResult();
			return user;
		} catch (NoResultException noResultException) {
			return null;
		}
	}

	@Override
	public User findByMobilenumber(String mobilenumber) {
		String hql = "FROM User as usr where usr.mobilenumber= :mobilenumber";
		try {
			Query query = entityManager.createQuery(hql).setParameter("mobilenumber", mobilenumber);
			User user = (User) query.getSingleResult();
			return user;
		} catch (NoResultException noResultException) {
			return null;
		}
	}
}
