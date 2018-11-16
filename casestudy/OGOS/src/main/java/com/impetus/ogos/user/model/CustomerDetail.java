package com.impetus.ogos.user.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * This class stores the details of the customers.
 * 
 */

@javax.persistence.Entity
@Table(name = "customer_detail")
public class CustomerDetail {

	@Id
	@Column(name = "customer_id")
	private String customerId;

	/**
	 * No args constructor. This constructor generates the unique id for each
	 * customer.
	 */
	public CustomerDetail() {
		this.customerId = UUID.randomUUID().toString();
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Transient
	private String userid;

	/** @return the userid. */
	public String getUserid() {
		return userid;
	}

	/** @return the user Object. */
	public User getUser() {
		return user;
	}

	/**
	 * @param user set the value of user
	 */
	public void setUser(User user) {

		this.user = user;
	}

	/**
	 * @param userid set the value of userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "house_no")
	private String houseNo;

	@Column
	private String landmark;

	@Column
	private String address;

	@Column(name = "contact_no")
	private String contactNo;

	@Column
	private String zipcode;

	/** @return the house no of the user. */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @param houseNo is the house no of the user.
	 * @return the object of the customer detail.
	 */
	public CustomerDetail setHouseNo(String houseNo) {
		this.houseNo = houseNo;
		return this;
	}

	/** @return the landmark. */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark is the landmark near by customer address.
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/** @return the address of the user. */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address is the address of the user.
	 * @return the object of the customer detail.
	 */
	public CustomerDetail setAddress(String address) {
		this.address = address;
		return this;
	}

	/** @return the contact no of the customer. */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo is the contact no of the customer.
	 * @return the object of the customer detail.
	 */
	public CustomerDetail setContactNo(String contactNo) {
		this.contactNo = contactNo;
		return this;
	}

	/** @return the zip code of the customer. */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode is the zip code of the customer.
	 * @return the object of the customer detail.
	 */
	public CustomerDetail setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}

	/** @return the unique customer id. */
	public String getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", user=" + user + ", userid=" + userid + ", houseNo="
				+ houseNo + ", landmark=" + landmark + ", address=" + address + ", contactNo=" + contactNo
				+ ", zipcode=" + zipcode + "]";
	}

}