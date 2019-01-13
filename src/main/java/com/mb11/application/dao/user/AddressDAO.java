package com.mb11.application.dao.user;

import java.util.List;

import com.mb11.application.model.user.Address;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddressDAO.
 */
public interface AddressDAO {

	/**
	 * Gets the all address.
	 *
	 * @return the all address
	 */
	List<Address> getAllAddress();

	/**
	 * Gets the address by id.
	 *
	 * @param id the id
	 * @return the address by id
	 */
	Address getAddressById(Long id);

	/**
	 * Adds the address.
	 *
	 * @param address the address
	 */
	Address addAddress(Address address);

	/**
	 * Update address.
	 *
	 * @param address the address
	 */
	Address updateAddress(Address address);

	/**
	 * Delete address.
	 *
	 * @param id the id
	 */
	void deleteAddress(Long id);

}
