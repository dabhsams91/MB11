package com.mb11.application.payload.user;

import java.time.LocalDate;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Users.
 */

public class User {

	/** The id. */
	private Long ID;

	/** The name. */
	private String name;

	/** The email. */
	private String email;

	private String imageUrl;

	/** The email verified. */
	private boolean emailVerified;

	private String mobilenumber;

	private String providerId;

	private String firstname;

	private String middlename;

	private String lastname;

	private LocalDate dob;

	private LocalDate createtime;

	private LocalDate updatetime;

	private String reffrencecode;

	private Set<Role> roles;

	private Set<Address> addresses;

	private Set<InvitePlatform> invitePlatforms;

	/**
	 * Instantiates a new users.
	 */
	public User() {

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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Checks if is email verified.
	 *
	 * @return true, if is email verified
	 */
	public boolean isEmailVerified() {
		return emailVerified;
	}

	/**
	 * Sets the email verified.
	 *
	 * @param emailVerified the new email verified
	 */
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	/**
	 * Gets the mobilenumber.
	 *
	 * @return the mobilenumber
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * Sets the mobilenumber.
	 *
	 * @param mobilenumber the new mobilenumber
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * Gets the provider id.
	 *
	 * @return the provider id
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * Sets the provider id.
	 *
	 * @param providerId the new provider id
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the middlename.
	 *
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * Sets the middlename.
	 *
	 * @param middlename the new middlename
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * Gets the createtime.
	 *
	 * @return the createtime
	 */
	public LocalDate getCreatetime() {
		return createtime;
	}

	/**
	 * Sets the createtime.
	 *
	 * @param createtime the new createtime
	 */
	public void setCreatetime(LocalDate createtime) {
		this.createtime = createtime;
	}

	/**
	 * Gets the updatetime.
	 *
	 * @return the updatetime
	 */
	public LocalDate getUpdatetime() {
		return updatetime;
	}

	/**
	 * Sets the updatetime.
	 *
	 * @param updatetime the new updatetime
	 */
	public void setUpdatetime(LocalDate updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * Gets the reffrencecode.
	 *
	 * @return the reffrencecode
	 */
	public String getReffrencecode() {
		return reffrencecode;
	}

	/**
	 * Sets the reffrencecode.
	 *
	 * @param reffrencecode the new reffrencecode
	 */
	public void setReffrencecode(String reffrencecode) {
		this.reffrencecode = reffrencecode;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<InvitePlatform> getInvitePlatforms() {
		return invitePlatforms;
	}

	public void setInvitePlatforms(Set<InvitePlatform> invitePlatforms) {
		this.invitePlatforms = invitePlatforms;
	}

}
