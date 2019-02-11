package com.mb11.application.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
@Entity
@Table(name = "Address")
public class Address {

	/** The id. */
	@Id
	@GeneratedValue
	private Long ID;

	/** The address 1. */
	@Column(length = 100)
	private String address1;

	/** The address 2. */
	@Column(length = 100)
	private String address2;

	/** The city. */
	@Column(length = 100)
	private String city;

	/** The state. */
	@Column(length = 100)
	private String state;

	/** The country. */
	@Column(length = 100)
	private String country;

	/** The pincode. */
	@Column(length = 100)
	private String pincode;

	private User userid;

	/**
	 * Instantiates a new address.
	 */
	public Address() {

	}

	/**
	 * Instantiates a new address.
	 *
	 * @param address1 the address 1
	 * @param address2 the address 2
	 * @param city     the city
	 * @param state    the state
	 * @param country  the country
	 * @param pincode  the pincode
	 */
	public Address(String address1, String address2, String city, String state, String country, String pincode) {
		super();

		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param iD       the i D
	 * @param address1 the address 1
	 * @param address2 the address 2
	 * @param city     the city
	 * @param state    the state
	 * @param country  the country
	 * @param pincode  the pincode
	 */
	public Address(Long iD, String address1, String address2, String city, String state, String country,
			String pincode) {
		super();
		ID = iD;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * Gets the address 1.
	 *
	 * @return the address 1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the address 1.
	 *
	 * @param address1 the new address 1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the address 2.
	 *
	 * @return the address 2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the address 2.
	 *
	 * @param address2 the new address 2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the new pincode
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

}
