package com.mb11.application.model.user;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Users.
 */
@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	/** The name. */
	@Column(length = 30)
	private String name;

	/** The email. */
	@Column(length = 50)
	private String email;

	private String imageUrl;

	/** The email verified. */
	@Column(name = "emailverified")
	private boolean emailVerified;

	/** The password. */
	@Column(length = 100)
	@JsonIgnore
	private String password;

	/** The mobilenumber. */
	@Column(length = 10)
	private String mobilenumber;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	/** The provider id. */
	@Column(name = "providerid", length = 100)
	private String providerId;

	/** The firstname. */
	@Column(length = 50)
	private String firstname;

	/** The middlename. */
	@Column(length = 50)
	private String middlename;

	/** The lastname. */
	@Column(length = 50)
	private String lastname;

	/** The dob. */
	private Date dob;

	/** The createtime. */
	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp createtime;

	/** The updatetime. */
	@UpdateTimestamp
	@Column(nullable = false)
	private Timestamp updatetime;

	/** The reffrencecode. */
	@Column(length = 50)
	private String reffrencecode;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"))
	private Collection<Role> roles;

	@OneToMany(mappedBy = "userid", cascade = CascadeType.ALL)
	private Set<Address> address;

	/**
	 * Instantiates a new users.
	 */
	public User() {

	}

	/**
	 * Instantiates a new users.
	 *
	 * @param name          the name
	 * @param email         the email
	 * @param imageUrl      the image url
	 * @param emailVerified the email verified
	 * @param password      the password
	 * @param mobilenumber  the mobilenumber
	 * @param providerId    the provider id
	 * @param firstname     the firstname
	 * @param middlename    the middlename
	 * @param lastname      the lastname
	 * @param dob           the dob
	 * @param createtime    the createtime
	 * @param updatetime    the updatetime
	 * @param address       the address
	 * @param reffrencecode the reffrencecode
	 */
	public User(String name, String email, String imageUrl, boolean emailVerified, String password, String mobilenumber,
			String providerId, String firstname, String middlename, String lastname, Date dob, Timestamp createtime,
			Timestamp updatetime, String reffrencecode) {
		super();

		this.name = name;
		this.email = email;
		this.imageUrl = imageUrl;
		this.emailVerified = emailVerified;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.providerId = providerId;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.reffrencecode = reffrencecode;
	}

	/**
	 * Instantiates a new users.
	 *
	 * @param iD            the i D
	 * @param name          the name
	 * @param email         the email
	 * @param imageUrl      the image url
	 * @param emailVerified the email verified
	 * @param password      the password
	 * @param mobilenumber  the mobilenumber
	 * @param providerId    the provider id
	 * @param firstname     the firstname
	 * @param middlename    the middlename
	 * @param lastname      the lastname
	 * @param dob           the dob
	 * @param createtime    the createtime
	 * @param updatetime    the updatetime
	 * @param address       the address
	 * @param reffrencecode the reffrencecode
	 */
	public User(Long iD, String name, String email, String imageUrl, boolean emailVerified, String password,
			String mobilenumber, String providerId, String firstname, String middlename, String lastname, Date dob,
			Timestamp createtime, Timestamp updatetime, String reffrencecode) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.imageUrl = imageUrl;
		this.emailVerified = emailVerified;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.providerId = providerId;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.reffrencecode = reffrencecode;
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the createtime.
	 *
	 * @return the createtime
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}

	/**
	 * Sets the createtime.
	 *
	 * @param createtime the new createtime
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	/**
	 * Gets the updatetime.
	 *
	 * @return the updatetime
	 */
	public Timestamp getUpdatetime() {
		return updatetime;
	}

	/**
	 * Sets the updatetime.
	 *
	 * @param updatetime the new updatetime
	 */
	public void setUpdatetime(Timestamp updatetime) {
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

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
