package com.mb11.application.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mb11.application.model.user.Address;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressDaoImpl.
 */
@Transactional
@Repository
public class AddressDaoImpl implements AddressDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.AddressDAO#getAllAddress()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddress() {
		String hql = "FROM Address addr usr ORDER BY addr.id";
		return (List<Address>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.AddressDAO#getAddressById(java.lang.Long)
	 */
	@Override
	public Address getAddressById(Long id) {

		return entityManager.find(Address.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.AddressDAO#addAddress(com.mb11.application.
	 * model.user.Address)
	 */
	@Override
	public Address addAddress(Address address) {
		return entityManager.merge(address);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mb11.application.dao.user.AddressDAO#updateAddress(com.mb11.application.
	 * model.user.Address)
	 */
	@Override
	public Address updateAddress(Address address) {
		Address addr = getAddressById(address.getID());

		return entityManager.merge(addr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mb11.application.dao.user.AddressDAO#deleteAddress(java.lang.Long)
	 */
	@Override
	public void deleteAddress(Long id) {

		entityManager.remove(getAddressById(id));
	}

}
